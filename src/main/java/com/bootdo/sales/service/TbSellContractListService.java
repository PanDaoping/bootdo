package com.bootdo.sales.service;

import com.bootdo.sales.domain.TbSellContractListDO;

import java.util.List;
import java.util.Map;

/**
 * 销售合同明细
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2019-04-12 14:24:57
 */
public interface TbSellContractListService {
	
	TbSellContractListDO get(String listGuid);
	
	List<TbSellContractListDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(TbSellContractListDO tbSellContractList);
	
	int update(TbSellContractListDO tbSellContractList);
	
	int remove(String listGuid);
	
	int batchRemove(String[] listGuids);
}
