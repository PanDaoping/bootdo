package com.bootdo.sales.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 销售合同明细
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2019-04-12 14:24:57
 */
public class TbSellContractListDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//合同明细guid
	private String listGuid;
	//合同guid
	private String contractGuid;
	//施工部位
	private String constructionPart;
	//砼强度等级
	private String concreteStrengthGrade;
	//坍落度
	private String concreteSlump;
	//砼计划方量
	private Double concretePlanAmount;
	//砼实际方量
	private Double oncreteActualAmount;
	//逻辑删除（0：不删除 1：删除）
	private Integer isDelete;
	//单价
	private Double unitPrice;

	/**
	 * 设置：合同明细guid
	 */
	public void setListGuid(String listGuid) {
		this.listGuid = listGuid;
	}
	/**
	 * 获取：合同明细guid
	 */
	public String getListGuid() {
		return listGuid;
	}
	/**
	 * 设置：合同guid
	 */
	public void setContractGuid(String contractGuid) {
		this.contractGuid = contractGuid;
	}
	/**
	 * 获取：合同guid
	 */
	public String getContractGuid() {
		return contractGuid;
	}
	/**
	 * 设置：施工部位
	 */
	public void setConstructionPart(String constructionPart) {
		this.constructionPart = constructionPart;
	}
	/**
	 * 获取：施工部位
	 */
	public String getConstructionPart() {
		return constructionPart;
	}
	/**
	 * 设置：砼强度等级
	 */
	public void setConcreteStrengthGrade(String concreteStrengthGrade) {
		this.concreteStrengthGrade = concreteStrengthGrade;
	}
	/**
	 * 获取：砼强度等级
	 */
	public String getConcreteStrengthGrade() {
		return concreteStrengthGrade;
	}
	/**
	 * 设置：坍落度
	 */
	public void setConcreteSlump(String concreteSlump) {
		this.concreteSlump = concreteSlump;
	}
	/**
	 * 获取：坍落度
	 */
	public String getConcreteSlump() {
		return concreteSlump;
	}
	/**
	 * 设置：砼计划方量
	 */
	public void setConcretePlanAmount(Double concretePlanAmount) {
		this.concretePlanAmount = concretePlanAmount;
	}
	/**
	 * 获取：砼计划方量
	 */
	public Double getConcretePlanAmount() {
		return concretePlanAmount;
	}
	/**
	 * 设置：砼实际方量
	 */
	public void setOncreteActualAmount(Double oncreteActualAmount) {
		this.oncreteActualAmount = oncreteActualAmount;
	}
	/**
	 * 获取：砼实际方量
	 */
	public Double getOncreteActualAmount() {
		return oncreteActualAmount;
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
}
