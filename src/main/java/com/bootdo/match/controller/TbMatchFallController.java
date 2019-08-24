package com.bootdo.match.controller;

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

import com.bootdo.match.domain.TbMatchFallDO;
import com.bootdo.match.service.TbMatchFallService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;

/**
 * 配比下发
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2019-07-13 16:47:23
 */
 
@Controller
@RequestMapping("/match/tbMatchFall")
public class TbMatchFallController {
	@Autowired
	private TbMatchFallService tbMatchFallService;
	
	@GetMapping()
	@RequiresPermissions("match:tbMatchFall:tbMatchFall")
	String TbMatchFall(){
	    return "match/tbMatchFall/tbMatchFall";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("match:tbMatchFall:tbMatchFall")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<TbMatchFallDO> tbMatchFallList = tbMatchFallService.list(query);
		int total = tbMatchFallService.count(query);
		PageUtils pageUtils = new PageUtils(tbMatchFallList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("match:tbMatchFall:add")
	String add(){
	    return "match/tbMatchFall/add";
	}

	@GetMapping("/edit/{matchGuid}")
	@RequiresPermissions("match:tbMatchFall:edit")
	String edit(@PathVariable("matchGuid") String matchGuid,Model model){
		TbMatchFallDO tbMatchFall = tbMatchFallService.get(matchGuid);
		model.addAttribute("tbMatchFall", tbMatchFall);
	    return "match/tbMatchFall/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("match:tbMatchFall:add")
	public R save( TbMatchFallDO tbMatchFall){
		if(tbMatchFallService.save(tbMatchFall)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("match:tbMatchFall:edit")
	public R update( TbMatchFallDO tbMatchFall){
		tbMatchFallService.update(tbMatchFall);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("match:tbMatchFall:remove")
	public R remove( String matchGuid){
		if(tbMatchFallService.remove(matchGuid)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("match:tbMatchFall:batchRemove")
	public R remove(@RequestParam("ids[]") String[] matchGuids){
		tbMatchFallService.batchRemove(matchGuids);
		return R.ok();
	}
	
}
