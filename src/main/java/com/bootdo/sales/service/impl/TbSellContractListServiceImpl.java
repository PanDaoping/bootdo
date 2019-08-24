package com.bootdo.sales.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bootdo.sales.dao.TbSellContractListDao;
import com.bootdo.sales.domain.TbSellContractListDO;
import com.bootdo.sales.service.TbSellContractListService;



@Service
public class TbSellContractListServiceImpl implements TbSellContractListService {
	@Autowired
	private TbSellContractListDao tbSellContractListDao;
	
	@Override
	public TbSellContractListDO get(String listGuid){
		return tbSellContractListDao.get(listGuid);
	}
	
	@Override
	public List<TbSellContractListDO> list(Map<String, Object> map){
		return tbSellContractListDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return tbSellContractListDao.count(map);
	}
	
	@Override
	public int save(TbSellContractListDO tbSellContractList){
		return tbSellContractListDao.save(tbSellContractList);
	}
	
	@Override
	public int update(TbSellContractListDO tbSellContractList){
		return tbSellContractListDao.update(tbSellContractList);
	}
	
	@Override
	public int remove(String listGuid){
		return tbSellContractListDao.remove(listGuid);
	}
	
	@Override
	public int batchRemove(String[] listGuids){
		return tbSellContractListDao.batchRemove(listGuids);
	}
	
}
