package com.ozc.dao;

import org.springframework.stereotype.Repository;

import com.ozc.entity.Score;
import com.ozc.implem.IScoreDao;

/**
 * 学生成绩操作Dao
 * @author Administrator
 *
 */
@Repository
public class ScoreDao extends BaseDao<Score> implements IScoreDao{
	
}
