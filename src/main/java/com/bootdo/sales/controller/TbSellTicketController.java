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

import com.bootdo.sales.domain.TbSellTicketDO;
import com.bootdo.sales.service.TbSellTicketService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;

/**
 * 
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2019-04-12 14:24:57
 */
 
@Controller
@RequestMapping("/sales/tbSellTicket")
public class TbSellTicketController {
	@Autowired
	private TbSellTicketService tbSellTicketService;
	
	@GetMapping()
	@RequiresPermissions("sales:tbSellTicket:tbSellTicket")
	String TbSellTicket(){
	    return "sales/tbSellTicket/tbSellTicket";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("sales:tbSellTicket:tbSellTicket")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<TbSellTicketDO> tbSellTicketList = tbSellTicketService.list(query);
		int total = tbSellTicketService.count(query);
		PageUtils pageUtils = new PageUtils(tbSellTicketList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("sales:tbSellTicket:add")
	String add(){
	    return "sales/tbSellTicket/add";
	}

	@GetMapping("/edit/{ticketGuid}")
	@RequiresPermissions("sales:tbSellTicket:edit")
	String edit(@PathVariable("ticketGuid") String ticketGuid,Model model){
		TbSellTicketDO tbSellTicket = tbSellTicketService.get(ticketGuid);
		model.addAttribute("tbSellTicket", tbSellTicket);
	    return "sales/tbSellTicket/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("sales:tbSellTicket:add")
	public R save( TbSellTicketDO tbSellTicket){
		if(tbSellTicketService.save(tbSellTicket)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("sales:tbSellTicket:edit")
	public R update( TbSellTicketDO tbSellTicket){
		tbSellTicketService.update(tbSellTicket);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("sales:tbSellTicket:remove")
	public R remove( String ticketGuid){
		if(tbSellTicketService.remove(ticketGuid)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("sales:tbSellTicket:batchRemove")
	public R remove(@RequestParam("ids[]") String[] ticketGuids){
		tbSellTicketService.batchRemove(ticketGuids);
		return R.ok();
	}
	
}
