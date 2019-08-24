package com.bootdo.sales.dao;

import com.bootdo.sales.domain.TbSellContractListDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 销售合同明细
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2019-04-12 14:24:57
 */
@Mapper
public interface TbSellContractListDao {

	TbSellContractListDO get(String listGuid);
	
	List<TbSellContractListDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(TbSellContractListDO tbSellContractList);
	
	int update(TbSellContractListDO tbSellContractList);
	
	int remove(String list_guid);
	
	int batchRemove(String[] listGuids);
}
