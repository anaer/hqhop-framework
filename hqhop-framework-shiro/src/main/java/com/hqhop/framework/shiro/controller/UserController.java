package com.hqhop.framework.shiro.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

	@RequestMapping(value = "/login")
	public String showLoginForm(HttpServletRequest req, Model model) {
		System.out.println("showLoginForm....");
		String exceptionClassName = (String) req.getAttribute("shiroLoginFailure");
		String error = null;
		System.out.println("exceptionClassName:" + exceptionClassName);
		if (exceptionClassName != null) {
			error = "登录失败，用户名或密码不存在！";
		}
		model.addAttribute("error", error);
		return "login";
	}

}
