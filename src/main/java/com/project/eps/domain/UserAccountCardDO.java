package com.project.eps.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 用户账户卡号表
 * 
 * @author Yum
 * @email wtuada@126.com
 * @date 2019-01-07 18:22:34
 */
public class UserAccountCardDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//主键编号
	private Long id;
	//用户编号
	private Long userId;
	//账户名称(例:银行名称)
	private String accountName;
	//账户描述(例:开户行)
	private String accountDesc;
	//账户卡号(例:银行卡号)
	private String accountNo;
	//状态
	private Integer status;
	//创建时间
	private Long createTime;
	//修改时间
	private Long updateTime;

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
	 * 设置：用户编号
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	/**
	 * 获取：用户编号
	 */
	public Long getUserId() {
		return userId;
	}
	/**
	 * 设置：账户名称(例:银行名称)
	 */
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	/**
	 * 获取：账户名称(例:银行名称)
	 */
	public String getAccountName() {
		return accountName;
	}
	/**
	 * 设置：账户描述(例:开户行)
	 */
	public void setAccountDesc(String accountDesc) {
		this.accountDesc = accountDesc;
	}
	/**
	 * 获取：账户描述(例:开户行)
	 */
	public String getAccountDesc() {
		return accountDesc;
	}
	/**
	 * 设置：账户卡号(例:银行卡号)
	 */
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	/**
	 * 获取：账户卡号(例:银行卡号)
	 */
	public String getAccountNo() {
		return accountNo;
	}
	/**
	 * 设置：状态
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}
	/**
	 * 获取：状态
	 */
	public Integer getStatus() {
		return status;
	}
	/**
	 * 设置：创建时间
	 */
	public void setCreateTime(Long createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：创建时间
	 */
	public Long getCreateTime() {
		return createTime;
	}
	/**
	 * 设置：修改时间
	 */
	public void setUpdateTime(Long updateTime) {
		this.updateTime = updateTime;
	}
	/**
	 * 获取：修改时间
	 */
	public Long getUpdateTime() {
		return updateTime;
	}
}
