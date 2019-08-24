package com.bootdo.match.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2019-07-13 16:47:23
 */
public class TbMatchListFallDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private String matchListGuid;
	//
	private String matchGuid;
	//
	private String mtName;
	//
	private Double dosage;
	//
	private Integer isDelete;
	//
	private String mtSpec;
	//
	private String supplierName;
	//
	private String waterRate;
	//
	private String produce;
	//
	private String remark;

	/**
	 * 设置：
	 */
	public void setMatchListGuid(String matchListGuid) {
		this.matchListGuid = matchListGuid;
	}
	/**
	 * 获取：
	 */
	public String getMatchListGuid() {
		return matchListGuid;
	}
	/**
	 * 设置：
	 */
	public void setMatchGuid(String matchGuid) {
		this.matchGuid = matchGuid;
	}
	/**
	 * 获取：
	 */
	public String getMatchGuid() {
		return matchGuid;
	}
	/**
	 * 设置：
	 */
	public void setMtName(String mtName) {
		this.mtName = mtName;
	}
	/**
	 * 获取：
	 */
	public String getMtName() {
		return mtName;
	}
	/**
	 * 设置：
	 */
	public void setDosage(Double dosage) {
		this.dosage = dosage;
	}
	/**
	 * 获取：
	 */
	public Double getDosage() {
		return dosage;
	}
	/**
	 * 设置：
	 */
	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}
	/**
	 * 获取：
	 */
	public Integer getIsDelete() {
		return isDelete;
	}
	/**
	 * 设置：
	 */
	public void setMtSpec(String mtSpec) {
		this.mtSpec = mtSpec;
	}
	/**
	 * 获取：
	 */
	public String getMtSpec() {
		return mtSpec;
	}
	/**
	 * 设置：
	 */
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}
	/**
	 * 获取：
	 */
	public String getSupplierName() {
		return supplierName;
	}
	/**
	 * 设置：
	 */
	public void setWaterRate(String waterRate) {
		this.waterRate = waterRate;
	}
	/**
	 * 获取：
	 */
	public String getWaterRate() {
		return waterRate;
	}
	/**
	 * 设置：
	 */
	public void setProduce(String produce) {
		this.produce = produce;
	}
	/**
	 * 获取：
	 */
	public String getProduce() {
		return produce;
	}
	/**
	 * 设置：
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	/**
	 * 获取：
	 */
	public String getRemark() {
		return remark;
	}
}
