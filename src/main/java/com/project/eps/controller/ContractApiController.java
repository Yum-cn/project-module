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

import com.project.eps.domain.ContractApiDO;
import com.project.eps.service.ContractApiService;
import com.project.common.utils.PageUtils;
import com.project.common.utils.Query;
import com.project.common.utils.R;

/**
 * 合同API表
 * 
 * @author Yum
 * @email wtuada@126.com
 * @date 2019-01-07 18:22:33
 */
 
@Controller
@RequestMapping("/eps/contractApi")
public class ContractApiController {
	@Autowired
	private ContractApiService contractApiService;
	
	@GetMapping()
	@RequiresPermissions("eps:contractApi:contractApi")
	String ContractApi(){
	    return "eps/contractApi/contractApi";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("eps:contractApi:contractApi")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<ContractApiDO> contractApiList = contractApiService.list(query);
		int total = contractApiService.count(query);
		PageUtils pageUtils = new PageUtils(contractApiList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("eps:contractApi:add")
	String add(){
	    return "eps/contractApi/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("eps:contractApi:edit")
	String edit(@PathVariable("id") Long id,Model model){
		ContractApiDO contractApi = contractApiService.get(id);
		model.addAttribute("contractApi", contractApi);
	    return "eps/contractApi/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("eps:contractApi:add")
	public R save( ContractApiDO contractApi){
		if(contractApiService.save(contractApi)>0){
			return R.ok();
		}
		return R.error();
	}
	 /**
     * JSON保存
     */
    @ResponseBody
    @PostMapping("/save-json")
    @RequiresPermissions("eps:contractApi:add")
    public Object saveJson(@RequestBody JSONObject body){
        
        /*BaseResult<Object> result = contractApiManager.saveJson(body);*/
        return null;
    }
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("eps:contractApi:edit")
	public R update( ContractApiDO contractApi){
		contractApiService.update(contractApi);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("eps:contractApi:remove")
	public R remove( Long id){
		if(contractApiService.updateStatus(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("eps:contractApi:batchRemove")
	public R remove(@RequestParam("ids[]") Long[] ids){
		contractApiService.batchUpdateStatus(ids);
		return R.ok();
	}
	
}
