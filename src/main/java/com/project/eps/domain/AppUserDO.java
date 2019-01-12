package com.project.eps.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 主用户表
 * 
 * @author Yum
 * @email wtuada@126.com
 * @date 2019-01-07 18:22:34
 */
public class AppUserDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//用户编号
	private Long id;
	//区号
	private String countryCode;
	//用户名
	private String username;
	//密码
	private String password;
	//状态
	private Integer status;
	//注册时间
	private Long registerTime;
	//最后一次活跃时间
	private Long lastActiveTime;

	/**
	 * 设置：用户编号
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取：用户编号
	 */
	public Long getId() {
		return id;
	}
	/**
	 * 设置：区号
	 */
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	/**
	 * 获取：区号
	 */
	public String getCountryCode() {
		return countryCode;
	}
	/**
	 * 设置：用户名
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * 获取：用户名
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * 设置：密码
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * 获取：密码
	 */
	public String getPassword() {
		return password;
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
	 * 设置：注册时间
	 */
	public void setRegisterTime(Long registerTime) {
		this.registerTime = registerTime;
	}
	/**
	 * 获取：注册时间
	 */
	public Long getRegisterTime() {
		return registerTime;
	}
	/**
	 * 设置：最后一次活跃时间
	 */
	public void setLastActiveTime(Long lastActiveTime) {
		this.lastActiveTime = lastActiveTime;
	}
	/**
	 * 获取：最后一次活跃时间
	 */
	public Long getLastActiveTime() {
		return lastActiveTime;
	}
}
