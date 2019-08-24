package com.bootdo.match.service;

import com.bootdo.match.domain.TbMatchFallDO;

import java.util.List;
import java.util.Map;

/**
 * 配比下发
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2019-07-13 16:47:23
 */
public interface TbMatchFallService {
	
	TbMatchFallDO get(String matchGuid);
	
	List<TbMatchFallDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(TbMatchFallDO tbMatchFall);
	
	int update(TbMatchFallDO tbMatchFall);
	
	int remove(String matchGuid);
	
	int batchRemove(String[] matchGuids);
}
