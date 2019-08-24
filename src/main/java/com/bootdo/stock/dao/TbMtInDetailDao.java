package com.bootdo.stock.dao;

import com.bootdo.stock.domain.TbMtInDetailDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 采购订单详细
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2019-04-12 14:20:07
 */
@Mapper
public interface TbMtInDetailDao {

	TbMtInDetailDO get(Integer orderDetailGuid);
	
	List<TbMtInDetailDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(TbMtInDetailDO tbMtInDetail);
	
	int update(TbMtInDetailDO tbMtInDetail);
	
	int remove(String order_detail_guid);
	
	int batchRemove(String[] orderDetailGuids);
}
