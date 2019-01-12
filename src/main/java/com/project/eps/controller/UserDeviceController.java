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

import com.project.eps.domain.UserDeviceDO;
import com.project.eps.service.UserDeviceService;
import com.project.common.utils.PageUtils;
import com.project.common.utils.Query;
import com.project.common.utils.R;

/**
 * 用户设备表
 * 
 * @author Yum
 * @email wtuada@126.com
 * @date 2019-01-07 18:22:34
 */
 
@Controller
@RequestMapping("/eps/userDevice")
public class UserDeviceController {
	@Autowired
	private UserDeviceService userDeviceService;
	
	@GetMapping()
	@RequiresPermissions("eps:userDevice:userDevice")
	String UserDevice(){
	    return "eps/userDevice/userDevice";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("eps:userDevice:userDevice")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<UserDeviceDO> userDeviceList = userDeviceService.list(query);
		int total = userDeviceService.count(query);
		PageUtils pageUtils = new PageUtils(userDeviceList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("eps:userDevice:add")
	String add(){
	    return "eps/userDevice/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("eps:userDevice:edit")
	String edit(@PathVariable("id") Long id,Model model){
		UserDeviceDO userDevice = userDeviceService.get(id);
		model.addAttribute("userDevice", userDevice);
	    return "eps/userDevice/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("eps:userDevice:add")
	public R save( UserDeviceDO userDevice){
		if(userDeviceService.save(userDevice)>0){
			return R.ok();
		}
		return R.error();
	}
	 /**
     * JSON保存
     */
    @ResponseBody
    @PostMapping("/save-json")
    @RequiresPermissions("eps:userDevice:add")
    public Object saveJson(@RequestBody JSONObject body){
        
        /*BaseResult<Object> result = userDeviceManager.saveJson(body);*/
        return null;
    }
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("eps:userDevice:edit")
	public R update( UserDeviceDO userDevice){
		userDeviceService.update(userDevice);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("eps:userDevice:remove")
	public R remove( Long id){
		if(userDeviceService.updateStatus(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("eps:userDevice:batchRemove")
	public R remove(@RequestParam("ids[]") Long[] ids){
		userDeviceService.batchUpdateStatus(ids);
		return R.ok();
	}
	
}
