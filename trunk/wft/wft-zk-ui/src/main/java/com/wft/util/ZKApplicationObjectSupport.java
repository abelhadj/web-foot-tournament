package com.wft.util;

import org.springframework.web.context.support.WebApplicationObjectSupport;

public class ZKApplicationObjectSupport extends WebApplicationObjectSupport {
	
	public String getMessage(String key) {
		return getMessageSourceAccessor().getMessage(key);
	}
	
	public String getMessage(String key, String... args) {
		return getMessageSourceAccessor().getMessage(key, args);
	}

}
