package com.bootdo.stock.service.impl;

import com.bootdo.stock.dao.TbMtInDetailDao;
import com.bootdo.stock.dao.TbMtStockDao;
import com.bootdo.stock.domain.TbMtInDetailDO;
import com.bootdo.stock.domain.TbMtStockDO;
import org.apache.commons.lang.ObjectUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.bootdo.stock.dao.TbMtInDao;
import com.bootdo.stock.domain.TbMtInDO;
import com.bootdo.stock.service.TbMtInService;



@Service
public class TbMtInServiceImpl implements TbMtInService {
	@Autowired
	private TbMtInDao tbMtInDao;
	@Autowired
	private TbMtInDetailDao tbMtInDetailDao;
	@Autowired
	private TbMtStockDao tbMtStockDao;


	private Logger logger = LoggerFactory.getLogger(getClass());
	@Override
	public Map get(String orderGuid){
		return tbMtInDao.get(orderGuid);
	}
	
	@Override
	public List<Map> list(Map<String, Object> map){
		return tbMtInDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return tbMtInDao.count(map);
	}

	@Override
	public int save(Map<String, Object> map) {
		try {
			TbMtInDO tbMtIn = new TbMtInDO();
			String orderGuid=ObjectUtils.toString(UUID.randomUUID().toString().replaceAll("-", ""));
			tbMtIn.setorderGuid(orderGuid);
			tbMtIn.setoperDate(new Date());
			tbMtIn.setoperUser(ObjectUtils.toString(map.get("userId")));
			tbMtIn.setorderNum(ObjectUtils.toString(map.get("orderNum")));
			tbMtIn.setIsDelete(0);
			tbMtInDao.save(tbMtIn);
			TbMtInDetailDO tbMtInDetail = new TbMtInDetailDO();
			tbMtInDetail.setorderDetailGuid(ObjectUtils.toString(UUID.randomUUID().toString().replaceAll("-", "")));
			tbMtInDetail.setorderGuid(orderGuid);
			tbMtInDetail.setMtCode(ObjectUtils.toString(map.get("mtCode")));
			tbMtInDetail.setMtName(ObjectUtils.toString(map.get("mtName")));
			tbMtInDetail.setNetWeight(Double.valueOf(ObjectUtils.toString(map.get("netWeight"))));
			tbMtInDetail.setRoughWeight(Double.valueOf(ObjectUtils.toString(map.get("roughWeight"))));
			tbMtInDetail.setTareWeight(Double.valueOf(ObjectUtils.toString(map.get("tareWeight"))));
			tbMtInDetail.setPlateNumber(ObjectUtils.toString(map.get("plateNumber")));
			tbMtInDetailDao.save(tbMtInDetail);
            TbMtStockDO tbMtStock=tbMtStockDao.get(ObjectUtils.toString(map.get("mtCode")));
            if(tbMtStock==null){
                tbMtStock=new TbMtStockDO();
                tbMtStock.setMtCode(ObjectUtils.toString(map.get("mtCode")));
                tbMtStock.setStockNum(Double.valueOf(ObjectUtils.toString(map.get("netWeight"))));
                tbMtStock.setUpdateTime(new Date());
                tbMtStock.setIsDelete(0);
                tbMtStockDao.save(tbMtStock);
            }else{
                tbMtStock.setStockNum(tbMtStock.getStockNum()+Double.valueOf(ObjectUtils.toString(map.get("netWeight"))));
                tbMtStock.setUpdateTime(new Date());
                tbMtStockDao.update(tbMtStock);
            }

		} catch (Exception e) {
			logger.error(e.getMessage());
			return 0;
		}
		return 1;

	}
	@Override
	public int update(Map<String, Object> map){
        try {
            TbMtInDO tbMtIn = new TbMtInDO();
            tbMtIn.setorderGuid(ObjectUtils.toString(map.get("orderGuid")));
            tbMtIn.setoperDate(new Date());
            tbMtIn.setorderNum(ObjectUtils.toString(map.get("orderNum")));
            tbMtInDao.update(tbMtIn);
            TbMtInDetailDO tbMtInDetail = new TbMtInDetailDO();
            tbMtInDetail.setorderDetailGuid(ObjectUtils.toString(UUID.randomUUID().toString().replaceAll("-", "")));
            tbMtInDetail.setorderGuid(ObjectUtils.toString(map.get("orderGuid")));
            tbMtInDetail.setMtCode(ObjectUtils.toString(map.get("mtCode")));
            tbMtInDetail.setMtName(ObjectUtils.toString(map.get("mtName")));
            tbMtInDetail.setNetWeight(Double.valueOf(ObjectUtils.toString(map.get("netWeight"))));
            tbMtInDetail.setRoughWeight(Double.valueOf(ObjectUtils.toString(map.get("roughWeight"))));
            tbMtInDetail.setTareWeight(Double.valueOf(ObjectUtils.toString(map.get("tareWeight"))));
            tbMtInDetail.setPlateNumber(ObjectUtils.toString(map.get("plateNumber")));
			tbMtInDetailDao.remove(ObjectUtils.toString(map.get("orderDetailGuid")));
            tbMtInDetailDao.save(tbMtInDetail);
            TbMtStockDO tbMtStock = tbMtStockDao.get(ObjectUtils.toString(map.get("mtCode")));
            if (tbMtStock == null) {
                tbMtStock = new TbMtStockDO();
                tbMtStock.setMtCode(ObjectUtils.toString(map.get("mtCode")));
                tbMtStock.setStockNum(Double.valueOf(ObjectUtils.toString(map.get("netWeight"))));
                tbMtStock.setUpdateTime(new Date());
                tbMtStock.setIsDelete(0);
                tbMtStockDao.save(tbMtStock);
            } else {
                tbMtStock.setStockNum(tbMtStock.getStockNum() + Double.valueOf(ObjectUtils.toString(map.get("netWeight"))));
                tbMtStock.setUpdateTime(new Date());
                tbMtStockDao.update(tbMtStock);
            }
        }catch (Exception e) {
                logger.error(e.getMessage());
                return 0;
            }
            return 1;

        }
	
	@Override
	public int remove(String orderGuid){
		return tbMtInDao.remove(orderGuid);
	}
	
	@Override
	public int batchRemove(String[] orderGuids){
		return tbMtInDao.batchRemove(orderGuids);
	}

	@Override
	public String getNewCode(Map<String,Object> map){
		return tbMtInDao.getNewCode(map);
	}

}
