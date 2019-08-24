package com.bootdo.sales.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bootdo.sales.domain.TbSellContractListDO;
import com.bootdo.sales.service.TbSellContractListService;
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

import com.bootdo.sales.domain.TbSellContractDO;
import com.bootdo.sales.service.TbSellContractService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;

import javax.servlet.http.HttpServletRequest;

/**
 * 销售合同
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2019-04-12 14:24:57
 */
 
@Controller
@RequestMapping("/sales/tbSellContract")
public class TbSellContractController {
	@Autowired
	private TbSellContractService tbSellContractService;
	@Autowired
	private TbSellContractListService tbSellContractListService;

	@GetMapping()
	@RequiresPermissions("sales:tbSellContract:tbSellContract")
	String TbSellContract(){
	    return "sales/tbSellContract/tbSellContract";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("sales:tbSellContract:tbSellContract")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<TbSellContractDO> tbSellContractList = tbSellContractService.list(query);
		int total = tbSellContractService.count(query);
		PageUtils pageUtils = new PageUtils(tbSellContractList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("sales:tbSellContract:add")
	String add(Model model){
		String clientCode="00000001";
		String code=tbSellContractService.findClietCode();
		if(code!=null&&!code.equals("")){
			code=code.substring(code.lastIndexOf("0")+1);
			clientCode=String.format("%0" + 8 + "d", Integer.parseInt(code) + 1);
		}
		model.addAttribute("clientCode", clientCode);
		return "sales/tbSellContract/add";
	}

	@GetMapping("/edit/{contractGuid}")
	@RequiresPermissions("sales:tbSellContract:edit")
	String edit(@PathVariable("contractGuid") String contractGuid,Model model){
		Map map=new HashMap();
		map.put("contractGuid",contractGuid);
		TbSellContractDO tbSellContract = tbSellContractService.get(contractGuid);
		List<TbSellContractListDO> tbSellContractListList = tbSellContractListService.list(map);
		model.addAttribute("tbSellContract", tbSellContract);
		model.addAttribute("tbSellContractListList", tbSellContractListList);
	    return "sales/tbSellContract/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("sales:tbSellContract:add")
	public R save(@RequestParam Map map, HttpServletRequest request){
		if(tbSellContractService.save(map)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("sales:tbSellContract:edit")
	public R update( @RequestParam Map map, HttpServletRequest request){
		tbSellContractService.update(map);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("sales:tbSellContract:remove")
	public R remove( String contractGuid){
		if(tbSellContractService.remove(contractGuid)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("sales:tbSellContract:batchRemove")
	public R remove(@RequestParam("ids[]") String[] contractGuids){
		tbSellContractService.batchRemove(contractGuids);
		return R.ok();
	}
	
}
