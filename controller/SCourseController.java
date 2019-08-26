package com.ozc.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ozc.entity.SCourse;
import com.ozc.implem.ISCourseDao;

@Controller
@Scope("prototype")
public class SCourseController extends BaseController<SCourse> {

	@Autowired
	private ISCourseDao scoursedao;

	@RequestMapping("coursesel_list.do")
	public String list() throws Exception{
		Map<String,Object> param = new HashMap<>();
		if(commit==true){
			param.put("studentName", obj.getStudentName());
			param.put("courseName", obj.getCourseName());
			param.put("teacherName", obj.getTeacherName());
		}
		//查询总记录数
		getPage().setTotalRows(scoursedao.list(param).size());
		//把page传到Dao
		param.put("page", getPage());
		setList(scoursedao.list(param));
		return "scourse/list";
	}
	
	@RequestMapping("coursesel_add.do")
	public String add() throws Exception{
		int i = scoursedao.add(obj);
		setMsg(i>0?"添加操作成功":"添加操作失败");
		return "scourse/list";
	}
	
	@RequestMapping("coursesel_update.do")
	public String update() throws Exception {
		if(commit==false){
			obj = scoursedao.getObjById(obj.getId());
			return "scourse/update";
		}else{
			int i = scoursedao.update(obj);
			setMsg(i>0?"更新操作成功":"更新操作失败");
			return "scourse/list";
		}
	}
	
	@RequestMapping("coursesel_delete.do")
	public String delete() throws Exception{
		int i =scoursedao.delete(obj.getId());
		setMsg(i>0?"删除操作成功":"删除操作失败");
		return "scourse/list";
	}
	
}
