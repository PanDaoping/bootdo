package com.bootdo.system.controller;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.lang.ObjectUtils;
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

import com.bootdo.system.domain.TbSysDicDO;
import com.bootdo.system.service.TbSysDicService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;

/**
 * 
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2019-06-25 13:11:18
 */
 
@Controller
@RequestMapping("/system/tbSysDic")
public class TbSysDicController {
	@Autowired
	private TbSysDicService tbSysDicService;
	
	@GetMapping()
	@RequiresPermissions("system:tbSysDic:tbSysDic")
	String TbSysDic(){
	    return "system/tbSysDic/tbSysDic";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("system:tbSysDic:tbSysDic")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<TbSysDicDO> tbSysDicList = tbSysDicService.list(query);
		int total = tbSysDicService.count(query);
		PageUtils pageUtils = new PageUtils(tbSysDicList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("system:tbSysDic:add")
	String add(){
	    return "system/tbSysDic/add";
	}

	@GetMapping("/edit/{dicId}")
	@RequiresPermissions("system:tbSysDic:edit")
	String edit(@PathVariable("dicId") String dicId,Model model){
		TbSysDicDO tbSysDic = tbSysDicService.get(dicId);
		model.addAttribute("tbSysDic", tbSysDic);
	    return "system/tbSysDic/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("system:tbSysDic:add")
	public R save( TbSysDicDO tbSysDic){
		tbSysDic.setDicId(ObjectUtils.toString(UUID.randomUUID().toString().replaceAll("-", "")));
		tbSysDic.setIsDelete(0);
		if(tbSysDicService.save(tbSysDic)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("system:tbSysDic:edit")
	public R update( TbSysDicDO tbSysDic){
		tbSysDicService.update(tbSysDic);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("system:tbSysDic:remove")
	public R remove( String dicId){
		if(tbSysDicService.remove(dicId)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("system:tbSysDic:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] dicIds){
		tbSysDicService.batchRemove(dicIds);
		return R.ok();
	}
	
}
