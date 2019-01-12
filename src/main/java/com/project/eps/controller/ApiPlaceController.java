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

import com.project.eps.domain.ApiPlaceDO;
import com.project.eps.service.ApiPlaceService;
import com.project.common.utils.PageUtils;
import com.project.common.utils.Query;
import com.project.common.utils.R;

/**
 * API点表
 * 
 * @author Yum
 * @email wtuada@126.com
 * @date 2019-01-07 18:22:33
 */
 
@Controller
@RequestMapping("/eps/apiPlace")
public class ApiPlaceController {
	@Autowired
	private ApiPlaceService apiPlaceService;
	
	@GetMapping()
	@RequiresPermissions("eps:apiPlace:apiPlace")
	String ApiPlace(){
	    return "eps/apiPlace/apiPlace";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("eps:apiPlace:apiPlace")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<ApiPlaceDO> apiPlaceList = apiPlaceService.list(query);
		int total = apiPlaceService.count(query);
		PageUtils pageUtils = new PageUtils(apiPlaceList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("eps:apiPlace:add")
	String add(){
	    return "eps/apiPlace/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("eps:apiPlace:edit")
	String edit(@PathVariable("id") Long id,Model model){
		ApiPlaceDO apiPlace = apiPlaceService.get(id);
		model.addAttribute("apiPlace", apiPlace);
	    return "eps/apiPlace/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("eps:apiPlace:add")
	public R save( ApiPlaceDO apiPlace){
		if(apiPlaceService.save(apiPlace)>0){
			return R.ok();
		}
		return R.error();
	}
	 /**
     * JSON保存
     */
    @ResponseBody
    @PostMapping("/save-json")
    @RequiresPermissions("eps:apiPlace:add")
    public Object saveJson(@RequestBody JSONObject body){
        
        /*BaseResult<Object> result = apiPlaceManager.saveJson(body);*/
        return null;
    }
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("eps:apiPlace:edit")
	public R update( ApiPlaceDO apiPlace){
		apiPlaceService.update(apiPlace);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("eps:apiPlace:remove")
	public R remove( Long id){
		if(apiPlaceService.updateStatus(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("eps:apiPlace:batchRemove")
	public R remove(@RequestParam("ids[]") Long[] ids){
		apiPlaceService.batchUpdateStatus(ids);
		return R.ok();
	}
	
}
