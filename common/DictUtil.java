package com.ozc.common;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.ozc.entity.Dict;
import com.ozc.entity.Menu;
import com.ozc.entity.Role;
import com.ozc.implem.IDictDao;
import com.ozc.implem.IMenuDao;
import com.ozc.implem.IRoleDao;
/**
 * 数据字典处理工具类
 * @author zc
 */
@Controller
public class DictUtil {
	/**
	 * 加载字典数据到上下文
	 * @param sc
	 */
	public static void refreshDict(ServletContext sc){
		System.out.println("刷新系统字典数据...");
		//获取web应用中的spring容器
		ApplicationContext ac = WebApplicationContextUtils.getWebApplicationContext(sc);
		IDictDao dictDao = (IDictDao) ac.getBean("dictDao");
		Map<String,Object> param = new HashMap<>();
		param.put("useFlag",1);
		List<Dict> list = dictDao.list(param);
		//<字典名称,<字典key,字典value>>
		Map<String,Map<String,String>> allMap = 
		new HashMap<String, Map<String,String>>();
		// 循环字典列表，按照字典名称对所有字典进行分类
		for (Dict d : list) {
			String name = d.getName();
			Map<String, String> m = allMap.get(name);
			if (m != null) {
				m.put(d.getDkey(), d.getDval());
			} else {
				// 有顺序的map
				m = new LinkedHashMap<String, String>();
				m.put(d.getDkey(), d.getDval());
				allMap.put(name, m);
			}
		}
		//循环字典并按字典名称放到应用上下文
		for (String dn : allMap.keySet()) {
			System.out.println(dn+" :" + allMap.get(dn));
			sc.setAttribute(dn, allMap.get(dn));
		}
	}
	
	
	/**
	 * 加载角色数据到上下文
	 * @param sc
	 */
	public static void refreshRole(ServletContext sc){
		System.out.println("刷新角色数据...");
		//获取web应用中的spring容器
		ApplicationContext ac = WebApplicationContextUtils.getWebApplicationContext(sc);
		IRoleDao roleDao = (IRoleDao) ac.getBean("roleDao");
		Map<String,Object> param = new HashMap<>();
		List<Role> list = roleDao.list(param);
		//Map<id,name>
		Map<String,String> roleMap = new HashMap<>();
		for (Role r : list) {
			roleMap.put(r.getId()+"", r.getName());
		}
		System.out.println("角色字典数据:" + roleMap);
		sc.setAttribute("roleMap",roleMap);		
	}
	
	/**
	 * 加载父菜单数据到上下文
	 * @param sc
	 */
	public static void refreshPmenu(ServletContext sc){
		System.out.println("刷新父菜单数据...");
		//获取web应用中的spring容器
		ApplicationContext ac = WebApplicationContextUtils.getWebApplicationContext(sc);
		IMenuDao menuDao = (IMenuDao) ac.getBean("menuDao");
		Map<String,Object> param = new HashMap<>();
		List<Menu> list = menuDao.list(param);
		Map<String,String> pmMap = new HashMap<>();
		for (Menu m : list) {
			if(m.getMlevel()!=3){
				pmMap.put(m.getId()+"", m.getName());
			}
		}
		System.out.println("一二级菜单:" + pmMap);
		sc.setAttribute("pmMap",pmMap);
		
	}
}
