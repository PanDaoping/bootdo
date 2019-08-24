package com.bootdo.stock.service;

import com.bootdo.stock.domain.TbMtInDetailDO;

import java.util.List;
import java.util.Map;

/**
 * 采购订单详细
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2019-04-12 14:20:07
 */
public interface TbMtInDetailService {
	
	TbMtInDetailDO get(Integer orderDetailGuid);
	
	List<TbMtInDetailDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(TbMtInDetailDO tbMtInDetail);
	
	int update(TbMtInDetailDO tbMtInDetail);
	
	int remove(String orderDetailGuid);
	
	int batchRemove(String[] orderDetailGuids);
}
