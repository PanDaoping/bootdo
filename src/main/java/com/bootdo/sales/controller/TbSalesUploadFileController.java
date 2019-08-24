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

import com.bootdo.sales.domain.TbSalesUploadFileDO;
import com.bootdo.sales.service.TbSalesUploadFileService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;

/**
 * 
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2019-06-17 15:28:00
 */
 
@Controller
@RequestMapping("/sales/tbSalesUploadFile")
public class TbSalesUploadFileController {
	@Autowired
	private TbSalesUploadFileService tbSalesUploadFileService;
	
	@GetMapping()
//	@RequiresPermissions("sales:tbSalesUploadFile:tbSalesUploadFile")
	String TbSalesUploadFile(){
	    return "sales/tbSalesUploadFile/tbSalesUploadFile";
	}
	
	@ResponseBody
	@GetMapping("/list")
//	@RequiresPermissions("sales:tbSalesUploadFile:tbSalesUploadFile")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<TbSalesUploadFileDO> tbSalesUploadFileList = tbSalesUploadFileService.list(query);
		int total = tbSalesUploadFileService.count(query);
		PageUtils pageUtils = new PageUtils(tbSalesUploadFileList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("sales:tbSalesUploadFile:add")
	String add(){
	    return "sales/tbSalesUploadFile/add";
	}

	@GetMapping("/edit/{uploadGuid}")
	@RequiresPermissions("sales:tbSalesUploadFile:edit")
	String edit(@PathVariable("uploadGuid") String uploadGuid,Model model){
		TbSalesUploadFileDO tbSalesUploadFile = tbSalesUploadFileService.get(uploadGuid);
		model.addAttribute("tbSalesUploadFile", tbSalesUploadFile);
	    return "sales/tbSalesUploadFile/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("sales:tbSalesUploadFile:add")
	public R save( TbSalesUploadFileDO tbSalesUploadFile){
		if(tbSalesUploadFileService.save(tbSalesUploadFile)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("sales:tbSalesUploadFile:edit")
	public R update( TbSalesUploadFileDO tbSalesUploadFile){
		tbSalesUploadFileService.update(tbSalesUploadFile);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("sales:tbSalesUploadFile:remove")
	public R remove( String uploadGuid){
		if(tbSalesUploadFileService.remove(uploadGuid)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("sales:tbSalesUploadFile:batchRemove")
	public R remove(@RequestParam("ids[]") String[] uploadGuids){
		tbSalesUploadFileService.batchRemove(uploadGuids);
		return R.ok();
	}
	
}
