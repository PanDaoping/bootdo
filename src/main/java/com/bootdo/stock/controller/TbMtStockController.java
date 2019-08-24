package com.bootdo.stock.controller;

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

import com.bootdo.stock.domain.TbMtStockDO;
import com.bootdo.stock.service.TbMtStockService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;

/**
 * 资产（材料）库存表
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2019-04-12 14:20:07
 */
 
@Controller
@RequestMapping("/stock/tbMtStock")
public class TbMtStockController {
	@Autowired
	private TbMtStockService tbMtStockService;
	
	@GetMapping()
	@RequiresPermissions("stock:tbMtStock:tbMtStock")
	String TbMtStock(){
	    return "stock/tbMtStock/tbMtStock";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("stock:tbMtStock:tbMtStock")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<TbMtStockDO> tbMtStockList = tbMtStockService.list(query);
		int total = tbMtStockService.count(query);
		PageUtils pageUtils = new PageUtils(tbMtStockList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("stock:tbMtStock:add")
	String add(){
	    return "stock/tbMtStock/add";
	}

	@GetMapping("/edit/{mtCode}")
	@RequiresPermissions("stock:tbMtStock:edit")
	String edit(@PathVariable("mtCode") String mtCode,Model model){
		TbMtStockDO tbMtStock = tbMtStockService.get(mtCode);
		model.addAttribute("tbMtStock", tbMtStock);
	    return "stock/tbMtStock/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("stock:tbMtStock:add")
	public R save( TbMtStockDO tbMtStock){
		if(tbMtStockService.save(tbMtStock)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("stock:tbMtStock:edit")
	public R update( TbMtStockDO tbMtStock){
		tbMtStockService.update(tbMtStock);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("stock:tbMtStock:remove")
	public R remove( String mtCode){
		if(tbMtStockService.remove(mtCode)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("stock:tbMtStock:batchRemove")
	public R remove(@RequestParam("ids[]") String[] mtCodes){
		tbMtStockService.batchRemove(mtCodes);
		return R.ok();
	}
	
}
