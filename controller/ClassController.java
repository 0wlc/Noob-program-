package com.ozc.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ozc.entity.Class;
import com.ozc.implem.IClassDao;

@Controller
@Scope("prototype")
public class ClassController extends BaseController<Class> {
	
	@Autowired
	private IClassDao classdao;

	@RequestMapping("class_list.do")
	public String list(){
		Map<String,Object> param = new HashMap<>();
		if (commit==true) {
			param.put("name", obj.getName());
			param.put("charger", obj.getCharger());
		}
		//查询总记录数
		getPage().setTotalRows(classdao.list(param).size());
		//把page传到Dao
		param.put("page", getPage());
		setList(classdao.list(param));
		return "class/list";
	}
	
	@RequestMapping("class_slist.do")
	public String slist(){
		Map<String,Object> param = new HashMap<>();
		if (commit==true) {
			param.put("name", obj.getName());
			param.put("charger", obj.getCharger());
		}
		//查询总记录数
		getPage().setTotalRows(classdao.list(param).size());
		//把page传到Dao
		param.put("page", getPage());
		setList(classdao.list(param));
		return "class/slist";
	}
	
	@RequestMapping("class_add.do")
	public String add() throws Exception{
		int i = classdao.add(obj);
		setMsg(i>0?"添加操作成功":"添加操作失败");
		return "class/list";
	}
	
	@RequestMapping("/update")
	public String update() throws Exception{
		if(commit==false){//请求转发
			obj = classdao.getObjById(obj.getId());
			return "class/update";
		}else{//更新操作
			int i = classdao.update(obj);
			setMsg(i>0?"更新操作成功":"更新操作失败");
			return "class/list";
		}
	}
	
	@RequestMapping("class_delete.do")
	public String delete() throws Exception{
		int i = classdao.delete(obj.getId());
		setMsg(i>0?"删除操作成功":"删除操作失败");
		return "class/list";
	}
}