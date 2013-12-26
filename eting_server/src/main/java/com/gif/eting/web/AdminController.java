package com.gif.eting.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.View;

import com.gif.eting.dao.AdminMsgMapper;
import com.gif.eting.dao.StoryMapper;
import com.gif.eting.dto.AdminMsg;
import com.gif.eting.dto.PhoneDTO;
import com.gif.eting.util.HttpUtil;

@Controller
public class AdminController {
	Logger log = LoggerFactory.getLogger(AdminController.class);

	@Autowired
	@Qualifier(value = "jsonView")
	private View jsonView;	

	@Autowired
	StoryMapper storyMapper;
	
	@Autowired
	AdminMsgMapper adminMsgMapper;

	@RequestMapping(value = "/admin/main")
	public String adminMain() {
		return "admin/main";
	}
	
	/**
	 * 관리자 알림메세지 전송
	 * 
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/admin/sendAdminMsg")
	public View sendAdminMsg(HttpServletRequest request, Model model){
		//사용자에게 알림메세지를 보낸다
		//TODO 보낼 사용자는 임시로 지정

		
		String isTest = request.getParameter("isTest");
		String isNoti = request.getParameter("isNoti");
		if(isNoti == null){
			isNoti = "N";
		}
		String msgContent = request.getParameter("msg_content");
		
		log.info("isTest = "+isTest);
		log.info("isNoti = "+isNoti);
		
		AdminMsg msg = new AdminMsg();
		msg.setMsg_content(msgContent);
		
		//관리자메세지 저장
		adminMsgMapper.insAdminMsg(msg);
		String msgId = msg.getMsg_id();
		
		//테스트구분
		if("Y".equals(isTest)){
			String regId = "APA91bHVxAZTrmv-IHmRCIG9rPEMTuQqaL051CkK2EO8ujtqL2OOa_qprI16ZMTAOEy3p93qfbiYBlR7gC-knBGcPWc-mx8KRbBIHHbZaRfea5Fnv6mQkYhC6Hs5P6y0N30h0NE2TPd78rRD0Aj2YWAnQSYQ9CBSrQ";
			
			HttpUtil http = new HttpUtil();
			Map<String, String> map = new HashMap<String, String>();
			map.put("registration_id", regId);
			map.put("data.type", "Admin");
			map.put("data.msgId", msgId);
			map.put("data.content", msgContent);
			map.put("data.isNoti", isNoti);
			String response = http.doGcm("https://android.googleapis.com/gcm/send", map);
			log.debug("GCM sendAdminMsg = "+response);
			
			return jsonView;
		}

		List<PhoneDTO> phoneList = storyMapper.getPhoneRegistrationList();
		for(PhoneDTO phone : phoneList){
			String regId = phone.getReg_id();
			
			HttpUtil http = new HttpUtil();
			Map<String, String> map = new HashMap<String, String>();
			map.put("registration_id", regId);
			map.put("data.msgId", msgId);
			map.put("data.content", msgContent);
			map.put("data.isNoti", isNoti);
			String response = http.doGcm("https://android.googleapis.com/gcm/send", map);
			log.info("GCM sendAdminMsg = " + phone.getPhone_id() + " "
					+ response);
		}
	
		model.addAttribute("result", "Y");
		
		return jsonView;
	}
	
	/**
	 * 알림메세지에 대한 코멘트
	 */
	@RequestMapping(value = "/sendAdminMsgComment")
	public View sendAdminMsgComment(HttpServletRequest request, Model model){
		String msgId = request.getParameter("msgId");
		String comment = request.getParameter("comment");
		
		try{
			Integer.parseInt(msgId);
		}catch(NumberFormatException e){
			msgId = "1";
		}
		
		AdminMsg msg = new AdminMsg();
		msg.setMsg_id(msgId);
		msg.setMsg_comment(comment);		
		
		adminMsgMapper.insAdminMsgComment(msg);
		log.info("#msg comment = #\t"+msgId+" , "+comment);
		
		return jsonView;
	}

}
