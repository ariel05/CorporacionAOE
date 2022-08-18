package com.corporacionaoe.app.controllers;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestWrapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.corporacionaoe.app.models.entity.Member;
import com.corporacionaoe.app.models.service.MemberService;
import com.corporacionaoe.app.util.paginator.PageRender;
import com.corporacionaoe.app.utils.Utils;

@Controller
public class HomeController {

	@Autowired
	private MessageSource messageSource;

	@Autowired
	@Qualifier("membersService")
	private MemberService memberService;

	protected final Log logger = LogFactory.getLog(this.getClass());

	@RequestMapping(value = {"/home", "/"}, method = RequestMethod.GET)
	public String listar(@RequestParam(name="page", defaultValue = "0") int page, Model model,
			Authentication authentication, HttpServletRequest request, Locale locale) {
		
		if(authentication != null) {
			logger.info("Usuario autenticado, username: ".concat(authentication.getName()));
		}
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();

		if(auth != null) {
			logger.info("Usuario autenticado (obtenido de forma estática), username: ".concat(auth.getName()));
		}
		
		if(Utils.hasRole("ROLE_ADMIN")) {
			logger.info("El usuario: ".concat(authentication.getName()).concat(" tiene acceso"));
		}
		else {
			logger.info("El usuario: ".concat(auth.getName()).concat(" NO tiene acceso"));
		}
		
		SecurityContextHolderAwareRequestWrapper securityContext = new SecurityContextHolderAwareRequestWrapper(request, "");
		
		if(securityContext.isUserInRole("ROLE_ADMIN")) {
			logger.info("El usuario: ".concat(authentication.getName()).concat(" tiene acceso | Usando SecurityContextHolderAwareRequestWrapper"));
		}
		else {
			logger.info("El usuario: ".concat(auth.getName()).concat(" NO tiene acceso | Usando SecurityContextHolderAwareRequestWrapper"));
		}
		
		
		if(request.isUserInRole("ROLE_ADMIN")) {
			logger.info("El usuario: ".concat(authentication.getName()).concat(" tiene acceso | Usando HttpServletRequest"));
		}
		else {
			logger.info("El usuario: ".concat(auth.getName()).concat(" NO tiene acceso | Usando HttpServletRequest"));
		}
		
		Pageable pageable = PageRequest.of(page, 5);
		Page<Member> members = memberService.findAll(pageable);
		PageRender<Member> pageRender = new PageRender<>("/home", members);
		
		model.addAttribute("titulo", messageSource.getMessage("text.home.titulo", null, locale));
		model.addAttribute("members", members);
		model.addAttribute("page", pageRender);
		return "home";
	}
}
