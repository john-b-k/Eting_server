package com.gif.eting.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;


/**
 * HTTP통신 유틸 한글문제 해결
 */
public class HttpUtil {
	/**
	 * POST 요청
	 * 
	 * @param url
	 *            요청할 url
	 * @param params
	 *            파라메터
	 * @param encoding
	 *            파라메터 Encoding
	 * @return 서버 응답결과 문자열
	 */
	public String post(String url, Map<String, String> params, String encoding) {
		HttpClient client = new DefaultHttpClient();

		try {
			HttpPost post = new HttpPost(url);
			System.out.println("POST : " + post.getURI());

			List<NameValuePair> paramList = convertParam(params);
			post.setEntity(new UrlEncodedFormEntity(paramList, encoding));

			ResponseHandler<String> rh = new BasicResponseHandler();

			return client.execute(post, rh);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			client.getConnectionManager().shutdown();
		}

		return "error";
	}

	public String post(String url, Map<String, String> params) {
		return post(url, params, "UTF-8");
	}
	
	public String doGcm(String url, Map<String, String> params) {
		HttpClient client = new DefaultHttpClient();

		try {
			HttpPost post = new HttpPost(url);			
			System.out.println("POST : " + post.getURI());
			
			/**
			 * 헤더설정
			 */
			post.setHeader("Authorization", "key=AIzaSyCU5QvXL3GO-0fVA_Obtma3c1vJBgbDOuE");
			post.setHeader("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");
			
			List<NameValuePair> paramList = convertParam(params);
			post.setEntity(new UrlEncodedFormEntity(paramList, "UTF-8"));
			
			HttpResponse response = client.execute(post);
			HttpEntity entity = response.getEntity();
			System.out.println(EntityUtils.toString(entity));
			
			return response.toString();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			client.getConnectionManager().shutdown();
		}

		return "error";
	}

	/**
	 * GET 요청 POST 와 동일
	 */
	public String get(String url, Map<String, String> params, String encoding) {
		HttpClient client = new DefaultHttpClient();

		try {
			List<NameValuePair> paramList = convertParam(params);
			HttpGet get = new HttpGet(url + "?"
					+ URLEncodedUtils.format(paramList, encoding));
			System.out.println("GET : " + get.getURI());

			ResponseHandler<String> rh = new BasicResponseHandler();

			return client.execute(get, rh);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			client.getConnectionManager().shutdown();
		}

		return "error";
	}

	public String get(String url, Map<String, String> params) {
		return get(url, params, "UTF-8");
	}

	private List<NameValuePair> convertParam(Map<String, String> params) {
		List<NameValuePair> paramList = new ArrayList<NameValuePair>();
		Iterator<String> keys = params.keySet().iterator();
		while (keys.hasNext()) {
			String key = keys.next();
			paramList.add(new BasicNameValuePair(key, params.get(key)
					.toString()));
		}

		return paramList;
	}
}