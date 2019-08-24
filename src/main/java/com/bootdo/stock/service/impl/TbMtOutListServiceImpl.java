package com.bootdo.stock.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bootdo.stock.dao.TbMtOutListDao;
import com.bootdo.stock.domain.TbMtOutListDO;
import com.bootdo.stock.service.TbMtOutListService;



@Service
public class TbMtOutListServiceImpl implements TbMtOutListService {
	@Autowired
	private TbMtOutListDao tbMtOutListDao;
	
	@Override
	public TbMtOutListDO get(String listGuid){
		return tbMtOutListDao.get(listGuid);
	}
	
	@Override
	public List<TbMtOutListDO> list(Map<String, Object> map){
		return tbMtOutListDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return tbMtOutListDao.count(map);
	}
	
	@Override
	public int save(TbMtOutListDO tbMtOutList){
		return tbMtOutListDao.save(tbMtOutList);
	}
	
	@Override
	public int update(TbMtOutListDO tbMtOutList){
		return tbMtOutListDao.update(tbMtOutList);
	}
	
	@Override
	public int remove(String listGuid){
		return tbMtOutListDao.remove(listGuid);
	}
	
	@Override
	public int batchRemove(String[] listGuids){
		return tbMtOutListDao.batchRemove(listGuids);
	}
	
}
