package com.ozc.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ozc.entity.Score;
import com.ozc.implem.IScoreDao;
/**
 * 成绩管理Servlet
 * @author Administrator
 *
 */
@Controller
@Scope("prototype")
public class ScoreController extends BaseController<Score> {

	@Autowired
	private IScoreDao scoreedao;

	@RequestMapping("score_list.do")
	public String list() throws Exception{
		Map<String,Object> param = new HashMap<>();
		if(commit==true){
			param.put("studentName", obj.getStudentName());
			param.put("courseName", obj.getCourseName());
			param.put("teacherName", obj.getTeacherName());
		}
		//查询总记录数
		getPage().setTotalRows(scoreedao.list(param).size());
		//把page传到Dao
		param.put("page", getPage());
		setList(scoreedao.list(param));
		return "score/list";
	}
	
	@RequestMapping("score_update.do")
	public String update() throws Exception {
		if(commit==false){
			obj = scoreedao.getObjById(obj.getId());
			return "score/update";
		}else{
			int i = scoreedao.update(obj);
			setMsg(i>0?"更新操作成功":"更新操作失败");
			return "score/list";
		}
	}
}