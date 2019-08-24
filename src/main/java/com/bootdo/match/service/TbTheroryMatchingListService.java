package com.bootdo.match.service;

import com.bootdo.match.domain.TbTheroryMatchingListDO;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2019-07-10 15:56:58
 */
public interface TbTheroryMatchingListService {
	
	TbTheroryMatchingListDO get(String theroryListGuid);
	
	List<TbTheroryMatchingListDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(TbTheroryMatchingListDO tbTheroryMatchingList);
	
	int update(TbTheroryMatchingListDO tbTheroryMatchingList);
	
	int remove(String theroryListGuid);
	
	int batchRemove(String[] theroryListGuids);
}
