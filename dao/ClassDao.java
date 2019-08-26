package com.ozc.dao;

import org.springframework.stereotype.Repository;

import com.ozc.entity.Class;
import com.ozc.implem.IClassDao;

/**
 * 班级操作Dao
 * @author Administrator
 *
 */
@Repository
public class ClassDao extends BaseDao<Class> implements IClassDao{

}
