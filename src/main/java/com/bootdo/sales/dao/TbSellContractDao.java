package com.bootdo.sales.dao;

import com.bootdo.sales.domain.TbSellContractDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 销售合同
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2019-04-12 14:24:57
 */
@Mapper
public interface TbSellContractDao {

	TbSellContractDO get(String contractGuid);
	
	List<TbSellContractDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(TbSellContractDO tbSellContract);
	
	int update(TbSellContractDO tbSellContract);
	
	int remove(String contract_guid);
	
	int batchRemove(String[] contractGuids);

	String findClietCode();
}
