package com.bootdo.stock.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 资产（材料）库存表
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2019-04-12 14:20:07
 */
public class TbMtStockDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//物料编码
	private String mtCode;
	//供应商
	private String supplierName;
	//规格
	private String mtSpec;
	//最近操作人
	private String operUser;
	//计量单位（取值数据字典的MT_UNIT）
	private String mtUnit;
	//逻辑删除（0：不删除 1：删除）
	private Integer isDelete;
	//所属物料编码
	private String parentMtMode;
	//型号
	private String mtModel;
	//库存更新时间
	private Date updateTime;
	//最近出库价格（在做材料确认时输入的）	
	private Double latelyOutPrice;
	//库存量（库存总数量应该等于批次记录表中剩余数量之和）
	private Double stockNum;
	//库存预警值
	private Integer alarmNum;
	//品牌
	private String mtBrand;
	//物料名称
	private String mtName;
	//供应商GUID
	private String supplierGuid;
	//生产厂家
	private String facturer;
	//生产日期
	private Date manudate;

	/**
	 * 设置：物料编码
	 */
	public void setMtCode(String mtCode) {
		this.mtCode = mtCode;
	}
	/**
	 * 获取：物料编码
	 */
	public String getMtCode() {
		return mtCode;
	}
	/**
	 * 设置：供应商
	 */
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}
	/**
	 * 获取：供应商
	 */
	public String getSupplierName() {
		return supplierName;
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
	 * 设置：最近操作人
	 */
	public void setOperUser(String operUser) {
		this.operUser = operUser;
	}
	/**
	 * 获取：最近操作人
	 */
	public String getOperUser() {
		return operUser;
	}
	/**
	 * 设置：计量单位（取值数据字典的MT_UNIT）
	 */
	public void setMtUnit(String mtUnit) {
		this.mtUnit = mtUnit;
	}
	/**
	 * 获取：计量单位（取值数据字典的MT_UNIT）
	 */
	public String getMtUnit() {
		return mtUnit;
	}
	/**
	 * 设置：逻辑删除（0：不删除 1：删除）
	 */
	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}
	/**
	 * 获取：逻辑删除（0：不删除 1：删除）
	 */
	public Integer getIsDelete() {
		return isDelete;
	}
	/**
	 * 设置：所属物料编码
	 */
	public void setParentMtMode(String parentMtMode) {
		this.parentMtMode = parentMtMode;
	}
	/**
	 * 获取：所属物料编码
	 */
	public String getParentMtMode() {
		return parentMtMode;
	}
	/**
	 * 设置：型号
	 */
	public void setMtModel(String mtModel) {
		this.mtModel = mtModel;
	}
	/**
	 * 获取：型号
	 */
	public String getMtModel() {
		return mtModel;
	}
	/**
	 * 设置：库存更新时间
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	/**
	 * 获取：库存更新时间
	 */
	public Date getUpdateTime() {
		return updateTime;
	}
	/**
	 * 设置：最近出库价格（在做材料确认时输入的）	
	 */
	public void setLatelyOutPrice(Double latelyOutPrice) {
		this.latelyOutPrice = latelyOutPrice;
	}
	/**
	 * 获取：最近出库价格（在做材料确认时输入的）	
	 */
	public Double getLatelyOutPrice() {
		return latelyOutPrice;
	}
	/**
	 * 设置：库存量（库存总数量应该等于批次记录表中剩余数量之和）
	 */
	public void setStockNum(Double stockNum) {
		this.stockNum = stockNum;
	}
	/**
	 * 获取：库存量（库存总数量应该等于批次记录表中剩余数量之和）
	 */
	public Double getStockNum() {
		return stockNum;
	}
	/**
	 * 设置：库存预警值
	 */
	public void setAlarmNum(Integer alarmNum) {
		this.alarmNum = alarmNum;
	}
	/**
	 * 获取：库存预警值
	 */
	public Integer getAlarmNum() {
		return alarmNum;
	}
	/**
	 * 设置：品牌
	 */
	public void setMtBrand(String mtBrand) {
		this.mtBrand = mtBrand;
	}
	/**
	 * 获取：品牌
	 */
	public String getMtBrand() {
		return mtBrand;
	}
	/**
	 * 设置：物料名称
	 */
	public void setMtName(String mtName) {
		this.mtName = mtName;
	}
	/**
	 * 获取：物料名称
	 */
	public String getMtName() {
		return mtName;
	}
	/**
	 * 设置：供应商GUID
	 */
	public void setSupplierGuid(String supplierGuid) {
		this.supplierGuid = supplierGuid;
	}
	/**
	 * 获取：供应商GUID
	 */
	public String getSupplierGuid() {
		return supplierGuid;
	}
	/**
	 * 设置：生产厂家
	 */
	public void setFacturer(String facturer) {
		this.facturer = facturer;
	}
	/**
	 * 获取：生产厂家
	 */
	public String getFacturer() {
		return facturer;
	}
	/**
	 * 设置：生产日期
	 */
	public void setManudate(Date manudate) {
		this.manudate = manudate;
	}
	/**
	 * 获取：生产日期
	 */
	public Date getManudate() {
		return manudate;
	}
}
