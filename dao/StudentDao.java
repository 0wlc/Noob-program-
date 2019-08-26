package com.ozc.dao;

import org.springframework.stereotype.Repository;

import com.ozc.entity.Student;
import com.ozc.implem.IStudentDao;

/**
 * 学生操作Dao
 * @author Administrator
 *
 */
@Repository
public class StudentDao extends BaseDao<Student> implements IStudentDao{
	
}
