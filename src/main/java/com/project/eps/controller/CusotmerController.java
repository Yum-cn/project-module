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

import com.project.eps.domain.CusotmerDO;
import com.project.eps.service.CusotmerService;
import com.project.common.utils.PageUtils;
import com.project.common.utils.Query;
import com.project.common.utils.R;

/**
 * 客户信息表
 * 
 * @author Yum
 * @email wtuada@126.com
 * @date 2019-01-07 18:22:33
 */
 
@Controller
@RequestMapping("/eps/cusotmer")
public class CusotmerController {
	@Autowired
	private CusotmerService cusotmerService;
	
	@GetMapping()
	@RequiresPermissions("eps:cusotmer:cusotmer")
	String Cusotmer(){
	    return "eps/cusotmer/cusotmer";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("eps:cusotmer:cusotmer")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<CusotmerDO> cusotmerList = cusotmerService.list(query);
		int total = cusotmerService.count(query);
		PageUtils pageUtils = new PageUtils(cusotmerList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("eps:cusotmer:add")
	String add(){
	    return "eps/cusotmer/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("eps:cusotmer:edit")
	String edit(@PathVariable("id") Long id,Model model){
		CusotmerDO cusotmer = cusotmerService.get(id);
		model.addAttribute("cusotmer", cusotmer);
	    return "eps/cusotmer/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("eps:cusotmer:add")
	public R save( CusotmerDO cusotmer){
		if(cusotmerService.save(cusotmer)>0){
			return R.ok();
		}
		return R.error();
	}
	 /**
     * JSON保存
     */
    @ResponseBody
    @PostMapping("/save-json")
    @RequiresPermissions("eps:cusotmer:add")
    public Object saveJson(@RequestBody JSONObject body){
        
        /*BaseResult<Object> result = cusotmerManager.saveJson(body);*/
        return null;
    }
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("eps:cusotmer:edit")
	public R update( CusotmerDO cusotmer){
		cusotmerService.update(cusotmer);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("eps:cusotmer:remove")
	public R remove( Long id){
		if(cusotmerService.updateStatus(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("eps:cusotmer:batchRemove")
	public R remove(@RequestParam("ids[]") Long[] ids){
		cusotmerService.batchUpdateStatus(ids);
		return R.ok();
	}
	
}
