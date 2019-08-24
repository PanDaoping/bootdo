package com.bootdo.sales.controller;

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

import com.bootdo.sales.domain.TbSellContractListDO;
import com.bootdo.sales.service.TbSellContractListService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;

/**
 * 销售合同明细
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2019-04-12 14:24:57
 */
 
@Controller
@RequestMapping("/sales/tbSellContractList")
public class TbSellContractListController {
	@Autowired
	private TbSellContractListService tbSellContractListService;
	
	@GetMapping()
	@RequiresPermissions("sales:tbSellContractList:tbSellContractList")
	String TbSellContractList(){
	    return "sales/tbSellContractList/tbSellContractList";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("sales:tbSellContractList:tbSellContractList")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<TbSellContractListDO> tbSellContractListList = tbSellContractListService.list(query);
		int total = tbSellContractListService.count(query);
		PageUtils pageUtils = new PageUtils(tbSellContractListList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("sales:tbSellContractList:add")
	String add(){
	    return "sales/tbSellContractList/add";
	}

	@GetMapping("/edit/{listGuid}")
	@RequiresPermissions("sales:tbSellContractList:edit")
	String edit(@PathVariable("listGuid") String listGuid,Model model){
		TbSellContractListDO tbSellContractList = tbSellContractListService.get(listGuid);
		model.addAttribute("tbSellContractList", tbSellContractList);
	    return "sales/tbSellContractList/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("sales:tbSellContractList:add")
	public R save( TbSellContractListDO tbSellContractList){
		if(tbSellContractListService.save(tbSellContractList)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("sales:tbSellContractList:edit")
	public R update( TbSellContractListDO tbSellContractList){
		tbSellContractListService.update(tbSellContractList);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("sales:tbSellContractList:remove")
	public R remove( String listGuid){
		if(tbSellContractListService.remove(listGuid)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("sales:tbSellContractList:batchRemove")
	public R remove(@RequestParam("ids[]") String[] listGuids){
		tbSellContractListService.batchRemove(listGuids);
		return R.ok();
	}
	
}
