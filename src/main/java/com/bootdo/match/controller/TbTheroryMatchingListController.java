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

import com.bootdo.match.domain.TbTheroryMatchingListDO;
import com.bootdo.match.service.TbTheroryMatchingListService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;

/**
 * 
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2019-07-10 15:56:58
 */
 
@Controller
@RequestMapping("/match/tbTheroryMatchingList")
public class TbTheroryMatchingListController {
	@Autowired
	private TbTheroryMatchingListService tbTheroryMatchingListService;
	
	@GetMapping()
	@RequiresPermissions("match:tbTheroryMatchingList:tbTheroryMatchingList")
	String TbTheroryMatchingList(){
	    return "match/tbTheroryMatchingList/tbTheroryMatchingList";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("match:tbTheroryMatchingList:tbTheroryMatchingList")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<TbTheroryMatchingListDO> tbTheroryMatchingListList = tbTheroryMatchingListService.list(query);
		int total = tbTheroryMatchingListService.count(query);
		PageUtils pageUtils = new PageUtils(tbTheroryMatchingListList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("match:tbTheroryMatchingList:add")
	String add(){
	    return "match/tbTheroryMatchingList/add";
	}

	@GetMapping("/edit/{theroryListGuid}")
	@RequiresPermissions("match:tbTheroryMatchingList:edit")
	String edit(@PathVariable("theroryListGuid") String theroryListGuid,Model model){
		TbTheroryMatchingListDO tbTheroryMatchingList = tbTheroryMatchingListService.get(theroryListGuid);
		model.addAttribute("tbTheroryMatchingList", tbTheroryMatchingList);
	    return "match/tbTheroryMatchingList/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("match:tbTheroryMatchingList:add")
	public R save( TbTheroryMatchingListDO tbTheroryMatchingList){
		if(tbTheroryMatchingListService.save(tbTheroryMatchingList)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("match:tbTheroryMatchingList:edit")
	public R update( TbTheroryMatchingListDO tbTheroryMatchingList){
		tbTheroryMatchingListService.update(tbTheroryMatchingList);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("match:tbTheroryMatchingList:remove")
	public R remove( String theroryListGuid){
		if(tbTheroryMatchingListService.remove(theroryListGuid)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("match:tbTheroryMatchingList:batchRemove")
	public R remove(@RequestParam("ids[]") String[] theroryListGuids){
		tbTheroryMatchingListService.batchRemove(theroryListGuids);
		return R.ok();
	}
	
}
