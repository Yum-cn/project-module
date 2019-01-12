package com.project.eps.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 用户账户表
 * 
 * @author Yum
 * @email wtuada@126.com
 * @date 2019-01-07 18:22:34
 */
public class UserAccountDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//主键编号
	private Long id;
	//用户编号
	private Long userId;
	//账户余额(单位分:含当前操作金额)
	private Integer amount;
	//账户状态
	private Integer status;
	//历史总收入(单位分:含当前操作金额)
	private Integer totalIncome;
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
	 * 设置：账户余额(单位分:含当前操作金额)
	 */
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	/**
	 * 获取：账户余额(单位分:含当前操作金额)
	 */
	public Integer getAmount() {
		return amount;
	}
	/**
	 * 设置：账户状态
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}
	/**
	 * 获取：账户状态
	 */
	public Integer getStatus() {
		return status;
	}
	/**
	 * 设置：历史总收入(单位分:含当前操作金额)
	 */
	public void setTotalIncome(Integer totalIncome) {
		this.totalIncome = totalIncome;
	}
	/**
	 * 获取：历史总收入(单位分:含当前操作金额)
	 */
	public Integer getTotalIncome() {
		return totalIncome;
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
