package com.ozc.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ozc.entity.Menu;
import com.ozc.implem.IMenuDao;

@Controller
@Scope("prototype")
public class MenuController extends BaseController<Menu> {
	@Autowired
	private IMenuDao menudao;
	
	@RequestMapping("menu_list.do")
	public String list() throws Exception {
		Map<String,Object> param = new HashMap<>();
		if (commit==true) {
			param.put("name", obj.getName());
			param.put("pid", obj.getPid());
			param.put("mlevel",obj.getMlevel());
		}
		//查询总记录数
		getPage().setTotalRows(menudao.list(param).size());
		//把page传到Dao
		param.put("page", getPage());
		setList(menudao.list(param));
		return "menu/list";
	}
	
	@RequestMapping("menu_add.do")
	public String add() throws Exception {
		int i = menudao.add(obj);
		setMsg(i>0?"添加操作成功":"添加操作失败");
		return "menu/list";
	}
	
	@RequestMapping("menu_update.do")
	public String update() throws Exception {
		if(commit==false){//请求转发
			obj = menudao.getObjById(obj.getId());
			return "menu/update";
		}else{//更新操作
			int i = menudao.update(obj);
			setMsg(i>0?"更新操作成功":"更新操作失败");
			return "menu/list";
		}
	}
	
	@RequestMapping("menu_delete.do")
	public String delete() throws Exception {
		int i = menudao.delete(obj.getId());
		setMsg(i>0?"删除操作成功":"删除操作失败");
		return "menu/list";
	}

}