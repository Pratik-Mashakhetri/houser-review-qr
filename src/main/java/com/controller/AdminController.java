package com.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.model.ReviewTemplate;

import jakarta.servlet.http.HttpSession;

@Controller
public class AdminController {

	private final String ADMIN_USERNAME = "Houser";
	private final String ADMIN_PASSWORD = "Houser@2026";

	@GetMapping("/admin/login")
	public String adminLoginPage() {
		return "admin-login";
	}

	@PostMapping("/admin/login")
	public String adminLogin(@RequestParam String username,
			@RequestParam String password,
			HttpSession session) {

		if (ADMIN_USERNAME.equals(username) && ADMIN_PASSWORD.equals(password)) {
			session.setAttribute("ADMIN_LOGGED_IN", true);
			return "redirect:/admin/dashboard";
		}

		return "redirect:/admin/login?error=true";
	}

	@GetMapping("/admin/dashboard")
	public String adminDashboard(HttpSession session) {
		Boolean loggedIn = (Boolean) session.getAttribute("ADMIN_LOGGED_IN");

		if (loggedIn == null || !loggedIn) {
			return "redirect:/admin/login";
		}

		return "admin-dashboard";
	}

	@GetMapping("/admin/logout")
	public String adminLogout(HttpSession session) {
		session.invalidate();
		return "redirect:/admin/login";
	}
	
	
	
	private List<ReviewTemplate> templates = new ArrayList<>();
	private int nextId = 1;

	@GetMapping("/admin/templates")
	public String reviewTemplates(HttpSession session, Model model) {
	    Boolean loggedIn = (Boolean) session.getAttribute("ADMIN_LOGGED_IN");

	    if (loggedIn == null || !loggedIn) {
	        return "redirect:/admin/login";
	    }

	    model.addAttribute("templates", templates);
	    return "admin-templates";
	}

	@PostMapping("/admin/templates/add")
	public String addTemplate(@RequestParam String category,
	                          @RequestParam String review) {

	    templates.add(new ReviewTemplate(nextId++, category, review));
	    return "redirect:/admin/templates";
	}

	@GetMapping("/admin/templates/delete/{id}")
	public String deleteTemplate(@PathVariable int id) {
	    templates.removeIf(t -> t.getId() == id);
	    return "redirect:/admin/templates";
	}
}


