package qisi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 首页API
 *
 * @author : ddv
 * @date : 2018/10/25 上午9:58
 */

@Controller
@RequestMapping("/pages")
public class PageController {

	@RequestMapping("/login")
	public String login() {
		return "login";
	}

	@RequestMapping("/register")
	public String register() {
		return "register";
	}

	@RequestMapping("/admin/login")
	public String adminLogin() {
		return "admin_login";
	}

}
