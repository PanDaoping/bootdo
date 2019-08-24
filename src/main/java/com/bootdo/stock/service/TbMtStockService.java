package com.bootdo.stock.service;

import com.bootdo.stock.domain.TbMtStockDO;

import java.util.List;
import java.util.Map;

/**
 * 资产（材料）库存表
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2019-04-12 14:20:07
 */
public interface TbMtStockService {
	
	TbMtStockDO get(String mtCode);
	
	List<TbMtStockDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(TbMtStockDO tbMtStock);
	
	int update(TbMtStockDO tbMtStock);
	
	int remove(String mtCode);
	
	int batchRemove(String[] mtCodes);
}
