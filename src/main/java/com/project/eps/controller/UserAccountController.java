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

import com.project.eps.domain.UserAccountDO;
import com.project.eps.service.UserAccountService;
import com.project.common.utils.PageUtils;
import com.project.common.utils.Query;
import com.project.common.utils.R;

/**
 * 用户账户表
 * 
 * @author Yum
 * @email wtuada@126.com
 * @date 2019-01-07 18:22:34
 */
 
@Controller
@RequestMapping("/eps/userAccount")
public class UserAccountController {
	@Autowired
	private UserAccountService userAccountService;
	
	@GetMapping()
	@RequiresPermissions("eps:userAccount:userAccount")
	String UserAccount(){
	    return "eps/userAccount/userAccount";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("eps:userAccount:userAccount")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<UserAccountDO> userAccountList = userAccountService.list(query);
		int total = userAccountService.count(query);
		PageUtils pageUtils = new PageUtils(userAccountList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("eps:userAccount:add")
	String add(){
	    return "eps/userAccount/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("eps:userAccount:edit")
	String edit(@PathVariable("id") Long id,Model model){
		UserAccountDO userAccount = userAccountService.get(id);
		model.addAttribute("userAccount", userAccount);
	    return "eps/userAccount/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("eps:userAccount:add")
	public R save( UserAccountDO userAccount){
		if(userAccountService.save(userAccount)>0){
			return R.ok();
		}
		return R.error();
	}
	 /**
     * JSON保存
     */
    @ResponseBody
    @PostMapping("/save-json")
    @RequiresPermissions("eps:userAccount:add")
    public Object saveJson(@RequestBody JSONObject body){
        
        /*BaseResult<Object> result = userAccountManager.saveJson(body);*/
        return null;
    }
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("eps:userAccount:edit")
	public R update( UserAccountDO userAccount){
		userAccountService.update(userAccount);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("eps:userAccount:remove")
	public R remove( Long id){
		if(userAccountService.updateStatus(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("eps:userAccount:batchRemove")
	public R remove(@RequestParam("ids[]") Long[] ids){
		userAccountService.batchUpdateStatus(ids);
		return R.ok();
	}
	
}
