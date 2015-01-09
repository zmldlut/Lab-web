package cn.edu.dlut.chuangxin.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Authentication implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		
		HttpSession session = ((HttpServletRequest)request).getSession();
		//Cookie[] cookies = ((HttpServletRequest)request).getCookies();
		
		System.out.println(session.getAttribute("identity") + " " + ((HttpServletRequest) request).getRequestURI());
		
		if(session.getAttribute("identity") == null){
			session.setAttribute("identity", "user");
		}
		else if(session.getAttribute("identity").equals("admin")){
			chain.doFilter(request, response);
		}
		else if(((HttpServletRequest) request).getRequestURI().indexOf("/admin/") != -1){
			((HttpServletResponse)response).sendRedirect("http://star-pc:8080/StrutsTags/login.action");
		}
		else if(((HttpServletRequest) request).getRequestURI().endsWith(".jsp")){
			((HttpServletResponse)response).sendRedirect("http://star-pc:8080/StrutsTags/login.action");
		}
		else{
			chain.doFilter(request, response);
		}
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}
	
}
