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

import com.project.eps.domain.UserWithdrawDO;
import com.project.eps.service.UserWithdrawService;
import com.project.common.utils.PageUtils;
import com.project.common.utils.Query;
import com.project.common.utils.R;

/**
 * 用户提现表
 * 
 * @author Yum
 * @email wtuada@126.com
 * @date 2019-01-07 18:22:35
 */
 
@Controller
@RequestMapping("/eps/userWithdraw")
public class UserWithdrawController {
	@Autowired
	private UserWithdrawService userWithdrawService;
	
	@GetMapping()
	@RequiresPermissions("eps:userWithdraw:userWithdraw")
	String UserWithdraw(){
	    return "eps/userWithdraw/userWithdraw";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("eps:userWithdraw:userWithdraw")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<UserWithdrawDO> userWithdrawList = userWithdrawService.list(query);
		int total = userWithdrawService.count(query);
		PageUtils pageUtils = new PageUtils(userWithdrawList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("eps:userWithdraw:add")
	String add(){
	    return "eps/userWithdraw/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("eps:userWithdraw:edit")
	String edit(@PathVariable("id") Long id,Model model){
		UserWithdrawDO userWithdraw = userWithdrawService.get(id);
		model.addAttribute("userWithdraw", userWithdraw);
	    return "eps/userWithdraw/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("eps:userWithdraw:add")
	public R save( UserWithdrawDO userWithdraw){
		if(userWithdrawService.save(userWithdraw)>0){
			return R.ok();
		}
		return R.error();
	}
	 /**
     * JSON保存
     */
    @ResponseBody
    @PostMapping("/save-json")
    @RequiresPermissions("eps:userWithdraw:add")
    public Object saveJson(@RequestBody JSONObject body){
        
        /*BaseResult<Object> result = userWithdrawManager.saveJson(body);*/
        return null;
    }
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("eps:userWithdraw:edit")
	public R update( UserWithdrawDO userWithdraw){
		userWithdrawService.update(userWithdraw);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("eps:userWithdraw:remove")
	public R remove( Long id){
		if(userWithdrawService.updateStatus(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("eps:userWithdraw:batchRemove")
	public R remove(@RequestParam("ids[]") Long[] ids){
		userWithdrawService.batchUpdateStatus(ids);
		return R.ok();
	}
	
}
