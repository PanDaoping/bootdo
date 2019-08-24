package com.bootdo.product.dao;

import com.bootdo.product.domain.TbPlanTaskDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 计划任务表
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2019-06-27 11:29:22
 */
@Mapper
public interface TbPlanTaskDao {

	TbPlanTaskDO get(String planGuid);
	
	List<TbPlanTaskDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(TbPlanTaskDO tbPlanTask);
	
	int update(TbPlanTaskDO tbPlanTask);
	
	int remove(String plan_guid);
	
	int batchRemove(String[] planGuids);
}
