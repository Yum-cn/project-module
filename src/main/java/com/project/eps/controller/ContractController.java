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

import com.project.eps.domain.ContractDO;
import com.project.eps.service.ContractService;
import com.project.common.utils.PageUtils;
import com.project.common.utils.Query;
import com.project.common.utils.R;

/**
 * 合同表
 * 
 * @author Yum
 * @email wtuada@126.com
 * @date 2019-01-07 18:22:33
 */
 
@Controller
@RequestMapping("/eps/contract")
public class ContractController {
	@Autowired
	private ContractService contractService;
	
	@GetMapping()
	@RequiresPermissions("eps:contract:contract")
	String Contract(){
	    return "eps/contract/contract";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("eps:contract:contract")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<ContractDO> contractList = contractService.list(query);
		int total = contractService.count(query);
		PageUtils pageUtils = new PageUtils(contractList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("eps:contract:add")
	String add(){
	    return "eps/contract/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("eps:contract:edit")
	String edit(@PathVariable("id") Long id,Model model){
		ContractDO contract = contractService.get(id);
		model.addAttribute("contract", contract);
	    return "eps/contract/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("eps:contract:add")
	public R save( ContractDO contract){
		if(contractService.save(contract)>0){
			return R.ok();
		}
		return R.error();
	}
	 /**
     * JSON保存
     */
    @ResponseBody
    @PostMapping("/save-json")
    @RequiresPermissions("eps:contract:add")
    public Object saveJson(@RequestBody JSONObject body){
        
        /*BaseResult<Object> result = contractManager.saveJson(body);*/
        return null;
    }
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("eps:contract:edit")
	public R update( ContractDO contract){
		contractService.update(contract);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("eps:contract:remove")
	public R remove( Long id){
		if(contractService.updateStatus(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("eps:contract:batchRemove")
	public R remove(@RequestParam("ids[]") Long[] ids){
		contractService.batchUpdateStatus(ids);
		return R.ok();
	}
	
}
