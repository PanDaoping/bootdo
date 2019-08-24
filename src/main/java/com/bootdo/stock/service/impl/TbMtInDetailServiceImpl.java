package com.bootdo.stock.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bootdo.stock.dao.TbMtInDetailDao;
import com.bootdo.stock.domain.TbMtInDetailDO;
import com.bootdo.stock.service.TbMtInDetailService;



@Service
public class TbMtInDetailServiceImpl implements TbMtInDetailService {
	@Autowired
	private TbMtInDetailDao tbMtInDetailDao;
	
	@Override
	public TbMtInDetailDO get(Integer orderDetailGuid){
		return tbMtInDetailDao.get(orderDetailGuid);
	}
	
	@Override
	public List<TbMtInDetailDO> list(Map<String, Object> map){
		return tbMtInDetailDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return tbMtInDetailDao.count(map);
	}
	
	@Override
	public int save(TbMtInDetailDO tbMtInDetail){
		return tbMtInDetailDao.save(tbMtInDetail);
	}
	
	@Override
	public int update(TbMtInDetailDO tbMtInDetail){
		return tbMtInDetailDao.update(tbMtInDetail);
	}
	
	@Override
	public int remove(String orderDetailGuid){
		return tbMtInDetailDao.remove(orderDetailGuid);
	}
	
	@Override
	public int batchRemove(String[] orderDetailGuids){
		return tbMtInDetailDao.batchRemove(orderDetailGuids);
	}
	
}
