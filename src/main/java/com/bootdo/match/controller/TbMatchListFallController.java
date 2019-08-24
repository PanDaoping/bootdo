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

import com.bootdo.match.domain.TbMatchListFallDO;
import com.bootdo.match.service.TbMatchListFallService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;

/**
 * 
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2019-07-13 16:47:23
 */
 
@Controller
@RequestMapping("/match/tbMatchListFall")
public class TbMatchListFallController {
	@Autowired
	private TbMatchListFallService tbMatchListFallService;
	
	@GetMapping()
	@RequiresPermissions("match:tbMatchListFall:tbMatchListFall")
	String TbMatchListFall(){
	    return "match/tbMatchListFall/tbMatchListFall";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("match:tbMatchListFall:tbMatchListFall")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<TbMatchListFallDO> tbMatchListFallList = tbMatchListFallService.list(query);
		int total = tbMatchListFallService.count(query);
		PageUtils pageUtils = new PageUtils(tbMatchListFallList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("match:tbMatchListFall:add")
	String add(){
	    return "match/tbMatchListFall/add";
	}

	@GetMapping("/edit/{matchListGuid}")
	@RequiresPermissions("match:tbMatchListFall:edit")
	String edit(@PathVariable("matchListGuid") String matchListGuid,Model model){
		TbMatchListFallDO tbMatchListFall = tbMatchListFallService.get(matchListGuid);
		model.addAttribute("tbMatchListFall", tbMatchListFall);
	    return "match/tbMatchListFall/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("match:tbMatchListFall:add")
	public R save( TbMatchListFallDO tbMatchListFall){
		if(tbMatchListFallService.save(tbMatchListFall)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("match:tbMatchListFall:edit")
	public R update( TbMatchListFallDO tbMatchListFall){
		tbMatchListFallService.update(tbMatchListFall);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("match:tbMatchListFall:remove")
	public R remove( String matchListGuid){
		if(tbMatchListFallService.remove(matchListGuid)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("match:tbMatchListFall:batchRemove")
	public R remove(@RequestParam("ids[]") String[] matchListGuids){
		tbMatchListFallService.batchRemove(matchListGuids);
		return R.ok();
	}
	
}
