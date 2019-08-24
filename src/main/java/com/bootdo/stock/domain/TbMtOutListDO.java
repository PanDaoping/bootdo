package com.bootdo.stock.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2019-04-12 14:20:07
 */
public class TbMtOutListDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//出库明细GUID
	private String listGuid;
	//出库GUID
	private String outGuid;
	//物料编码
	private String mtMode;
	//产地
	private String mtProducer;
	//
	private double outprice;
	//生产日期
	private Date manuDate;
	//出库数量
	private Integer outnum;
	//供应商
	private String supplierName;

	/**
	 * 设置：出库明细GUID
	 */
	public void setListGuid(String listGuid) {
		this.listGuid = listGuid;
	}
	/**
	 * 获取：出库明细GUID
	 */
	public String getListGuid() {
		return listGuid;
	}
	/**
	 * 设置：出库GUID
	 */
	public void setOutGuid(String outGuid) {
		this.outGuid = outGuid;
	}
	/**
	 * 获取：出库GUID
	 */
	public String getOutGuid() {
		return outGuid;
	}
	/**
	 * 设置：物料编码
	 */
	public void setMtMode(String mtMode) {
		this.mtMode = mtMode;
	}
	/**
	 * 获取：物料编码
	 */
	public String getMtMode() {
		return mtMode;
	}
	/**
	 * 设置：产地
	 */
	public void setMtProducer(String mtProducer) {
		this.mtProducer = mtProducer;
	}
	/**
	 * 获取：产地
	 */
	public String getMtProducer() {
		return mtProducer;
	}
	/**
	 * 设置：
	 */
	public void setOutprice(double outprice) {
		this.outprice = outprice;
	}
	/**
	 * 获取：
	 */
	public double getOutprice() {
		return outprice;
	}
	/**
	 * 设置：生产日期
	 */
	public void setManuDate(Date manuDate) {
		this.manuDate = manuDate;
	}
	/**
	 * 获取：生产日期
	 */
	public Date getManuDate() {
		return manuDate;
	}
	/**
	 * 设置：出库数量
	 */
	public void setOutnum(Integer outnum) {
		this.outnum = outnum;
	}
	/**
	 * 获取：出库数量
	 */
	public Integer getOutnum() {
		return outnum;
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
}
