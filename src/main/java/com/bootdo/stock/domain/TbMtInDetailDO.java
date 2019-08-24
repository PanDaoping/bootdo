package com.bootdo.stock.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 采购订单详细
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2019-04-12 14:20:07
 */
public class TbMtInDetailDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private String orderDetailGuid;
	//订单id
	private String orderGuid;
	//物料编码
	private String mtCode;
	//车牌号
	private String plateNumber;
	//货物名称
	private String mtName;
	//毛重
	private Double roughWeight;
	//皮重
	private Double tareWeight;
	//净重
	private Double netWeight;
	//扣杂 百分比表示
	private Integer deductMix;
	//单价
	private Double unitPrice;
	//总金额
	private String sum;

	/**
	 * 设置：
	 */
	public void setorderDetailGuid(String orderDetailGuid) {
		this.orderDetailGuid = orderDetailGuid;
	}
	/**
	 * 获取：
	 */
	public String getorderDetailGuid() {
		return orderDetailGuid;
	}
	/**
	 * 设置：订单id
	 */
	public void setorderGuid(String orderGuid) {
		this.orderGuid = orderGuid;
	}
	/**
	 * 获取：订单id
	 */
	public String getOrderGuid() {
		return orderGuid;
	}
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
	 * 设置：车牌号
	 */
	public void setPlateNumber(String plateNumber) {
		this.plateNumber = plateNumber;
	}
	/**
	 * 获取：车牌号
	 */
	public String getPlateNumber() {
		return plateNumber;
	}
	/**
	 * 设置：货物名称
	 */
	public void setMtName(String mtName) {
		this.mtName = mtName;
	}
	/**
	 * 获取：货物名称
	 */
	public String getMtName() {
		return mtName;
	}
	/**
	 * 设置：毛重
	 */
	public void setRoughWeight(Double roughWeight) {
		this.roughWeight = roughWeight;
	}
	/**
	 * 获取：毛重
	 */
	public Double getRoughWeight() {
		return roughWeight;
	}
	/**
	 * 设置：皮重
	 */
	public void setTareWeight(Double tareWeight) {
		this.tareWeight = tareWeight;
	}
	/**
	 * 获取：皮重
	 */
	public Double getTareWeight() {
		return tareWeight;
	}
	/**
	 * 设置：净重
	 */
	public void setNetWeight(Double netWeight) {
		this.netWeight = netWeight;
	}
	/**
	 * 获取：净重
	 */
	public Double getNetWeight() {
		return netWeight;
	}
	/**
	 * 设置：扣杂 百分比表示
	 */
	public void setDeductMix(Integer deductMix) {
		this.deductMix = deductMix;
	}
	/**
	 * 获取：扣杂 百分比表示
	 */
	public Integer getDeductMix() {
		return deductMix;
	}
	/**
	 * 设置：单价
	 */
	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}
	/**
	 * 获取：单价
	 */
	public Double getUnitPrice() {
		return unitPrice;
	}
	/**
	 * 设置：总金额
	 */
	public void setSum(String sum) {
		this.sum = sum;
	}
	/**
	 * 获取：总金额
	 */
	public String getSum() {
		return sum;
	}
}
