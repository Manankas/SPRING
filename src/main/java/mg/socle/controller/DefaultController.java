package mg.socle.controller;

import java.util.Collection;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import mg.socle.utils.ViewName;

@Controller
public class DefaultController {

	@GetMapping("/")
	public String homePage() {
		final Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null && auth.getAuthorities() != null) {
			Collection<? extends GrantedAuthority> roles = auth.getAuthorities();
			for (GrantedAuthority grantedAuthority : roles) {
				if (grantedAuthority.getAuthority().equals("ROLE_ADMIN")) {
					return ViewName.PAGE_INDEX;
				}
			}
		}
		return "/login";
	}

	@GetMapping("/home")
	public String home() {
		return "/home";
	}

	@GetMapping("/admin")
	public String admin() {
		return "/admin";
	}

	@GetMapping("/user")
	public String user() {
		return "/user";
	}

	@GetMapping("/about")
	public String about() {
		return "/about";
	}

	@GetMapping("/login")
	public String login() {
		final Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null && auth.getAuthorities() != null) {
			Collection<? extends GrantedAuthority> roles = auth.getAuthorities();
			for (GrantedAuthority grantedAuthority : roles) {
				if (grantedAuthority.getAuthority().equals("ROLE_ADMIN")) {
					return ViewName.PAGE_INDEX;
				}
			}
		}
		return "/login";
	}

	@GetMapping("/403")
	public String error403() {
		return "/error/403";
	}

}
