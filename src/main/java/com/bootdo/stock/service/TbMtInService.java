package com.bootdo.stock.service;

import com.bootdo.stock.domain.TbMtInDO;

import java.util.List;
import java.util.Map;

/**
 * 订单表
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2019-04-12 14:20:06
 */
public interface TbMtInService {
	
	Map get(String orderGuid);
	
	List<Map> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(Map<String, Object> map);
	
	int update(Map<String,Object> map);
	
	int remove(String orderGuid);
	
	int batchRemove(String[] orderGuids);

	String getNewCode(Map<String,Object> map);
}
