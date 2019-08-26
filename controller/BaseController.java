package com.ozc.controller;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.ozc.common.Page;
/**
 * action基类
 * @author zc
 */
@Controller
public class BaseController<E>{
	ServletContext sc;
	HttpServletRequest req;
	HttpServletResponse resp;
	HttpSession session;
	//请求参数
	E obj;
	//响应参数
	Map<String,Object> rm;
	boolean commit;
	private Page page;
	
	@ModelAttribute
	public void before(E obj,boolean commit,Page page,
					   //Model model,
					   HttpServletRequest request,
			           HttpServletResponse response,
			           Map<String,Object> rMap){
		System.out.println("------------------Controller前置处理()-------------------");
		this.req = request;
		this.resp = response;
		this.session = req.getSession();
		this.sc = request.getServletContext();
		this.obj = obj;
		this.rm = rMap;
		this.commit = commit;
		this.page = page;
		//model.addAttribute("obj", obj);
		rm.put("command",obj);//为了信息回显
	}
	
	/**
	 * 异常处理类
	 * @param e
	 * @return
	 */
	@ExceptionHandler
	public ModelAndView exceptionHandler(Exception e){
		ModelAndView mv = new ModelAndView("common/exception");
		//把异常堆栈写到字符串对象中
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		e.printStackTrace(pw);
		mv.addObject("msg",e.toString());//异常摘要
		mv.addObject("exceptionStack",sw.toString());//异常详情
		return mv;
	}
	
	//设置返回页面的提示信息
	public void setMsg(String msg){
		rm.put("msg",msg);
	}
	//设置返回页面的数据集合
	public void setList(List<E> list){
		rm.put("list",list);
	}
	public Page getPage() {
		if(page == null){
			page = new Page();
		}
		rm.put("page", page);
		return page;
	}
	
	/**
	 * 做页面跳转
	 * @param url
	 * @return
	 */
	/*@RequestMapping("tp")
	public String toPage(String url){
		return url;
	}*/
	
	//类型转换器绑定
	@InitBinder
	public void initBinder(WebDataBinder binder){
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(format,true));
		//PropertyEditor propertyEditor = new CustomDateEditor(dateFormat, true);
		//binder.registerCustomEditor(Date.class, propertyEditor);
	}
}
