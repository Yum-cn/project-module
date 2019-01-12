package com.project.eps.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 用户提现表
 * 
 * @author Yum
 * @email wtuada@126.com
 * @date 2019-01-07 18:22:35
 */
public class UserWithdrawDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//主键编号
	private Long id;
	//用户编号
	private Long userId;
	//用户账户编号
	private String userAccountId;
	//用户账户卡号编号
	private String useAccountCardId;
	//提现金额
	private String withdrawAmount;
	//提现状态(待提现、提现成功、提现失败)
	private Integer withdrawStatus;
	//提现失败描述
	private String withdrawDesc;
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
	 * 设置：用户账户编号
	 */
	public void setUserAccountId(String userAccountId) {
		this.userAccountId = userAccountId;
	}
	/**
	 * 获取：用户账户编号
	 */
	public String getUserAccountId() {
		return userAccountId;
	}
	/**
	 * 设置：用户账户卡号编号
	 */
	public void setUseAccountCardId(String useAccountCardId) {
		this.useAccountCardId = useAccountCardId;
	}
	/**
	 * 获取：用户账户卡号编号
	 */
	public String getUseAccountCardId() {
		return useAccountCardId;
	}
	/**
	 * 设置：提现金额
	 */
	public void setWithdrawAmount(String withdrawAmount) {
		this.withdrawAmount = withdrawAmount;
	}
	/**
	 * 获取：提现金额
	 */
	public String getWithdrawAmount() {
		return withdrawAmount;
	}
	/**
	 * 设置：提现状态(待提现、提现成功、提现失败)
	 */
	public void setWithdrawStatus(Integer withdrawStatus) {
		this.withdrawStatus = withdrawStatus;
	}
	/**
	 * 获取：提现状态(待提现、提现成功、提现失败)
	 */
	public Integer getWithdrawStatus() {
		return withdrawStatus;
	}
	/**
	 * 设置：提现失败描述
	 */
	public void setWithdrawDesc(String withdrawDesc) {
		this.withdrawDesc = withdrawDesc;
	}
	/**
	 * 获取：提现失败描述
	 */
	public String getWithdrawDesc() {
		return withdrawDesc;
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
