package com.project.eps.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 合同API表
 * 
 * @author Yum
 * @email wtuada@126.com
 * @date 2019-01-07 18:22:33
 */
public class ContractApiDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//主键编号
	private Long id;
	//合同编号
	private Long contractId;
	//API点编号
	private Long apiPlaceId;
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
	 * 设置：合同编号
	 */
	public void setContractId(Long contractId) {
		this.contractId = contractId;
	}
	/**
	 * 获取：合同编号
	 */
	public Long getContractId() {
		return contractId;
	}
	/**
	 * 设置：API点编号
	 */
	public void setApiPlaceId(Long apiPlaceId) {
		this.apiPlaceId = apiPlaceId;
	}
	/**
	 * 获取：API点编号
	 */
	public Long getApiPlaceId() {
		return apiPlaceId;
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
