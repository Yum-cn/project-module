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

import com.project.eps.domain.UserLocationDO;
import com.project.eps.service.UserLocationService;
import com.project.common.utils.PageUtils;
import com.project.common.utils.Query;
import com.project.common.utils.R;

/**
 * 用户位置表
 * 
 * @author Yum
 * @email wtuada@126.com
 * @date 2019-01-07 18:22:35
 */
 
@Controller
@RequestMapping("/eps/userLocation")
public class UserLocationController {
	@Autowired
	private UserLocationService userLocationService;
	
	@GetMapping()
	@RequiresPermissions("eps:userLocation:userLocation")
	String UserLocation(){
	    return "eps/userLocation/userLocation";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("eps:userLocation:userLocation")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<UserLocationDO> userLocationList = userLocationService.list(query);
		int total = userLocationService.count(query);
		PageUtils pageUtils = new PageUtils(userLocationList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("eps:userLocation:add")
	String add(){
	    return "eps/userLocation/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("eps:userLocation:edit")
	String edit(@PathVariable("id") Long id,Model model){
		UserLocationDO userLocation = userLocationService.get(id);
		model.addAttribute("userLocation", userLocation);
	    return "eps/userLocation/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("eps:userLocation:add")
	public R save( UserLocationDO userLocation){
		if(userLocationService.save(userLocation)>0){
			return R.ok();
		}
		return R.error();
	}
	 /**
     * JSON保存
     */
    @ResponseBody
    @PostMapping("/save-json")
    @RequiresPermissions("eps:userLocation:add")
    public Object saveJson(@RequestBody JSONObject body){
        
        /*BaseResult<Object> result = userLocationManager.saveJson(body);*/
        return null;
    }
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("eps:userLocation:edit")
	public R update( UserLocationDO userLocation){
		userLocationService.update(userLocation);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("eps:userLocation:remove")
	public R remove( Long id){
		if(userLocationService.updateStatus(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("eps:userLocation:batchRemove")
	public R remove(@RequestParam("ids[]") Long[] ids){
		userLocationService.batchUpdateStatus(ids);
		return R.ok();
	}
	
}
