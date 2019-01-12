package com.project.eps.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 用户渲染对象
 * @author Yum
 * @email wtuada@126.com
 * @date 2019-01-07 18:22:34
 */
public class AppUserVO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//用户编号
	private Long user_id;
	//区号
	private String country_code;
	//用户名
	private String username;
	//注册时间
	private Long register_time;
	//手机号
	private String phone;
	
	public Long getUser_id() {
		return user_id;
	}
	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}
	public String getCountry_code() {
		return country_code;
	}
	public void setCountry_code(String country_code) {
		this.country_code = country_code;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Long getRegister_time() {
		return register_time;
	}
	public void setRegister_time(Long register_time) {
		this.register_time = register_time;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}

	
}
