package com.module.faces.geral;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class FilterJapp
 */
//@WebFilter("/FilterJapp")
public class FilterJapp implements Filter {

    /**
     * Default constructor. 
     */
    public FilterJapp() {
        
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
 
        //
        // Check to see if user's session attribute contains an attribute
        // named AUTHENTICATED. If the attribute is not exists redirect
        // user to the login page.
        //
//        if (//!request.getRequestURI().endsWith("login.jsf") &&
//        		!request.getRequestURI().endsWith(".css") && 
//        		!request.getRequestURI().endsWith(".ecss") &&
//        		(request.getRequestURI().endsWith(".jsf") || request.getRequestURI().endsWith(".xhtml")) &&
//                request.getSession().getAttribute("AUTHENTICATED") == null) {
//            response.sendRedirect(request.getContextPath() + "/pages/login.xhtml");
//        }
		chain.doFilter(request, response);

	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
