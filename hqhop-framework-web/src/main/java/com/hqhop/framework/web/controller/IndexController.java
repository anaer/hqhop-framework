package com.hqhop.framework.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hqhop.framework.common.bind.annotation.CurrentUser;
import com.hqhop.framework.shiro.entity.User;
import com.hqhop.framework.shiro.service.UserService;

@Controller
public class IndexController {

	@Autowired
	private UserService userService;

	@RequestMapping("/index")
	public String index(@CurrentUser User user, Model model) {
		System.out.println("login success...");
		System.out.println(user);
		model.addAttribute("message", "登录成功，欢迎...");
		return "welcome";
	}

	@RequestMapping("/test")
	public String test() {
		User user = new User();
		user.setName("silentwu333");
		user.setPassword("123456");
		user.setAge(24);
		User u = userService.save(user);
		return "welcome";
	}
}
