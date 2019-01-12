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

import com.project.eps.domain.UserAccountDetailDO;
import com.project.eps.service.UserAccountDetailService;
import com.project.common.utils.PageUtils;
import com.project.common.utils.Query;
import com.project.common.utils.R;

/**
 * 用户账户明细表
 * 
 * @author Yum
 * @email wtuada@126.com
 * @date 2019-01-07 18:22:34
 */
 
@Controller
@RequestMapping("/eps/userAccountDetail")
public class UserAccountDetailController {
	@Autowired
	private UserAccountDetailService userAccountDetailService;
	
	@GetMapping()
	@RequiresPermissions("eps:userAccountDetail:userAccountDetail")
	String UserAccountDetail(){
	    return "eps/userAccountDetail/userAccountDetail";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("eps:userAccountDetail:userAccountDetail")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<UserAccountDetailDO> userAccountDetailList = userAccountDetailService.list(query);
		int total = userAccountDetailService.count(query);
		PageUtils pageUtils = new PageUtils(userAccountDetailList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("eps:userAccountDetail:add")
	String add(){
	    return "eps/userAccountDetail/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("eps:userAccountDetail:edit")
	String edit(@PathVariable("id") Long id,Model model){
		UserAccountDetailDO userAccountDetail = userAccountDetailService.get(id);
		model.addAttribute("userAccountDetail", userAccountDetail);
	    return "eps/userAccountDetail/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("eps:userAccountDetail:add")
	public R save( UserAccountDetailDO userAccountDetail){
		if(userAccountDetailService.save(userAccountDetail)>0){
			return R.ok();
		}
		return R.error();
	}
	 /**
     * JSON保存
     */
    @ResponseBody
    @PostMapping("/save-json")
    @RequiresPermissions("eps:userAccountDetail:add")
    public Object saveJson(@RequestBody JSONObject body){
        
        /*BaseResult<Object> result = userAccountDetailManager.saveJson(body);*/
        return null;
    }
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("eps:userAccountDetail:edit")
	public R update( UserAccountDetailDO userAccountDetail){
		userAccountDetailService.update(userAccountDetail);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("eps:userAccountDetail:remove")
	public R remove( Long id){
		if(userAccountDetailService.updateStatus(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("eps:userAccountDetail:batchRemove")
	public R remove(@RequestParam("ids[]") Long[] ids){
		userAccountDetailService.batchUpdateStatus(ids);
		return R.ok();
	}
	
}
