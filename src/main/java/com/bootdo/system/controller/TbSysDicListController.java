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

import com.bootdo.system.domain.TbSysDicListDO;
import com.bootdo.system.service.TbSysDicListService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;

/**
 * 数据字典分类表
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2019-06-25 13:11:18
 */
 
@Controller
@RequestMapping("/system/tbSysDicList")
public class TbSysDicListController {
	@Autowired
	private TbSysDicListService tbSysDicListService;
	
	@GetMapping()
	@RequiresPermissions("system:tbSysDic:tbSysDic")
	String TbSysDicList(){
	    return "system/tbSysDicList/tbSysDicList";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("system:tbSysDic:tbSysDic")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<TbSysDicListDO> tbSysDicListList = tbSysDicListService.list(query);
		int total = tbSysDicListService.count(query);
		PageUtils pageUtils = new PageUtils(tbSysDicListList, total);
		return pageUtils;
	}
	
	@GetMapping("/add/{typeTag}")
	@RequiresPermissions("system:tbSysDicList:add")
	String add(@PathVariable("typeTag") String typeTag,Model model){
		model.addAttribute("typeTag", typeTag);
		return "system/tbSysDicList/add";
	}

	@GetMapping("/edit/{dicListId}")
	@RequiresPermissions("system:tbSysDicList:edit")
	String edit(@PathVariable("dicListId") String dicListId,Model model){
		TbSysDicListDO tbSysDicList = tbSysDicListService.get(dicListId);
		model.addAttribute("tbSysDicList", tbSysDicList);
	    return "system/tbSysDicList/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("system:tbSysDicList:add")
	public R save( TbSysDicListDO tbSysDicList){
		tbSysDicList.setDicListId(ObjectUtils.toString(UUID.randomUUID().toString().replaceAll("-", "")));
		tbSysDicList.setIsDelete(0);
		if(tbSysDicListService.save(tbSysDicList)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("system:tbSysDicList:edit")
	public R update( TbSysDicListDO tbSysDicList){
		tbSysDicListService.update(tbSysDicList);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("system:tbSysDicList:remove")
	public R remove( String dicListId){
		if(tbSysDicListService.remove(dicListId)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("system:tbSysDicList:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] dicListIds){
		tbSysDicListService.batchRemove(dicListIds);
		return R.ok();
	}
	
}
