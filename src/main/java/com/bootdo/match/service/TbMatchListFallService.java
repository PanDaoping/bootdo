package com.bootdo.match.service;

import com.bootdo.match.domain.TbMatchListFallDO;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2019-07-13 16:47:23
 */
public interface TbMatchListFallService {
	
	TbMatchListFallDO get(String matchListGuid);
	
	List<TbMatchListFallDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(TbMatchListFallDO tbMatchListFall);
	
	int update(TbMatchListFallDO tbMatchListFall);
	
	int remove(String matchListGuid);
	
	int batchRemove(String[] matchListGuids);
}
