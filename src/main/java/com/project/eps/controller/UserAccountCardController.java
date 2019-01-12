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

import com.project.eps.domain.UserAccountCardDO;
import com.project.eps.service.UserAccountCardService;
import com.project.common.utils.PageUtils;
import com.project.common.utils.Query;
import com.project.common.utils.R;

/**
 * 用户账户卡号表
 * 
 * @author Yum
 * @email wtuada@126.com
 * @date 2019-01-07 18:22:34
 */
 
@Controller
@RequestMapping("/eps/userAccountCard")
public class UserAccountCardController {
	@Autowired
	private UserAccountCardService userAccountCardService;
	
	@GetMapping()
	@RequiresPermissions("eps:userAccountCard:userAccountCard")
	String UserAccountCard(){
	    return "eps/userAccountCard/userAccountCard";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("eps:userAccountCard:userAccountCard")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<UserAccountCardDO> userAccountCardList = userAccountCardService.list(query);
		int total = userAccountCardService.count(query);
		PageUtils pageUtils = new PageUtils(userAccountCardList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("eps:userAccountCard:add")
	String add(){
	    return "eps/userAccountCard/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("eps:userAccountCard:edit")
	String edit(@PathVariable("id") Long id,Model model){
		UserAccountCardDO userAccountCard = userAccountCardService.get(id);
		model.addAttribute("userAccountCard", userAccountCard);
	    return "eps/userAccountCard/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("eps:userAccountCard:add")
	public R save( UserAccountCardDO userAccountCard){
		if(userAccountCardService.save(userAccountCard)>0){
			return R.ok();
		}
		return R.error();
	}
	 /**
     * JSON保存
     */
    @ResponseBody
    @PostMapping("/save-json")
    @RequiresPermissions("eps:userAccountCard:add")
    public Object saveJson(@RequestBody JSONObject body){
        
        /*BaseResult<Object> result = userAccountCardManager.saveJson(body);*/
        return null;
    }
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("eps:userAccountCard:edit")
	public R update( UserAccountCardDO userAccountCard){
		userAccountCardService.update(userAccountCard);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("eps:userAccountCard:remove")
	public R remove( Long id){
		if(userAccountCardService.updateStatus(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("eps:userAccountCard:batchRemove")
	public R remove(@RequestParam("ids[]") Long[] ids){
		userAccountCardService.batchUpdateStatus(ids);
		return R.ok();
	}
	
}
