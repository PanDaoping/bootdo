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

import com.bootdo.stock.domain.TbMtInDetailDO;
import com.bootdo.stock.service.TbMtInDetailService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;

/**
 * 采购订单详细
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2019-04-12 14:20:07
 */
 
@Controller
@RequestMapping("/stock/tbMtInDetail")
public class TbMtInDetailController {
	@Autowired
	private TbMtInDetailService tbMtInDetailService;
	
	@GetMapping()
	@RequiresPermissions("stock:tbMtInDetail:tbMtInDetail")
	String TbMtInDetail(){
	    return "stock/tbMtInDetail/tbMtInDetail";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("stock:tbMtInDetail:tbMtInDetail")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<TbMtInDetailDO> tbMtInDetailList = tbMtInDetailService.list(query);
		int total = tbMtInDetailService.count(query);
		PageUtils pageUtils = new PageUtils(tbMtInDetailList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("stock:tbMtInDetail:add")
	String add(){
	    return "stock/tbMtInDetail/add";
	}

	@GetMapping("/edit/{orderDetailGuid}")
	@RequiresPermissions("stock:tbMtInDetail:edit")
	String edit(@PathVariable("orderDetailGuid") Integer orderDetailGuid,Model model){
		TbMtInDetailDO tbMtInDetail = tbMtInDetailService.get(orderDetailGuid);
		model.addAttribute("tbMtInDetail", tbMtInDetail);
	    return "stock/tbMtInDetail/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("stock:tbMtInDetail:add")
	public R save( TbMtInDetailDO tbMtInDetail){
		if(tbMtInDetailService.save(tbMtInDetail)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("stock:tbMtInDetail:edit")
	public R update( TbMtInDetailDO tbMtInDetail){
		tbMtInDetailService.update(tbMtInDetail);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("stock:tbMtInDetail:remove")
	public R remove( String orderDetailGuid){
		if(tbMtInDetailService.remove(orderDetailGuid)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("stock:tbMtInDetail:batchRemove")
	public R remove(@RequestParam("ids[]") String[] orderDetailGuids){
		tbMtInDetailService.batchRemove(orderDetailGuids);
		return R.ok();
	}
	
}
