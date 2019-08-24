package com.bootdo.sales.service;

import com.bootdo.sales.domain.TbSellContractDO;

import java.util.List;
import java.util.Map;

/**
 * 销售合同
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2019-04-12 14:24:57
 */
public interface TbSellContractService {
	
	TbSellContractDO get(String contractGuid);
	
	List<TbSellContractDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(Map<String, Object> map);
	
	int update(Map<String, Object> map);
	
	int remove(String contractGuid);
	
	int batchRemove(String[] contractGuids);

	String findClietCode();
}
