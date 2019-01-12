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

import com.project.eps.domain.OrderDetailDO;
import com.project.eps.service.OrderDetailService;
import com.project.common.utils.PageUtils;
import com.project.common.utils.Query;
import com.project.common.utils.R;

/**
 * 订单明细表
 * 
 * @author Yum
 * @email wtuada@126.com
 * @date 2019-01-07 18:22:34
 */
 
@Controller
@RequestMapping("/eps/orderDetail")
public class OrderDetailController {
	@Autowired
	private OrderDetailService orderDetailService;
	
	@GetMapping()
	@RequiresPermissions("eps:orderDetail:orderDetail")
	String OrderDetail(){
	    return "eps/orderDetail/orderDetail";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("eps:orderDetail:orderDetail")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<OrderDetailDO> orderDetailList = orderDetailService.list(query);
		int total = orderDetailService.count(query);
		PageUtils pageUtils = new PageUtils(orderDetailList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("eps:orderDetail:add")
	String add(){
	    return "eps/orderDetail/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("eps:orderDetail:edit")
	String edit(@PathVariable("id") Long id,Model model){
		OrderDetailDO orderDetail = orderDetailService.get(id);
		model.addAttribute("orderDetail", orderDetail);
	    return "eps/orderDetail/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("eps:orderDetail:add")
	public R save( OrderDetailDO orderDetail){
		if(orderDetailService.save(orderDetail)>0){
			return R.ok();
		}
		return R.error();
	}
	 /**
     * JSON保存
     */
    @ResponseBody
    @PostMapping("/save-json")
    @RequiresPermissions("eps:orderDetail:add")
    public Object saveJson(@RequestBody JSONObject body){
        
        /*BaseResult<Object> result = orderDetailManager.saveJson(body);*/
        return null;
    }
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("eps:orderDetail:edit")
	public R update( OrderDetailDO orderDetail){
		orderDetailService.update(orderDetail);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("eps:orderDetail:remove")
	public R remove( Long id){
		if(orderDetailService.updateStatus(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("eps:orderDetail:batchRemove")
	public R remove(@RequestParam("ids[]") Long[] ids){
		orderDetailService.batchUpdateStatus(ids);
		return R.ok();
	}
	
}
