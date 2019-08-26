package com.ozc.common;


import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

/**
 * 系统初始化
 * @author Administrator
 *
 */
@WebServlet(urlPatterns="/init",loadOnStartup=1)
public class InitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("-----------系统初始化-----------");
		ServletContext sc = config.getServletContext();
		String root = sc.getContextPath();
		sc.setAttribute("_cxt", root);
		sc.setAttribute("_css", root + "/ui/css");
		sc.setAttribute("_js", root + "/ui/js");
		sc.setAttribute("_img", root + "/ui/img");
		sc.setAttribute("_plugins", root + "/ui/plugins");
		sc.setAttribute("_title", "Version6.0(SpingMvc+Spring+Mybatis)");
		
		DictUtil.refreshDict(sc);
		DictUtil.refreshPmenu(sc);
		DictUtil.refreshRole(sc);
	}
}
