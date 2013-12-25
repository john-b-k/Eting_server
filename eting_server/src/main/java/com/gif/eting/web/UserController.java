package com.gif.eting.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.View;

import com.gif.eting.dao.UserMapper;
import com.gif.eting.dto.User;
import com.gif.eting.util.Encript;

@Controller
public class UserController {
	Logger log = LoggerFactory.getLogger(UserController.class);

	@Autowired
	@Qualifier(value = "jsonView")
	private View jsonView;
	
	@Autowired
	UserMapper userMapper;

	@RequestMapping(value = "/login")
	public String login() {
		return "login";
	}

	@RequestMapping(value = "/loginProcess")
	public void loginProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		String userId = request.getParameter("userId");
		String password = request.getParameter("password");
		
		User user = userMapper.getUserInfo(userId);
		if(user == null){
			log.info("no user id!!");
			request.getRequestDispatcher("/login").forward(request, response);
			return;
		}
		
		String comparePassword = Encript.toSHA256(password);
		String comparedToPassword = user.getPassword();
		
		log.info("comparePassword = "+comparePassword);
		log.info("comparedToPassword = "+comparedToPassword);
		
		if(!comparePassword.equals(comparedToPassword)){
			log.info("login failed!!");
			request.getRequestDispatcher("/login").forward(request, response);
			return;
		}
		
		session.setAttribute("userId", userId);
		session.setAttribute("user", user);
		
		request.getRequestDispatcher("/admin/main").forward(request, response);
		return;
	}

}
