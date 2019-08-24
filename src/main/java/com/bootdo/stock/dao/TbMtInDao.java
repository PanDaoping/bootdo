package com.bootdo.stock.dao;

import com.bootdo.stock.domain.TbMtInDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 订单表
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2019-04-12 14:20:06
 */
@Mapper
public interface TbMtInDao {

	Map get(String orderGuid);
	
	List<Map> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(TbMtInDO tbMtIn);
	
	int update(TbMtInDO tbMtIn);
	
	int remove(String order_guid);
	
	int batchRemove(String[] orderGuids);

	String getNewCode(Map<String,Object> map);
}
