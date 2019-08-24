package com.bootdo.product.service;

import com.bootdo.product.domain.TbPlanTaskDO;

import java.util.List;
import java.util.Map;

/**
 * 计划任务表
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2019-06-27 11:29:22
 */
public interface TbPlanTaskService {
	
	TbPlanTaskDO get(String planGuid);
	
	List<TbPlanTaskDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(TbPlanTaskDO tbPlanTask);
	
	int update(TbPlanTaskDO tbPlanTask);
	
	int remove(String planGuid);
	
	int batchRemove(String[] planGuids);
}
