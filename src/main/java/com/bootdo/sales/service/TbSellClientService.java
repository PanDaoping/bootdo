package com.bootdo.sales.service;

import com.bootdo.sales.domain.TbSellClientDO;

import java.util.List;
import java.util.Map;

/**
 * 客户信息表
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2019-04-12 14:24:57
 */
public interface TbSellClientService {
	
	TbSellClientDO get(String clientGuid);
	
	List<TbSellClientDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(TbSellClientDO tbSellClient);
	
	int update(TbSellClientDO tbSellClient);
	
	int remove(String clientGuid);
	
	int batchRemove(String[] clientGuids);

	String findClietCode();
}
