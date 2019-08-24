package com.bootdo.stock.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bootdo.stock.dao.TbMtOutDao;
import com.bootdo.stock.domain.TbMtOutDO;
import com.bootdo.stock.service.TbMtOutService;



@Service
public class TbMtOutServiceImpl implements TbMtOutService {
	@Autowired
	private TbMtOutDao tbMtOutDao;
	
	@Override
	public TbMtOutDO get(String outGuid){
		return tbMtOutDao.get(outGuid);
	}
	
	@Override
	public List<TbMtOutDO> list(Map<String, Object> map){
		return tbMtOutDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return tbMtOutDao.count(map);
	}
	
	@Override
	public int save(TbMtOutDO tbMtOut){
		return tbMtOutDao.save(tbMtOut);
	}
	
	@Override
	public int update(TbMtOutDO tbMtOut){
		return tbMtOutDao.update(tbMtOut);
	}
	
	@Override
	public int remove(String outGuid){
		return tbMtOutDao.remove(outGuid);
	}
	
	@Override
	public int batchRemove(String[] outGuids){
		return tbMtOutDao.batchRemove(outGuids);
	}
	
}
