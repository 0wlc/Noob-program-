package com.ozc.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
/**
 * 登录验证拦截器类
 * @author Administrator
 */
public class LoginInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object arg2) throws Exception {
		// 获取会话
		HttpSession session = request.getSession();
		
		String uri = request.getRequestURI();;
		System.out.println("有请求经过:" + uri);
		
		if (null != session.getAttribute("user")) {// 判断是否
			return true;//放行
		} else {
			request.setAttribute("msg","尚未登录，没有操作权限");
			System.out.println("被拦截路径:" + request.getRequestURI());
			request.getRequestDispatcher("/common/login.jsp")
			.forward(request, response);
			return false;
		}
	}
	@Override
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {

	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {

	}

}
