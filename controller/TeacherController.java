package com.ozc.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ozc.entity.Teacher;
import com.ozc.implem.ITeacherDao;

@Controller
@Scope("prototype")
public class TeacherController extends BaseController<Teacher> {
	@Autowired
	private ITeacherDao teacherdao;

	@RequestMapping("teacher_list.do")
	public String list() throws Exception{
		Map<String,Object> param = new HashMap<>();
		if (commit==true) {
			param.put("name", obj.getName());
			param.put("specialty", obj.getSpecialty());
			param.put("sex", obj.getSex());
			param.put("tlevel",obj.getTlevel());
		}
		//查询总记录数
		getPage().setTotalRows(teacherdao.list(param).size());
		//把page传到Dao
		param.put("page", getPage());
		setList(teacherdao.list(param));
		return "teacher/list";
	}
	
	@RequestMapping("teacher_tlist.do")
	public String tlist() throws Exception{
		Map<String,Object> param = new HashMap<>();
		if (commit==false) {
			param.put("name", obj.getName());
			param.put("specialty", obj.getSpecialty());
			param.put("sex", obj.getSex());
			param.put("tlevel",obj.getTlevel());
		}
		//查询总记录数
		getPage().setTotalRows(teacherdao.list(param).size());
		//把page传到Dao
		param.put("page", getPage());
		setList(teacherdao.list(param));
		return "teacher/tlist";
	}
	
	@RequestMapping("teacher_add.do")
	public String add() throws Exception{
		int i = teacherdao.add(obj);
		setMsg(i>0?"添加操作成功":"添加操作失败");
		return "teacher/list";
	}
	
	@RequestMapping("teacher_update.do")
	public String update() throws Exception{
		if(commit==false){//请求转发
			obj = teacherdao.getObjById(obj.getId());
			return "teacher/update";
		}else{//更新操作
			int i = teacherdao.update(obj);
			setMsg(i>0?"更新操作成功":"更新操作失败");
			return "teacher/list";
		}
	}
	
	@RequestMapping("teacher_delete.do")
	public String delete() throws Exception{
		int i = teacherdao.delete(obj.getId());
		setMsg(i>0?"删除操作成功":"删除操作失败");
		return "teacher/list";
	}
}