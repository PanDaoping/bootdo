package com.bootdo.sales.service.impl;

import com.bootdo.sales.dao.TbSalesUploadFileDao;
import com.bootdo.sales.dao.TbSellContractListDao;
import com.bootdo.sales.domain.TbSalesUploadFileDO;
import com.bootdo.sales.domain.TbSellContractListDO;
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

import com.bootdo.sales.dao.TbSellContractDao;
import com.bootdo.sales.domain.TbSellContractDO;
import com.bootdo.sales.service.TbSellContractService;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Service
public class TbSellContractServiceImpl implements TbSellContractService {
	@Autowired
	private TbSellContractDao tbSellContractDao;
	@Autowired
	private TbSellContractListDao tbSellContractListDao;
	@Autowired
	private TbSalesUploadFileDao tbSalesUploadFileDao;

	private Logger logger = LoggerFactory.getLogger(getClass());


	@Override
	public TbSellContractDO get(String contractGuid){
		return tbSellContractDao.get(contractGuid);
	}
	
	@Override
	public List<TbSellContractDO> list(Map<String, Object> map){
		return tbSellContractDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return tbSellContractDao.count(map);
	}
	
	@Override
    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
	public int save(Map<String, Object> map){
		int count = 0;
		try {
			String contractGuid = ObjectUtils.toString(UUID.randomUUID().toString().replaceAll("-", ""));
			TbSellContractDO tbSellContract = new TbSellContractDO();
			tbSellContract.setContractGuid(contractGuid);
			tbSellContract.setContractCode(ObjectUtils.toString(map.get("contractCode")));
			tbSellContract.setClientGuid(ObjectUtils.toString(map.get("clientGuid")));
			tbSellContract.setContractName(ObjectUtils.toString(map.get("contractName")));
			tbSellContract.setProjectSite(ObjectUtils.toString(map.get("projectSite")));
			tbSellContract.setConstructionOrganiz(ObjectUtils.toString(map.get("constructionOrganiz")));
			tbSellContract.setProjectName(ObjectUtils.toString(map.get("projectName")));
			tbSellContract.setSignedAmount(Double.valueOf(ObjectUtils.toString(map.get("signedAmount"))));
			tbSellContract.setAccountLimit(Double.valueOf(ObjectUtils.toString(map.get("accountLimit"))));
			tbSellContract.setOncreteActualAmount(Double.valueOf(ObjectUtils.toString(map.get("oncreteActualAmount"))));
			tbSellContract.setConcretePlanAmount(Double.valueOf(ObjectUtils.toString(map.get("concretePlanAmount"))));
			 tbSellContractDao.save(tbSellContract);
			String arrayMount = map.get("arrayMount") == null ? "": map.get("arrayMount").toString();
			JSONArray jsonArrayMount = new JSONArray(arrayMount);
			for (int i = 0; i < jsonArrayMount.length(); i++) {
				JSONObject jsonObject = jsonArrayMount.getJSONObject(i);
				TbSellContractListDO tbSellContractListDo=new TbSellContractListDO();
				tbSellContractListDo.setContractGuid(contractGuid);
				tbSellContractListDo.setListGuid(ObjectUtils.toString(UUID.randomUUID().toString().replaceAll("-", "")));
				tbSellContractListDo.setIsDelete(0);
				tbSellContractListDo.setConstructionPart(jsonObject.getString("constructionPart"));
				tbSellContractListDo.setConcreteStrengthGrade(jsonObject.getString("concreteStrengthGrade"));
				tbSellContractListDo.setConcreteSlump(jsonObject.getString("concreteSlump"));
				tbSellContractListDo.setOncreteActualAmount(Double.valueOf(jsonObject.getString("oncreteActualAmount")));
				tbSellContractListDo.setConcretePlanAmount(Double.valueOf(jsonObject.getString("concretePlanAmount")));
				tbSellContractListDao.save(tbSellContractListDo);
			}
			tbSalesUploadFileDao.removeByRelation(contractGuid);
			if (map.get("filePath") != null && map.get("filePath").toString().indexOf(",") >= 0) {
				String[] filePath = map.get("filePath").toString().split(",");
				String[] fileName = map.get("fileName").toString().split(",");
				String[] fileType = map.get("fileType").toString().split(",");
				TbSalesUploadFileDO to = new TbSalesUploadFileDO();
				for (int i = 0; i < filePath.length; i++) {
					String uploadGuid = UUID.randomUUID().toString().replaceAll("-", "");
//					to.setUploadTime(uploadTime);
					to.setRelationGuid(contractGuid);
					to.setUploadGuid(uploadGuid);
					to.setFilePath(filePath[i]);
					to.setFileName(fileName[i]);
					to.setFileType(fileType[i]);
//					to.setUserId(userId);
					to.setIsDelete(0);
					this.tbSalesUploadFileDao.save(to);
				}
			}
			 count++;
		} catch (Exception e) {
			logger.error(e.getMessage());

		}
		return count;
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
	public int update(Map<String, Object> map){
		String contractGuid=ObjectUtils.toString(map.get("contractGuid"));
		TbSellContractDO tbSellContract=new TbSellContractDO();
		tbSellContract.setContractGuid(contractGuid);
		tbSellContract.setContractCode(ObjectUtils.toString(map.get("contractCode")));
		tbSellContract.setClientGuid(ObjectUtils.toString(map.get("clientGuid")));
		tbSellContract.setContractName(ObjectUtils.toString(map.get("contractName")));
		tbSellContract.setProjectSite(ObjectUtils.toString(map.get("projectSite")));
		tbSellContract.setConstructionOrganiz(ObjectUtils.toString(map.get("constructionOrganiz")));
		tbSellContract.setProjectName(ObjectUtils.toString(map.get("projectName")));
		tbSellContract.setSignedAmount(Double.valueOf(ObjectUtils.toString(map.get("signedAmount"))));
		tbSellContract.setAccountLimit(Double.valueOf(ObjectUtils.toString(map.get("accountLimit"))));
		tbSellContract.setOncreteActualAmount(Double.valueOf(ObjectUtils.toString(map.get("oncreteActualAmount"))));
		tbSellContract.setConcretePlanAmount(Double.valueOf(ObjectUtils.toString(map.get("concretePlanAmount"))));
		 tbSellContractDao.update(tbSellContract);
		tbSellContractListDao.remove(contractGuid);
		String arrayMount = map.get("arrayMount") == null ? "": map.get("arrayMount").toString();
		JSONArray jsonArrayMount = new JSONArray(arrayMount);
		for (int i = 0; i < jsonArrayMount.length(); i++) {
			JSONObject jsonObject = jsonArrayMount.getJSONObject(i);
			TbSellContractListDO tbSellContractListDo = new TbSellContractListDO();
			tbSellContractListDo.setContractGuid(contractGuid);
			tbSellContractListDo.setListGuid(ObjectUtils.toString(UUID.randomUUID().toString().replaceAll("-", "")));
			tbSellContractListDo.setIsDelete(0);
			tbSellContractListDo.setConstructionPart(jsonObject.getString("constructionPart"));
			tbSellContractListDo.setConcreteStrengthGrade(jsonObject.getString("concreteStrengthGrade"));
			tbSellContractListDo.setConcreteSlump(jsonObject.getString("concreteSlump"));
			tbSellContractListDo.setOncreteActualAmount(Double.valueOf(jsonObject.getString("oncreteActualAmount")));
			tbSellContractListDo.setConcretePlanAmount(Double.valueOf(jsonObject.getString("concretePlanAmount")));
			tbSellContractListDao.save(tbSellContractListDo);
		}
		tbSalesUploadFileDao.removeByRelation(contractGuid);
		if (map.get("filePath") != null) {
			String[] filePath = map.get("filePath").toString().split(",");
			String[] fileName = map.get("fileName").toString().split(",");
			String[] fileType = map.get("fileType").toString().split(",");
			TbSalesUploadFileDO to = new TbSalesUploadFileDO();
			for (int i = 0; i < filePath.length; i++) {
				String uploadGuid = UUID.randomUUID().toString().replaceAll("-", "");
//					to.setUploadTime(uploadTime);
				to.setRelationGuid(contractGuid);
				to.setUploadGuid(uploadGuid);
				to.setFilePath(filePath[i]);
				to.setFileName(fileName[i]);
				to.setFileType(fileType[i]);
//					to.setUserId(userId);
				to.setIsDelete(0);
				this.tbSalesUploadFileDao.save(to);
			}
		}
		return 1;
	}
	
	@Override
	public int remove(String contractGuid){
		return tbSellContractDao.remove(contractGuid);
	}
	
	@Override
	public int batchRemove(String[] contractGuids){
		return tbSellContractDao.batchRemove(contractGuids);
	}

	@Override
	public String findClietCode(){ return tbSellContractDao.findClietCode();}

}
