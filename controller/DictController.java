package com.ozc.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ozc.common.DictUtil;
import com.ozc.entity.Dict;
import com.ozc.implem.IDictDao;

@Controller
@Scope("prototype")
public class DictController extends BaseController<Dict> {
	@Autowired
	private IDictDao dictdao;
	
	@RequestMapping("dict_list.do")
	public String list() throws Exception {
		Map<String,Object> param = new HashMap<>();
		if (commit==true) {
			param.put("name", obj.getName());
			param.put("dkey", obj.getDkey());
			param.put("useFlag", obj.getUseFlag());
		}
		//查询总记录数
		getPage().setTotalRows(dictdao.list(param).size());
		//分页对象传到Dao
		param.put("page", getPage());
		setList(dictdao.list(param));
		return "dict/list";
	}
	
	@RequestMapping("dict_add.do")
	public String add() throws Exception {
		int i = dictdao.add(obj);
		setMsg(i>0?"添加操作成功":"添加操作失败");
		return "dict/list";
	}
	
	@RequestMapping("dict_update.do")
	public String update() throws Exception {
		if(commit==false){//请求转发
			obj = dictdao.getObjById(obj.getId());
			return "dict/update";
		}else{//更新操作
			int i = dictdao.update(obj);
			setMsg(i>0?"更新操作成功":"更新操作失败");
			return "dict/list";
		}
	}
	
	@RequestMapping("dict_delete.do")
	public String delete() throws Exception {
		int i = dictdao.delete(obj.getId());
		setMsg(i>0?"删除操作成功":"删除操作失败");
		return "dict/list";
	}
	
	@RequestMapping("dict_refresh.do")
	public String refresh() throws Exception {
		DictUtil.refreshDict(sc);
		DictUtil.refreshPmenu(sc);
		DictUtil.refreshRole(sc);
		setMsg("刷新缓存成功");
		return "dict/list";
	}
}