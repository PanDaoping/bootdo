package com.bootdo.sales.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2019-06-17 15:28:00
 */
public class TbSalesUploadFileDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//文件主键GUID
	private String uploadGuid;
	//文件名称
	private String fileName;
	//文件类型（后缀类型，如：.jpg）
	private String fileType;
	//相关业务主键GUID
	private String relationGuid;
	//文件路径
	private String filePath;
	//上传人ID
	private String userId;
	//逻辑删除（0：不删除 1：删除）
	private Integer isDelete;
	//上传时间
	private Date uploadTime;

	/**
	 * 设置：文件主键GUID
	 */
	public void setUploadGuid(String uploadGuid) {
		this.uploadGuid = uploadGuid;
	}
	/**
	 * 获取：文件主键GUID
	 */
	public String getUploadGuid() {
		return uploadGuid;
	}
	/**
	 * 设置：文件名称
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	/**
	 * 获取：文件名称
	 */
	public String getFileName() {
		return fileName;
	}
	/**
	 * 设置：文件类型（后缀类型，如：.jpg）
	 */
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	/**
	 * 获取：文件类型（后缀类型，如：.jpg）
	 */
	public String getFileType() {
		return fileType;
	}
	/**
	 * 设置：相关业务主键GUID
	 */
	public void setRelationGuid(String relationGuid) {
		this.relationGuid = relationGuid;
	}
	/**
	 * 获取：相关业务主键GUID
	 */
	public String getRelationGuid() {
		return relationGuid;
	}
	/**
	 * 设置：文件路径
	 */
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	/**
	 * 获取：文件路径
	 */
	public String getFilePath() {
		return filePath;
	}
	/**
	 * 设置：上传人ID
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	/**
	 * 获取：上传人ID
	 */
	public String getUserId() {
		return userId;
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
	 * 设置：上传时间
	 */
	public void setUploadTime(Date uploadTime) {
		this.uploadTime = uploadTime;
	}
	/**
	 * 获取：上传时间
	 */
	public Date getUploadTime() {
		return uploadTime;
	}
}
