package com.bootdo.match.service.impl;

import com.bootdo.match.dao.TbTheroryMatchingListDao;
import com.bootdo.match.domain.TbTheroryMatchingListDO;
import org.activiti.engine.impl.util.json.JSONArray;
import org.activiti.engine.impl.util.json.JSONObject;
import org.apache.commons.lang.ObjectUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.bootdo.match.dao.TbTheroryMatchingDao;
import com.bootdo.match.domain.TbTheroryMatchingDO;
import com.bootdo.match.service.TbTheroryMatchingService;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Service
public class TbTheroryMatchingServiceImpl implements TbTheroryMatchingService {
	@Autowired
	private TbTheroryMatchingDao tbTheroryMatchingDao;

	@Autowired
	private TbTheroryMatchingListDao tbTheroryMatchingListDao;


	private Logger logger = LoggerFactory.getLogger(getClass());


	@Override
	public TbTheroryMatchingDO get(String theoryGuid){
		return tbTheroryMatchingDao.get(theoryGuid);
	}
	
	@Override
	public List<TbTheroryMatchingDO> list(Map<String, Object> map){
		return tbTheroryMatchingDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return tbTheroryMatchingDao.count(map);
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
	public int save(Map<String, Object> map){
		int count = 0;
		try {
			String theoryGuid = ObjectUtils.toString(UUID.randomUUID().toString().replaceAll("-", ""));
			TbTheroryMatchingDO tbTherory = new TbTheroryMatchingDO();
			tbTherory.setTheoryGuid(theoryGuid);
			tbTherory.setMatchNum(ObjectUtils.toString(map.get("matchNum")));
			tbTherory.setStrengthGrade(ObjectUtils.toString(map.get("strengthGrade")));
			tbTherory.setIsDelete(0);
			tbTheroryMatchingDao.save(tbTherory);
			String arrayMount = map.get("arrayMount") == null ? "": map.get("arrayMount").toString();
			JSONArray jsonArrayMount = new JSONArray(arrayMount);
			for (int i = 0; i < jsonArrayMount.length(); i++) {
				JSONObject jsonObject = jsonArrayMount.getJSONObject(i);
				TbTheroryMatchingListDO tbTheroryMatching = new TbTheroryMatchingListDO();
				String theroryListGuid = ObjectUtils.toString(UUID.randomUUID().toString().replaceAll("-", ""));
				tbTheroryMatching.setTheoryGuid(theoryGuid);
				tbTheroryMatching.setTheroryListGuid(theroryListGuid);
				tbTheroryMatching.setIsDelete(0);
				tbTheroryMatching.setMtName(jsonObject.getString("mtName"));
				tbTheroryMatching.setMtSpec(jsonObject.getString("mtSpec"));
				tbTheroryMatching.setDosage(Double.valueOf(jsonObject.getString("dosage")));
				tbTheroryMatching.setProduce(jsonObject.getString("produce"));
				tbTheroryMatching.setSupplierName(jsonObject.getString("supplierName"));
				tbTheroryMatching.setWaterRate(jsonObject.getString("waterRate"));
				tbTheroryMatching.setRemark(jsonObject.getString("remark"));
				tbTheroryMatchingListDao.save(tbTheroryMatching);
				count++;
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return  count;
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
	public int update(Map<String, Object> map){
		int count = 0;
		try{
		String theoryGuid = ObjectUtils.toString(map.get("theoryGuid"));
		TbTheroryMatchingDO tbTherory = new TbTheroryMatchingDO();
		tbTherory.setTheoryGuid(theoryGuid);
		tbTherory.setMatchNum(ObjectUtils.toString(map.get("matchNum")));
		tbTherory.setStrengthGrade(ObjectUtils.toString(map.get("strengthGrade")));
		tbTherory.setIsDelete(0);
		 tbTheroryMatchingDao.update(tbTherory);
		 tbTheroryMatchingListDao.remove(theoryGuid);
		String arrayMount = map.get("arrayMount") == null ? "": map.get("arrayMount").toString();
		JSONArray jsonArrayMount = new JSONArray(arrayMount);
		for (int i = 0; i < jsonArrayMount.length(); i++) {
			JSONObject jsonObject = jsonArrayMount.getJSONObject(i);
			TbTheroryMatchingListDO tbTheroryMatching = new TbTheroryMatchingListDO();
			String theroryListGuid = ObjectUtils.toString(UUID.randomUUID().toString().replaceAll("-", ""));
			tbTheroryMatching.setTheoryGuid(theoryGuid);
			tbTheroryMatching.setTheroryListGuid(theroryListGuid);
			tbTheroryMatching.setIsDelete(0);
			tbTheroryMatching.setMtName(jsonObject.getString("mtName"));
			tbTheroryMatching.setMtSpec(jsonObject.getString("mtSpec"));
			tbTheroryMatching.setDosage(Double.valueOf(jsonObject.getString("dosage")));
			tbTheroryMatching.setProduce(jsonObject.getString("produce"));
			tbTheroryMatching.setSupplierName(jsonObject.getString("supplierName"));
			tbTheroryMatching.setWaterRate(jsonObject.getString("waterRate"));
			tbTheroryMatching.setRemark(jsonObject.getString("remark"));
			tbTheroryMatchingListDao.save(tbTheroryMatching);
			count++;
		}
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return  count;
	}
	
	@Override
	public int remove(String theoryGuid){
		return tbTheroryMatchingDao.remove(theoryGuid);
	}
	
	@Override
	public int batchRemove(String[] theoryGuids){
		return tbTheroryMatchingDao.batchRemove(theoryGuids);
	}
	
}
