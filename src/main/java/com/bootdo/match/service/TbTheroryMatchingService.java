package com.bootdo.match.service;

import com.bootdo.match.domain.TbTheroryMatchingDO;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2019-07-04 14:45:47
 */
public interface TbTheroryMatchingService {
	
	TbTheroryMatchingDO get(String theoryGuid);
	
	List<TbTheroryMatchingDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(Map<String, Object> map);
	
	int update(Map<String, Object> map);
	
	int remove(String theoryGuid);
	
	int batchRemove(String[] theoryGuids);
}
