package com.gif.eting.util;

import java.io.File;

import javax.servlet.ServletContext;

import org.springframework.stereotype.Component;

import com.notnoop.apns.APNS;
import com.notnoop.apns.ApnsService;

@Component
public class ApnsHelper {

	public static void sendApns(ServletContext context, String deviceToken, String jsonKey, String jsonString, String alert) {
		final String rootPath = context.getRealPath("");
		final String certPath = rootPath + File.separator + "cert" + File.separator
				+ "eting_apns_cert_passwd.p12";
		final String certPassword = "eting00";		

		ApnsService service = APNS.newService()
				.withCert(certPath, certPassword).withSandboxDestination()
				.build();

		String payload = APNS
				.newPayload()
				.badge(12)
				.customField(jsonKey, jsonString)
				.alertBody(alert).actionKey("View")
				.build();

		service.push(deviceToken, payload);
		service.testConnection();
	}
}
