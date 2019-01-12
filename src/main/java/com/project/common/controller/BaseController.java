package com.project.common.controller;

import org.springframework.stereotype.Controller;

import com.project.common.utils.ShiroUtils;
import com.project.system.domain.UserDO;
import com.project.system.domain.UserToken;

@Controller
public class BaseController {
	public UserDO getUser() {
		return ShiroUtils.getUser();
	}

	public Long getUserId() {
		return getUser().getUserId();
	}

	public String getUsername() {
		return getUser().getUsername();
	}
}