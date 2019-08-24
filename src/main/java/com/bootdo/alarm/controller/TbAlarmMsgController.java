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

import com.bootdo.alarm.domain.TbAlarmMsgDO;
import com.bootdo.alarm.service.TbAlarmMsgService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;

/**
 * 告警消息源表（数据量大的情况下可按分厂机构分区或按MSG_GUID做hash分区）
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2019-06-21 15:04:45
 */
 
@Controller
@RequestMapping("/alarm/tbAlarmMsg")
public class TbAlarmMsgController {
	@Autowired
	private TbAlarmMsgService tbAlarmMsgService;
	
	@GetMapping()
	@RequiresPermissions("alarm:tbAlarmMsg:tbAlarmMsg")
	String TbAlarmMsg(){
	    return "alarm/tbAlarmMsg/tbAlarmMsg";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("alarm:tbAlarmMsg:tbAlarmMsg")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<TbAlarmMsgDO> tbAlarmMsgList = tbAlarmMsgService.list(query);
		int total = tbAlarmMsgService.count(query);
		PageUtils pageUtils = new PageUtils(tbAlarmMsgList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("alarm:tbAlarmMsg:add")
	String add(){
	    return "alarm/tbAlarmMsg/add";
	}

	@GetMapping("/edit/{msgGuid}")
	@RequiresPermissions("alarm:tbAlarmMsg:edit")
	String edit(@PathVariable("msgGuid") String msgGuid,Model model){
		TbAlarmMsgDO tbAlarmMsg = tbAlarmMsgService.get(msgGuid);
		model.addAttribute("tbAlarmMsg", tbAlarmMsg);
	    return "alarm/tbAlarmMsg/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("alarm:tbAlarmMsg:add")
	public R save( TbAlarmMsgDO tbAlarmMsg){
		if(tbAlarmMsgService.save(tbAlarmMsg)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("alarm:tbAlarmMsg:edit")
	public R update( TbAlarmMsgDO tbAlarmMsg){
		tbAlarmMsgService.update(tbAlarmMsg);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("alarm:tbAlarmMsg:remove")
	public R remove( String msgGuid){
		if(tbAlarmMsgService.remove(msgGuid)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("alarm:tbAlarmMsg:batchRemove")
	public R remove(@RequestParam("ids[]") String[] msgGuids){
		tbAlarmMsgService.batchRemove(msgGuids);
		return R.ok();
	}
	
}
