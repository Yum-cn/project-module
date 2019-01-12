package com.project.eps.controller;

import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import net.sf.json.JSONObject;

import com.project.eps.domain.UserInfoDO;
import com.project.eps.service.UserInfoService;
import com.project.common.utils.PageUtils;
import com.project.common.utils.Query;
import com.project.common.utils.R;

/**
 * 用户扩展信息表
 * 
 * @author Yum
 * @email wtuada@126.com
 * @date 2019-01-07 18:22:34
 */
 
@Controller
@RequestMapping("/eps/userInfo")
public class UserInfoController {
	@Autowired
	private UserInfoService userInfoService;
	
	@GetMapping()
	@RequiresPermissions("eps:userInfo:userInfo")
	String UserInfo(){
	    return "eps/userInfo/userInfo";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("eps:userInfo:userInfo")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<UserInfoDO> userInfoList = userInfoService.list(query);
		int total = userInfoService.count(query);
		PageUtils pageUtils = new PageUtils(userInfoList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("eps:userInfo:add")
	String add(){
	    return "eps/userInfo/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("eps:userInfo:edit")
	String edit(@PathVariable("id") Long id,Model model){
		UserInfoDO userInfo = userInfoService.get(id);
		model.addAttribute("userInfo", userInfo);
	    return "eps/userInfo/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("eps:userInfo:add")
	public R save( UserInfoDO userInfo){
		if(userInfoService.save(userInfo)>0){
			return R.ok();
		}
		return R.error();
	}
	 /**
     * JSON保存
     */
    @ResponseBody
    @PostMapping("/save-json")
    @RequiresPermissions("eps:userInfo:add")
    public Object saveJson(@RequestBody JSONObject body){
        
        /*BaseResult<Object> result = userInfoManager.saveJson(body);*/
        return null;
    }
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("eps:userInfo:edit")
	public R update( UserInfoDO userInfo){
		userInfoService.update(userInfo);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("eps:userInfo:remove")
	public R remove( Long id){
		if(userInfoService.updateStatus(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("eps:userInfo:batchRemove")
	public R remove(@RequestParam("ids[]") Long[] ids){
		userInfoService.batchUpdateStatus(ids);
		return R.ok();
	}
	
}
