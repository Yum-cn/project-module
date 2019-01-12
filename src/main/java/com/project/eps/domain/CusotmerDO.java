package com.project.eps.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 客户信息表
 * 
 * @author Yum
 * @email wtuada@126.com
 * @date 2019-01-07 18:22:33
 */
public class CusotmerDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//主键编号
	private Long id;
	//客户名称
	private String name;
	//客户地址
	private String address;
	//客户联系人
	private String linkman;
	//客户联系电话
	private String contactNumber;
	//客户所属行业
	private String industry;
	//人员规模
	private String companySize;
	//是否认证
	private String authenticationTag;
	//资质上传地址
	private String credentialsUrl;
	//是否有上级
	private String parentTag;
	//绑定合同编号
	private String contractIds;
	//绑定合同名称
	private String contractNames;
	//分配系统用户编号
	private Long userId;
	//客户状态
	private Integer status;
	//状态变更时间
	private Long updateTime;
	//入网时间
	private Long createTime;

	/**
	 * 设置：主键编号
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取：主键编号
	 */
	public Long getId() {
		return id;
	}
	/**
	 * 设置：客户名称
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：客户名称
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：客户地址
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * 获取：客户地址
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * 设置：客户联系人
	 */
	public void setLinkman(String linkman) {
		this.linkman = linkman;
	}
	/**
	 * 获取：客户联系人
	 */
	public String getLinkman() {
		return linkman;
	}
	/**
	 * 设置：客户联系电话
	 */
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	/**
	 * 获取：客户联系电话
	 */
	public String getContactNumber() {
		return contactNumber;
	}
	/**
	 * 设置：客户所属行业
	 */
	public void setIndustry(String industry) {
		this.industry = industry;
	}
	/**
	 * 获取：客户所属行业
	 */
	public String getIndustry() {
		return industry;
	}
	/**
	 * 设置：人员规模
	 */
	public void setCompanySize(String companySize) {
		this.companySize = companySize;
	}
	/**
	 * 获取：人员规模
	 */
	public String getCompanySize() {
		return companySize;
	}
	/**
	 * 设置：是否认证
	 */
	public void setAuthenticationTag(String authenticationTag) {
		this.authenticationTag = authenticationTag;
	}
	/**
	 * 获取：是否认证
	 */
	public String getAuthenticationTag() {
		return authenticationTag;
	}
	/**
	 * 设置：资质上传地址
	 */
	public void setCredentialsUrl(String credentialsUrl) {
		this.credentialsUrl = credentialsUrl;
	}
	/**
	 * 获取：资质上传地址
	 */
	public String getCredentialsUrl() {
		return credentialsUrl;
	}
	/**
	 * 设置：是否有上级
	 */
	public void setParentTag(String parentTag) {
		this.parentTag = parentTag;
	}
	/**
	 * 获取：是否有上级
	 */
	public String getParentTag() {
		return parentTag;
	}
	/**
	 * 设置：绑定合同编号
	 */
	public void setContractIds(String contractIds) {
		this.contractIds = contractIds;
	}
	/**
	 * 获取：绑定合同编号
	 */
	public String getContractIds() {
		return contractIds;
	}
	/**
	 * 设置：绑定合同名称
	 */
	public void setContractNames(String contractNames) {
		this.contractNames = contractNames;
	}
	/**
	 * 获取：绑定合同名称
	 */
	public String getContractNames() {
		return contractNames;
	}
	/**
	 * 设置：分配系统用户编号
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	/**
	 * 获取：分配系统用户编号
	 */
	public Long getUserId() {
		return userId;
	}
	/**
	 * 设置：客户状态
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}
	/**
	 * 获取：客户状态
	 */
	public Integer getStatus() {
		return status;
	}
	/**
	 * 设置：状态变更时间
	 */
	public void setUpdateTime(Long updateTime) {
		this.updateTime = updateTime;
	}
	/**
	 * 获取：状态变更时间
	 */
	public Long getUpdateTime() {
		return updateTime;
	}
	/**
	 * 设置：入网时间
	 */
	public void setCreateTime(Long createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：入网时间
	 */
	public Long getCreateTime() {
		return createTime;
	}
}
