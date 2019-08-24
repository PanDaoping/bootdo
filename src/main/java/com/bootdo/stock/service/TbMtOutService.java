package com.bootdo.stock.service;

import com.bootdo.stock.domain.TbMtOutDO;

import java.util.List;
import java.util.Map;

/**
 * 资产（材料）领用登记表
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2019-04-12 14:20:07
 */
public interface TbMtOutService {
	
	TbMtOutDO get(String outGuid);
	
	List<TbMtOutDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(TbMtOutDO tbMtOut);
	
	int update(TbMtOutDO tbMtOut);
	
	int remove(String outGuid);
	
	int batchRemove(String[] outGuids);
}
