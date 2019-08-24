package com.bootdo.product.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 计划任务表
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2019-06-27 11:29:22
 */
public class TbPlanTaskDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//计划guid
	private String planGuid;
	//合同guid
	private String contractGuid;
	//施工单位
	private String constructionOrganiz;
	//计划时间
	private Date planDate;
	//计划方量
	private Double planAmount;
	//标号
	private String markNumber;
	//逻辑删除（0：不删除 1：删除）
	private Integer isDelete;
	//浇筑方式（从数据字典中取值POURING_WAY）
	private String pouringWay;
	//坍落度
	private String concreteSlump;
	//施工部位
	private String constructionPart;
	//砼强度等级
	private String concreteStrengthGrade;
	//状态（0未完工  1 配比下发    2 完工）
	private Integer status;
	//操作用户
	private String userId;
	//备注
	private  String remark;

	/**
	 * 设置：计划guid
	 */
	public void setPlanGuid(String planGuid) {
		this.planGuid = planGuid;
	}
	/**
	 * 获取：计划guid
	 */
	public String getPlanGuid() {
		return planGuid;
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
	 * 设置：施工单位
	 */
	public void setConstructionOrganiz(String constructionOrganiz) {
		this.constructionOrganiz = constructionOrganiz;
	}
	/**
	 * 获取：施工单位
	 */
	public String getConstructionOrganiz() {
		return constructionOrganiz;
	}
	/**
	 * 设置：计划时间
	 */
	public void setPlanDate(Date planDate) {
		this.planDate = planDate;
	}
	/**
	 * 获取：计划时间
	 */
	public Date getPlanDate() {
		return planDate;
	}
	/**
	 * 设置：计划方量
	 */
	public void setPlanAmount(Double planAmount) {
		this.planAmount = planAmount;
	}
	/**
	 * 获取：计划方量
	 */
	public Double getPlanAmount() {
		return planAmount;
	}
	/**
	 * 设置：标号
	 */
	public void setMarkNumber(String markNumber) {
		this.markNumber = markNumber;
	}
	/**
	 * 获取：标号
	 */
	public String getMarkNumber() {
		return markNumber;
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
	 * 设置：浇筑方式（从数据字典中取值POURING_WAY）
	 */
	public void setPouringWay(String pouringWay) {
		this.pouringWay = pouringWay;
	}
	/**
	 * 获取：浇筑方式（从数据字典中取值POURING_WAY）
	 */
	public String getPouringWay() {
		return pouringWay;
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
	 * 设置：状态（0未完工  1 配比下发    2 完工）
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}
	/**
	 * 获取：状态（0未完工  1 配比下发    2 完工）
	 */
	public Integer getStatus() {
		return status;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserId(){return userId;}

	public void setRemark(String remark){this.remark=remark;}

	public String  getRemark() {
		return this.remark;
	}
}
