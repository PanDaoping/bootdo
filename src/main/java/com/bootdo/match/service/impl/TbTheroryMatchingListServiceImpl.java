package com.bootdo.match.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bootdo.match.dao.TbTheroryMatchingListDao;
import com.bootdo.match.domain.TbTheroryMatchingListDO;
import com.bootdo.match.service.TbTheroryMatchingListService;



@Service
public class TbTheroryMatchingListServiceImpl implements TbTheroryMatchingListService {
	@Autowired
	private TbTheroryMatchingListDao tbTheroryMatchingListDao;
	
	@Override
	public TbTheroryMatchingListDO get(String theroryListGuid){
		return tbTheroryMatchingListDao.get(theroryListGuid);
	}
	
	@Override
	public List<TbTheroryMatchingListDO> list(Map<String, Object> map){
		return tbTheroryMatchingListDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return tbTheroryMatchingListDao.count(map);
	}
	
	@Override
	public int save(TbTheroryMatchingListDO tbTheroryMatchingList){
		return tbTheroryMatchingListDao.save(tbTheroryMatchingList);
	}
	
	@Override
	public int update(TbTheroryMatchingListDO tbTheroryMatchingList){
		return tbTheroryMatchingListDao.update(tbTheroryMatchingList);
	}
	
	@Override
	public int remove(String theroryListGuid){
		return tbTheroryMatchingListDao.remove(theroryListGuid);
	}
	
	@Override
	public int batchRemove(String[] theroryListGuids){
		return tbTheroryMatchingListDao.batchRemove(theroryListGuids);
	}
	
}
