package com.ozc.common;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.ozc.entity.User;
/**
 * 系统登录检查过滤器类
 * @author Administrator
 *
 */
@WebFilter(urlPatterns={"*.jsp"})
public class LoginFilter implements Filter {

	@Override
	public void doFilter(ServletRequest req, ServletResponse rep,
			FilterChain fc) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		String uri = request.getRequestURI();
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		if(user!=null || (user == null && uri.matches("^.+(login.jsp|register.jsp|/)$"))){
			fc.doFilter(req, rep);//放行(不拦截)
		}else{
			System.out.println("有请求拦截："+ uri);
			req.setAttribute("msg", "没有权限访问");
			//被拦截（处理），直接返回登陆页面
			//request.getServletContext().getRequestDispatcher(url)此处url为绝对路径。
			request.getServletContext().getRequestDispatcher("/common/login.jsp").forward(req, rep);
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}
