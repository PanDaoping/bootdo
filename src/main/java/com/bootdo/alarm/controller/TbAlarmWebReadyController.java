package com.bootdo.alarm.controller;

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

import com.bootdo.alarm.domain.TbAlarmWebReadyDO;
import com.bootdo.alarm.service.TbAlarmWebReadyService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;

/**
 * 系统WEB站内消息待发送表（WEB站内消息，只有阅读或者是忽略后才写入站内消息历史表中）
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2019-06-21 15:04:45
 */
 
@Controller
@RequestMapping("/alarm/tbAlarmWebReady")
public class TbAlarmWebReadyController {
	@Autowired
	private TbAlarmWebReadyService tbAlarmWebReadyService;
	
	@GetMapping()
	@RequiresPermissions("alarm:tbAlarmWebReady:tbAlarmWebReady")
	String TbAlarmWebReady(){
	    return "alarm/tbAlarmWebReady/tbAlarmWebReady";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("alarm:tbAlarmWebReady:tbAlarmWebReady")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<TbAlarmWebReadyDO> tbAlarmWebReadyList = tbAlarmWebReadyService.list(query);
		int total = tbAlarmWebReadyService.count(query);
		PageUtils pageUtils = new PageUtils(tbAlarmWebReadyList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("alarm:tbAlarmWebReady:add")
	String add(){
	    return "alarm/tbAlarmWebReady/add";
	}

	@GetMapping("/edit/{sendGuid}")
	@RequiresPermissions("alarm:tbAlarmWebReady:edit")
	String edit(@PathVariable("sendGuid") String sendGuid,Model model){
		TbAlarmWebReadyDO tbAlarmWebReady = tbAlarmWebReadyService.get(sendGuid);
		model.addAttribute("tbAlarmWebReady", tbAlarmWebReady);
	    return "alarm/tbAlarmWebReady/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("alarm:tbAlarmWebReady:add")
	public R save( TbAlarmWebReadyDO tbAlarmWebReady){
		if(tbAlarmWebReadyService.save(tbAlarmWebReady)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("alarm:tbAlarmWebReady:edit")
	public R update( TbAlarmWebReadyDO tbAlarmWebReady){
		tbAlarmWebReadyService.update(tbAlarmWebReady);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("alarm:tbAlarmWebReady:remove")
	public R remove( String sendGuid){
		if(tbAlarmWebReadyService.remove(sendGuid)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("alarm:tbAlarmWebReady:batchRemove")
	public R remove(@RequestParam("ids[]") String[] sendGuids){
		tbAlarmWebReadyService.batchRemove(sendGuids);
		return R.ok();
	}
	
}
