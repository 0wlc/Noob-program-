package com.ozc.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ozc.entity.Student;
import com.ozc.implem.IStudentDao;

@Controller
@Scope("prototype")
public class StudentController extends BaseController<Student> {
	@Autowired
	private	IStudentDao studentdao;

	@RequestMapping("student_list.do")
	public String list() throws Exception{
		Map<String,Object> param = new HashMap<>();
		if (commit==true) {
			param.put("name", obj.getName());
			param.put("className", obj.getClassName());
			param.put("sex", obj.getSex());
		}
		//查询总记录数
		getPage().setTotalRows(studentdao.list(param).size());
		//把page传到Dao
		param.put("page", getPage());
		setList(studentdao.list(param));
		return "student/list";
	}
	
	@RequestMapping("student_tlist.do")
	public String tlist() throws Exception{
		Map<String,Object> param = new HashMap<>();
		if (commit==true) {
			param.put("name", obj.getName());
			param.put("className", obj.getClassName());
			param.put("sex", obj.getSex());
		}
		//查询总记录数
		getPage().setTotalRows(studentdao.list(param).size());
		//把page传到Dao
		param.put("page", getPage());
		setList(studentdao.list(param));
		return "student/tlist";
	}
	
	@RequestMapping("student_add.do")
	public String add() throws Exception{
		int i = studentdao.add(obj);
		setMsg(i>0?"添加操作成功":"添加操作失败");
		return "studentlist";
	}
	
	@RequestMapping("student_update.do")
	public String update() throws Exception{
		if(commit==false){//请求转发
			obj = studentdao.getObjById(obj.getId());
			return "student/update";
		}else{//更新操作
			int i = studentdao.update(obj);
			setMsg(i>0?"更新操作成功":"更新操作失败");
			return "student/list";
		}
	}
	
	@RequestMapping("student_delete.do")
	public String delete() throws Exception{
		int i = studentdao.delete(obj.getId());
		setMsg(i>0?"删除操作成功":"删除操作失败");
		return "student/list";
	}
}