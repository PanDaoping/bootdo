package com.bootdo.match.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2019-07-10 15:56:58
 */
public class TbTheroryMatchingListDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//理论配比明细guid
	private String theroryListGuid;
	//理论配比guid
	private String theoryGuid;
	//材料名称
	private String mtName;
	//每方用量
	private Double dosage;
	//
	private Integer isDelete;
	//规格
	private String mtSpec;
	//生产厂家
	private String supplierName;
	//含水率
	private String waterRate;
	//产地
	private String produce;
	//备注
	private String remark;

	/**
	 * 设置：理论配比明细guid
	 */
	public void setTheroryListGuid(String theroryListGuid) {
		this.theroryListGuid = theroryListGuid;
	}
	/**
	 * 获取：理论配比明细guid
	 */
	public String getTheroryListGuid() {
		return theroryListGuid;
	}
	/**
	 * 设置：理论配比guid
	 */
	public void setTheoryGuid(String theoryGuid) {
		this.theoryGuid = theoryGuid;
	}
	/**
	 * 获取：理论配比guid
	 */
	public String getTheoryGuid() {
		return theoryGuid;
	}
	/**
	 * 设置：材料名称
	 */
	public void setMtName(String mtName) {
		this.mtName = mtName;
	}
	/**
	 * 获取：材料名称
	 */
	public String getMtName() {
		return mtName;
	}
	/**
	 * 设置：每方用量
	 */
	public void setDosage(Double dosage) {
		this.dosage = dosage;
	}
	/**
	 * 获取：每方用量
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
	 * 设置：规格
	 */
	public void setMtSpec(String mtSpec) {
		this.mtSpec = mtSpec;
	}
	/**
	 * 获取：规格
	 */
	public String getMtSpec() {
		return mtSpec;
	}
	/**
	 * 设置：生产厂家
	 */
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}
	/**
	 * 获取：生产厂家
	 */
	public String getSupplierName() {
		return supplierName;
	}
	/**
	 * 设置：含水率
	 */
	public void setWaterRate(String waterRate) {
		this.waterRate = waterRate;
	}
	/**
	 * 获取：含水率
	 */
	public String getWaterRate() {
		return waterRate;
	}
	/**
	 * 设置：产地
	 */
	public void setProduce(String produce) {
		this.produce = produce;
	}
	/**
	 * 获取：产地
	 */
	public String getProduce() {
		return produce;
	}
	/**
	 * 设置：备注
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	/**
	 * 获取：备注
	 */
	public String getRemark() {
		return remark;
	}
}
