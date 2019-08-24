package com.bootdo.sales.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bootdo.sales.dao.TbSellClientDao;
import com.bootdo.sales.domain.TbSellClientDO;
import com.bootdo.sales.service.TbSellClientService;



@Service
public class TbSellClientServiceImpl implements TbSellClientService {
	@Autowired
	private TbSellClientDao tbSellClientDao;
	
	@Override
	public TbSellClientDO get(String clientGuid){
		return tbSellClientDao.get(clientGuid);
	}
	
	@Override
	public List<TbSellClientDO> list(Map<String, Object> map){
		return tbSellClientDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return tbSellClientDao.count(map);
	}
	
	@Override
	public int save(TbSellClientDO tbSellClient){
		return tbSellClientDao.save(tbSellClient);
	}
	
	@Override
	public int update(TbSellClientDO tbSellClient){
		return tbSellClientDao.update(tbSellClient);
	}
	
	@Override
	public int remove(String clientGuid){
		return tbSellClientDao.remove(clientGuid);
	}
	
	@Override
	public int batchRemove(String[] clientGuids){
		return tbSellClientDao.batchRemove(clientGuids);
	}

	@Override
	public String findClietCode(){ return tbSellClientDao.findClietCode();}
	
}
