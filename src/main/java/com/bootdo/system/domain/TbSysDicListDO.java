package com.bootdo.system.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 数据字典分类表
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2019-06-25 13:11:18
 */
public class TbSysDicListDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private String dicListId;
	//类型标识
	private String typeTag;
	// 类型别名
	private String typeAlias;
	//类型说明
	private String typeDesc;
	//类型名称
	private String typeName;
	//数据字典说明
	private String dicDesc;
	//数据字典值
	private String dicValue;
	//逻辑删除（0：不删除 1：删除）
	private Integer isDelete;

	/**
	 * 设置：
	 */
	public void setDicListId(String dicListId) {
		this.dicListId = dicListId;
	}
	/**
	 * 获取：
	 */
	public String getDicListId() {
		return dicListId;
	}
	/**
	 * 设置：类型标识
	 */
	public void setTypeTag(String typeTag) {
		this.typeTag = typeTag;
	}
	/**
	 * 获取：类型标识
	 */
	public String getTypeTag() {
		return typeTag;
	}
	/**
	 * 设置： 类型别名
	 */
	public void setTypeAlias(String typeAlias) {
		this.typeAlias = typeAlias;
	}
	/**
	 * 获取： 类型别名
	 */
	public String getTypeAlias() {
		return typeAlias;
	}
	/**
	 * 设置：类型说明
	 */
	public void setTypeDesc(String typeDesc) {
		this.typeDesc = typeDesc;
	}
	/**
	 * 获取：类型说明
	 */
	public String getTypeDesc() {
		return typeDesc;
	}
	/**
	 * 设置：类型名称
	 */
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	/**
	 * 获取：类型名称
	 */
	public String getTypeName() {
		return typeName;
	}
	/**
	 * 设置：数据字典说明
	 */
	public void setDicDesc(String dicDesc) {
		this.dicDesc = dicDesc;
	}
	/**
	 * 获取：数据字典说明
	 */
	public String getDicDesc() {
		return dicDesc;
	}
	/**
	 * 设置：数据字典值
	 */
	public void setDicValue(String dicValue) {
		this.dicValue = dicValue;
	}
	/**
	 * 获取：数据字典值
	 */
	public String getDicValue() {
		return dicValue;
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
}
