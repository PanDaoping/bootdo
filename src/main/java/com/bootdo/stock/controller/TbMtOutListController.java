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

import com.bootdo.stock.domain.TbMtOutListDO;
import com.bootdo.stock.service.TbMtOutListService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;

/**
 * 
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2019-04-12 14:20:07
 */
 
@Controller
@RequestMapping("/stock/tbMtOutList")
public class TbMtOutListController {
	@Autowired
	private TbMtOutListService tbMtOutListService;
	
	@GetMapping()
	@RequiresPermissions("stock:tbMtOutList:tbMtOutList")
	String TbMtOutList(){
	    return "stock/tbMtOutList/tbMtOutList";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("stock:tbMtOutList:tbMtOutList")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<TbMtOutListDO> tbMtOutListList = tbMtOutListService.list(query);
		int total = tbMtOutListService.count(query);
		PageUtils pageUtils = new PageUtils(tbMtOutListList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("stock:tbMtOutList:add")
	String add(){
	    return "stock/tbMtOutList/add";
	}

	@GetMapping("/edit/{listGuid}")
	@RequiresPermissions("stock:tbMtOutList:edit")
	String edit(@PathVariable("listGuid") String listGuid,Model model){
		TbMtOutListDO tbMtOutList = tbMtOutListService.get(listGuid);
		model.addAttribute("tbMtOutList", tbMtOutList);
	    return "stock/tbMtOutList/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("stock:tbMtOutList:add")
	public R save( TbMtOutListDO tbMtOutList){
		if(tbMtOutListService.save(tbMtOutList)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("stock:tbMtOutList:edit")
	public R update( TbMtOutListDO tbMtOutList){
		tbMtOutListService.update(tbMtOutList);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("stock:tbMtOutList:remove")
	public R remove( String listGuid){
		if(tbMtOutListService.remove(listGuid)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("stock:tbMtOutList:batchRemove")
	public R remove(@RequestParam("ids[]") String[] listGuids){
		tbMtOutListService.batchRemove(listGuids);
		return R.ok();
	}
	
}
