package com.bootdo.stock.service;

import com.bootdo.stock.domain.TbMtOutListDO;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2019-04-12 14:20:07
 */
public interface TbMtOutListService {
	
	TbMtOutListDO get(String listGuid);
	
	List<TbMtOutListDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(TbMtOutListDO tbMtOutList);
	
	int update(TbMtOutListDO tbMtOutList);
	
	int remove(String listGuid);
	
	int batchRemove(String[] listGuids);
}
