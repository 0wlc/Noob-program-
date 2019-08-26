package com.ozc.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ozc.common.MD5;
import com.ozc.entity.Menu;
import com.ozc.entity.User;
import com.ozc.implem.IMenuDao;
import com.ozc.implem.IUserDao;

@Controller
@Scope("prototype")
public class SysController extends BaseController<User> {
	@Autowired
	private IUserDao userdao;
	@Autowired
	private IMenuDao menudao;

	@RequestMapping("sys_login.do")
	public String login() throws Exception {
		Map<String,Object> param = new HashMap<>();
		try {
			param.put("username", obj.getUsername());
			param.put("password", MD5.md5(obj.getPassword()+obj.getUsername()));
		} catch (Exception e) {
			setMsg("还没有登录呢！");
			return "common/login";
		}
		List<User> list = userdao.list(param);
		if(list.size()>0){
			User u = list.get(0);
			if(u.getLoginFlag() == 1){//有权限登录
				HttpSession session = req.getSession();
				session.setAttribute("user", u);
				//查询当前用户的角色(权限)
				List<Menu> uList = menudao.getMenusByRoleId(u.getRoleId());
				
				//<父菜单对象，父菜单对应下的子菜单集合>
				Map<Menu,List<Menu>> map = new TreeMap<Menu,List<Menu>>();
				//装父菜单的临时map<父菜单ID,父菜单对象>
				Map<Long,Menu> temp = new HashMap<Long,Menu>();
				for (Menu menu : uList) {
					if(menu.getMlevel()==1){//一级菜单
						//System.out.println(menu);
						temp.put(menu.getId(),menu);
						map.put(menu,new ArrayList<Menu>());
					}
				}
				
				for (Menu menu : uList) {
					if(menu.getMlevel()==2){
						Menu pm = temp.get(menu.getPid());//父菜单对象
						List<Menu> sList = map.get(pm);//根据父菜单对象获取装它对应子菜单的集合
						if(sList!=null){
							sList.add(menu);
						}
					}
				}
				//System.out.println("用户菜单:"+map);
				session.setAttribute("uMenu",map);
				return "common/index";
			}else{
				setMsg("用户无效！");
			}
		}else{
			setMsg("用户名或密码有误");
		}
		return "common/login";
	}
	
	@RequestMapping("sys_register.do")
	public String register() throws Exception{
		try {
			obj.setUsername(obj.getUsername());
			obj.setPassword(MD5.md5(obj.getPassword()+obj.getUsername()));
			obj.setLoginFlag(2);
			obj.setRoleId(1L);
			obj.setFilePath("");
		} catch (Exception e) {
			setMsg("还没有登录呢！");
			return "common/login";
		}
		int i = userdao.add(obj);
		setMsg(i>0?"用户注册成功！":"用户注册失败...");
		return "common/login";
	}
	
	@RequestMapping("sys_logout.do")
	public String logout() throws Exception{
		HttpSession session = req.getSession();
		//移除用户会话记录
		session.removeAttribute("user");
		//会话无效化
		session.invalidate();
		setMsg("用户退出系统");
		return "common/login";
	}
}