package com.bootdo.stock.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bootdo.stock.dao.TbMtStockDao;
import com.bootdo.stock.domain.TbMtStockDO;
import com.bootdo.stock.service.TbMtStockService;



@Service
public class TbMtStockServiceImpl implements TbMtStockService {
	@Autowired
	private TbMtStockDao tbMtStockDao;
	
	@Override
	public TbMtStockDO get(String mtCode){
		return tbMtStockDao.get(mtCode);
	}
	
	@Override
	public List<TbMtStockDO> list(Map<String, Object> map){
		return tbMtStockDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return tbMtStockDao.count(map);
	}
	
	@Override
	public int save(TbMtStockDO tbMtStock){
		return tbMtStockDao.save(tbMtStock);
	}
	
	@Override
	public int update(TbMtStockDO tbMtStock){
		return tbMtStockDao.update(tbMtStock);
	}
	
	@Override
	public int remove(String mtCode){
		return tbMtStockDao.remove(mtCode);
	}
	
	@Override
	public int batchRemove(String[] mtCodes){
		return tbMtStockDao.batchRemove(mtCodes);
	}
	
}
