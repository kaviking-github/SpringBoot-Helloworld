package com.boot1.kavi.hello;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContext;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.boot1.kavi.User.UserDetails;


@RestController
public class HelloWorldController {

	@Autowired
	private ResourceBundleMessageSource messageSource;
	
	@RequestMapping(method=RequestMethod.GET, path="/hello")
	public String helloworld() {
		return "Hello World1";
	}
	
	@GetMapping("/getUserDetails")
	public UserDetails getUserDetails() {
		return new UserDetails("Kavi", "king", "Theni");
	}
	
	@GetMapping("/hello-int")
	public String getMessagesInI18NFormat(@RequestHeader(name="Accept-Language", required=false) String locale) {
		
		return messageSource.getMessage("label.hello", null,new Locale(locale));
	}
	
	@GetMapping("/hello-int2")
	public String getMessagesInI18NFormat2() {
		
		return messageSource.getMessage("label.hello", null,LocaleContextHolder.getLocale());
	}
}
