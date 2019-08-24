package com.bootdo.system.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2019-06-25 13:11:18
 */
public class TbSysDicDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private String dicId;
	//类型标识
	private String typeTag;
	//类型别名
	private String typeAlias;
	//类型说明
	private String typeDesc;
	//
	private String typeName;
	//是否删除
	private Integer isDelete;

	/**
	 * 设置：
	 */
	public void setDicId(String dicId) {
		this.dicId = dicId;
	}
	/**
	 * 获取：
	 */
	public String getDicId() {
		return dicId;
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
	 * 设置：类型别名
	 */
	public void setTypeAlias(String typeAlias) {
		this.typeAlias = typeAlias;
	}
	/**
	 * 获取：类型别名
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
	 * 设置：
	 */
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	/**
	 * 获取：
	 */
	public String getTypeName() {
		return typeName;
	}
	/**
	 * 设置：是否删除
	 */
	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}
	/**
	 * 获取：是否删除
	 */
	public Integer getIsDelete() {
		return isDelete;
	}
}
