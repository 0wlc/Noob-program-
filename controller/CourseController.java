package com.ozc.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ozc.entity.Course;
import com.ozc.implem.ICourseDao;

@Controller
public class CourseController extends BaseController<Course> {

	@Autowired
	private ICourseDao coursedao;
	
	@RequestMapping("course_list.do")
	public String list() throws Exception{
		Map<String,Object> param = new HashMap<>();
		if(commit==true){
			param.put("name", obj.getName());
			param.put("teacherName", obj.getTeacherName());
			param.put("schTerm", obj.getSchTerm());
		}
		getPage().setTotalRows(coursedao.list(param).size());
		param.put("page", getPage());
		setList(coursedao.list(param));
		return "course/list";
	}
	
	@RequestMapping("course_clist.do")
	public String clist() throws Exception{
		Map<String,Object> param = new HashMap<>();
		if(commit==true){
			param.put("name", obj.getName());
			param.put("teacherName", obj.getTeacherName());
			param.put("schTerm", obj.getSchTerm());
		}
		getPage().setTotalRows(coursedao.list(param).size());
		param.put("page", getPage());
		setList(coursedao.list(param));
		return "course/clist";
	}
	
	@RequestMapping("course_add.do")
	public String add() throws Exception{
		int i = coursedao.add(obj);
		setMsg(i>0?"添加操作成功":"添加操作失败");
		return "course/list";
	}
	
	@RequestMapping("course_update.do")
	public String update() throws Exception{
		if(commit==false){
			obj = coursedao.getObjById(obj.getId());
			return "course/update";
		}
		else{
			int i = coursedao.update(obj);
			setMsg(i>0?"更新操作成功":"更新操作失败");
			return "course/list";
		}
	}
	
	@RequestMapping("course_delete.do")
	public String delete() throws Exception{
		int i = coursedao.delete(obj.getId());
		setMsg(i>0?"删除操作成功":"删除操作失败");
		return "course/list";
	}

}
