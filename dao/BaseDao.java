package com.ozc.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.github.pagehelper.PageHelper;
import com.ozc.common.Page;
import com.ozc.implem.IBaseDao;

/**
 * 基本操作Dao
 * @author Administrator
 *
 */
public class BaseDao<E> extends SqlSessionDaoSupport implements IBaseDao<E>{
	@Resource
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate){
		//注入Mybatis操作模板
		super.setSqlSessionTemplate(sqlSessionTemplate);
	}
	//Mapper命名
	public String getNs(String method){
		String className = this.getClass().getSimpleName();
		String name = className.substring(0,className.length()-3)+"Mapper."+method;
		System.out.println("命名空间:" + name);
		return name;
	}
	
	@Override
	public List<E> list(Map<String, Object> param) {
		String className = this.getClass().getSimpleName();
		String name = className.substring(0,className.length()-3);
		//以实体类名为Key放到Map中
		Map<String,Object> map = new HashMap<String, Object>();
		map.put(name, param);
		//获取common包中设置的分页信息
		Page page = (Page) param.get("page");
		//System.out.println("Page:" + page);
		if(page!=null){
			//System.out.println("Page-当前页：" + page.getCurrentPage());
			//System.out.println("Page-每页行数：" + page.getRowsPerPage());
			PageHelper.startPage(page.getCurrentPage(), page.getRowsPerPage());
		}
		//分页处理
		List<E> list = this.getSqlSession().selectList(getNs("findList"), map);
		if(page!=null){//返回总记录数
			page.setTotalRows((int)((com.github.pagehelper.Page<E>)list).getTotal());
		}
		return list;
	}

	@Override
	public E getObjById(Long id) {
		E obj = this.getSqlSession().selectOne(getNs("findById"),id);
		return obj;
	}

	@Override
	public int add(E obj) {
		int i = this.getSqlSession().insert(getNs("add"),obj);
		return i;
	}

	@Override
	public int update(E obj) {
		int i = this.getSqlSession().update(getNs("update"),obj);
		return i;
	}

	@Override
	public int delete(Long id) {
		int i = this.getSqlSession().delete(getNs("deleteById"),id);
		return i;
	}
	
}
