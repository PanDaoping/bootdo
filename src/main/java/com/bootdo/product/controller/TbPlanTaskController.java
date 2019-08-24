package com.bootdo.product.controller;

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

import com.bootdo.product.domain.TbPlanTaskDO;
import com.bootdo.product.service.TbPlanTaskService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 计划任务表
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2019-06-27 11:29:22
 */
 
@Controller
@RequestMapping("/product/tbPlanTask")
public class TbPlanTaskController {
	@Autowired
	private TbPlanTaskService tbPlanTaskService;
	
	@GetMapping()
	@RequiresPermissions("product:tbPlanTask:tbPlanTask")
	String TbPlanTask(){
	    return "product/tbPlanTask/tbPlanTask";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("product:tbPlanTask:tbPlanTask")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<TbPlanTaskDO> tbPlanTaskList = tbPlanTaskService.list(query);
		int total = tbPlanTaskService.count(query);
		PageUtils pageUtils = new PageUtils(tbPlanTaskList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("product:tbPlanTask:add")
	String add(){
	    return "product/tbPlanTask/add";
	}

	@GetMapping("/edit/{planGuid}")
	@RequiresPermissions("product:tbPlanTask:edit")
	String edit(@PathVariable("planGuid") String planGuid,Model model){
		TbPlanTaskDO tbPlanTask = tbPlanTaskService.get(planGuid);
		model.addAttribute("tbPlanTask", tbPlanTask);
	    return "product/tbPlanTask/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("product:tbPlanTask:add")
	public R save( TbPlanTaskDO tbPlanTask,HttpServletRequest request){
		HttpSession session = request.getSession();
		String userId = session.getAttribute("USER_ID")==null?"":session.getAttribute("USER_ID").toString();
		tbPlanTask.setPlanGuid(ObjectUtils.toString(UUID.randomUUID().toString().replaceAll("-", "")));
		tbPlanTask.setUserId(userId);
		tbPlanTask.setStatus(0);
		tbPlanTask.setIsDelete(0);
		if(tbPlanTaskService.save(tbPlanTask)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("product:tbPlanTask:edit")
	public R update( TbPlanTaskDO tbPlanTask){
		tbPlanTaskService.update(tbPlanTask);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("product:tbPlanTask:remove")
	public R remove( String planGuid){
		if(tbPlanTaskService.remove(planGuid)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("product:tbPlanTask:batchRemove")
	public R remove(@RequestParam("ids[]") String[] planGuids){
		tbPlanTaskService.batchRemove(planGuids);
		return R.ok();
	}
	
}
