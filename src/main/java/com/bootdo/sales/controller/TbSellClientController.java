package com.bootdo.sales.controller;

import java.util.Date;
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

import com.bootdo.sales.domain.TbSellClientDO;
import com.bootdo.sales.service.TbSellClientService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 客户信息表
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2019-04-12 14:24:57
 */
 
@Controller
@RequestMapping("/sales/tbSellClient")
public class TbSellClientController {
	@Autowired
	private TbSellClientService tbSellClientService;
	
	@GetMapping()
	@RequiresPermissions("sales:tbSellClient:tbSellClient")
	String TbSellClient(){
	    return "sales/tbSellClient/tbSellClient";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("sales:tbSellClient:tbSellClient")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<TbSellClientDO> tbSellClientList = tbSellClientService.list(query);
		int total = tbSellClientService.count(query);
		PageUtils pageUtils = new PageUtils(tbSellClientList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("sales:tbSellClient:add")
	String add(Model model){
		String clientCode="00000001";
		String code=tbSellClientService.findClietCode();
		if(code!=null){
			code=code.substring(code.lastIndexOf("0")+1);
			clientCode=String.format("%0" + 8 + "d", Integer.parseInt(code) + 1);
		}
		model.addAttribute("clientCode", clientCode);
		return "sales/tbSellClient/add";
	}

	@GetMapping("/edit/{clientGuid}")
	@RequiresPermissions("sales:tbSellClient:edit")
	String edit(@PathVariable("clientGuid") String clientGuid,Model model){
		TbSellClientDO tbSellClient = tbSellClientService.get(clientGuid);
		model.addAttribute("tbSellClient", tbSellClient);
	    return "sales/tbSellClient/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("sales:tbSellClient:add")
	public R save( TbSellClientDO tbSellClient,HttpServletRequest request){
		HttpSession session = request.getSession();
		String userId = session.getAttribute("USER_ID")==null?"":session.getAttribute("USER_ID").toString();
		tbSellClient.setClientGuid(ObjectUtils.toString(UUID.randomUUID().toString().replaceAll("-", "")));
		tbSellClient.setIsDelete(0);
		tbSellClient.setUserId(userId);
		tbSellClient.setOperTime(new Date());
		if(tbSellClientService.save(tbSellClient)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("sales:tbSellClient:edit")
	public R update( TbSellClientDO tbSellClient){
		tbSellClientService.update(tbSellClient);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("sales:tbSellClient:remove")
	public R remove( String clientGuid){
		if(tbSellClientService.remove(clientGuid)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("sales:tbSellClient:batchRemove")
	public R remove(@RequestParam("ids[]") String[] clientGuids){
		tbSellClientService.batchRemove(clientGuids);
		return R.ok();
	}

	public static void main(String[] args) {
		String code="00000999";
		code=code.substring(code.lastIndexOf("0")+1);
		String.format("%0" + 8 + "d", Integer.parseInt(code) + 1);
		System.out.println(String.format("%0" + 8 + "d", Integer.parseInt(code) + 1));
	}
}
