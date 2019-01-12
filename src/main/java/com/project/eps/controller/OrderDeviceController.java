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

import com.project.eps.domain.OrderDeviceDO;
import com.project.eps.service.OrderDeviceService;
import com.project.common.utils.PageUtils;
import com.project.common.utils.Query;
import com.project.common.utils.R;

/**
 * 订单设备关系表
 * 
 * @author Yum
 * @email wtuada@126.com
 * @date 2019-01-07 18:22:34
 */
 
@Controller
@RequestMapping("/eps/orderDevice")
public class OrderDeviceController {
	@Autowired
	private OrderDeviceService orderDeviceService;
	
	@GetMapping()
	@RequiresPermissions("eps:orderDevice:orderDevice")
	String OrderDevice(){
	    return "eps/orderDevice/orderDevice";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("eps:orderDevice:orderDevice")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<OrderDeviceDO> orderDeviceList = orderDeviceService.list(query);
		int total = orderDeviceService.count(query);
		PageUtils pageUtils = new PageUtils(orderDeviceList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("eps:orderDevice:add")
	String add(){
	    return "eps/orderDevice/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("eps:orderDevice:edit")
	String edit(@PathVariable("id") Long id,Model model){
		OrderDeviceDO orderDevice = orderDeviceService.get(id);
		model.addAttribute("orderDevice", orderDevice);
	    return "eps/orderDevice/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("eps:orderDevice:add")
	public R save( OrderDeviceDO orderDevice){
		if(orderDeviceService.save(orderDevice)>0){
			return R.ok();
		}
		return R.error();
	}
	 /**
     * JSON保存
     */
    @ResponseBody
    @PostMapping("/save-json")
    @RequiresPermissions("eps:orderDevice:add")
    public Object saveJson(@RequestBody JSONObject body){
        
        /*BaseResult<Object> result = orderDeviceManager.saveJson(body);*/
        return null;
    }
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("eps:orderDevice:edit")
	public R update( OrderDeviceDO orderDevice){
		orderDeviceService.update(orderDevice);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("eps:orderDevice:remove")
	public R remove( Long id){
		if(orderDeviceService.updateStatus(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("eps:orderDevice:batchRemove")
	public R remove(@RequestParam("ids[]") Long[] ids){
		orderDeviceService.batchUpdateStatus(ids);
		return R.ok();
	}
	
}
