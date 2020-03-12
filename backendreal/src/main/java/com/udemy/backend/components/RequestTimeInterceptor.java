package com.udemy.backend.components;


import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.udemy.backend.entity.LogApp;
import com.udemy.backend.respositories.LogRepository;

// TODO: Auto-generated Javadoc
/**
 * The Class RequestTimeInterceptor.
 */
@Component("requestTimeInterceptor")
public class RequestTimeInterceptor extends HandlerInterceptorAdapter{

	/** The Constant LOGGER. */
	private static final Log LOGGER = LogFactory.getLog(RequestTimeInterceptor.class);
	
	/** The log repository. */
	@Autowired
	@Qualifier("logRepository")
	LogRepository logRepository;
	
	/**
	 * Pre handle.
	 *
	 * @param request the request
	 * @param response the response
	 * @param handler the handler
	 * @return true, if successful
	 * @throws Exception the exception
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		request.setAttribute("startTime", System.currentTimeMillis());
		
		return true;
	}

	/**
	 * After completion.
	 *
	 * @param request the request
	 * @param response the response
	 * @param handler the handler
	 * @param ex the ex
	 * @throws Exception the exception
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		
		long startTime = (long) request.getAttribute("startTime");
		String url = request.getRequestURL().toString();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		String username = "";
		if (auth != null && auth.isAuthenticated()) {
			auth.getName();
		}
		
		LogApp logApp = new LogApp(new Date(), auth.getDetails().toString(), username, url);
		logRepository.save(logApp);
		
		LOGGER.info("-- REQUEST URL: '" + url + 
				"' -- TOTAL TIME: " + (System.currentTimeMillis() - startTime) + " ms");
	}
	
	
	
}
