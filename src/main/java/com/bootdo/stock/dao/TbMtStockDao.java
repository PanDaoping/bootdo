package com.bootdo.stock.dao;

import com.bootdo.stock.domain.TbMtStockDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 资产（材料）库存表
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2019-04-12 14:20:07
 */
@Mapper
public interface TbMtStockDao {

	TbMtStockDO get(String mtCode);
	
	List<TbMtStockDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(TbMtStockDO tbMtStock);
	
	int update(TbMtStockDO tbMtStock);
	
	int remove(String mt_code);
	
	int batchRemove(String[] mtCodes);
}
