package com.ozc.dao;

import org.springframework.stereotype.Repository;

import com.ozc.entity.Teacher;
import com.ozc.implem.ITeacherDao;

/**
 * 教师操作Dao
 * @author Administrator
 *
 */
@Repository
public class TeacherDao extends BaseDao<Teacher> implements ITeacherDao{
	
}
