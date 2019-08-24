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

import com.bootdo.stock.domain.TbMtOutDO;
import com.bootdo.stock.service.TbMtOutService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;

/**
 * 资产（材料）领用登记表
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2019-04-12 14:20:07
 */
 
@Controller
@RequestMapping("/stock/tbMtOut")
public class TbMtOutController {
	@Autowired
	private TbMtOutService tbMtOutService;
	
	@GetMapping()
	@RequiresPermissions("stock:tbMtOut:tbMtOut")
	String TbMtOut(){
	    return "stock/tbMtOut/tbMtOut";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("stock:tbMtOut:tbMtOut")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<TbMtOutDO> tbMtOutList = tbMtOutService.list(query);
		int total = tbMtOutService.count(query);
		PageUtils pageUtils = new PageUtils(tbMtOutList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("stock:tbMtOut:add")
	String add(){
	    return "stock/tbMtOut/add";
	}

	@GetMapping("/edit/{outGuid}")
	@RequiresPermissions("stock:tbMtOut:edit")
	String edit(@PathVariable("outGuid") String outGuid,Model model){
		TbMtOutDO tbMtOut = tbMtOutService.get(outGuid);
		model.addAttribute("tbMtOut", tbMtOut);
	    return "stock/tbMtOut/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("stock:tbMtOut:add")
	public R save( TbMtOutDO tbMtOut){
		if(tbMtOutService.save(tbMtOut)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("stock:tbMtOut:edit")
	public R update( TbMtOutDO tbMtOut){
		tbMtOutService.update(tbMtOut);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("stock:tbMtOut:remove")
	public R remove( String outGuid){
		if(tbMtOutService.remove(outGuid)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("stock:tbMtOut:batchRemove")
	public R remove(@RequestParam("ids[]") String[] outGuids){
		tbMtOutService.batchRemove(outGuids);
		return R.ok();
	}
	
}
