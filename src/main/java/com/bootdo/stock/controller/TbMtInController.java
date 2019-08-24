package com.bootdo.stock.controller;

import java.util.HashMap;
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

import com.bootdo.stock.domain.TbMtInDO;
import com.bootdo.stock.service.TbMtInService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 订单表
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2019-04-12 14:20:06
 */
 
@Controller
@RequestMapping("/stock/tbMtIn")
public class TbMtInController {
	@Autowired
	private TbMtInService tbMtInService;
	
	@GetMapping()
	@RequiresPermissions("stock:tbMtIn:tbMtIn")
	String TbMtIn(){
	    return "stock/tbMtIn/tbMtIn";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("stock:tbMtIn:tbMtIn")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<Map> tbMtInList = tbMtInService.list(query);
		int total = tbMtInService.count(query);
		PageUtils pageUtils = new PageUtils(tbMtInList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("stock:tbMtIn:add")
	String add(Model model){
		Map map=new HashMap();
		map.put("type",4);
		String orderNo=tbMtInService.getNewCode(map);
		model.addAttribute("orderNo", orderNo);
		return "stock/tbMtIn/add";
	}

	@GetMapping("/edit/{orderGuid}")
	@RequiresPermissions("stock:tbMtIn:edit")
	String edit(@PathVariable("orderGuid") String orderGuid,Model model){
		Map map = tbMtInService.get(orderGuid);
		model.addAttribute("tbMtIn", map);
	    return "stock/tbMtIn/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("stock:tbMtIn:add")
	public R save(@RequestParam Map map, HttpServletRequest request){
		HttpSession session = request.getSession();
		String userId = session.getAttribute("USER_ID")==null?"":session.getAttribute("USER_ID").toString();
		map.put("userId",userId);
		if(tbMtInService.save(map)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("stock:tbMtIn:edit")
	public R update(  @RequestParam Map map){
		tbMtInService.update(map);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("stock:tbMtIn:remove")
	public R remove( String orderGuid){
		if(tbMtInService.remove(orderGuid)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("stock:tbMtIn:batchRemove")
	public R remove(@RequestParam("ids[]") String[] orderGuids){
		tbMtInService.batchRemove(orderGuids);
		return R.ok();
	}
	
}
