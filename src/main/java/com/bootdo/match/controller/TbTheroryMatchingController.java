package com.bootdo.match.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bootdo.match.domain.TbTheroryMatchingListDO;
import com.bootdo.match.service.TbTheroryMatchingListService;
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

import com.bootdo.match.domain.TbTheroryMatchingDO;
import com.bootdo.match.service.TbTheroryMatchingService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2019-07-04 14:45:47
 */
 
@Controller
@RequestMapping("/match/tbTheroryMatching")
public class TbTheroryMatchingController {
	@Autowired
	private TbTheroryMatchingService tbTheroryMatchingService;
	@Autowired
	private TbTheroryMatchingListService tbTheroryMatchingListService;

	@GetMapping()
	@RequiresPermissions("match:tbTheroryMatching:tbTheroryMatching")
	String TbTheroryMatching(){
	    return "match/tbTheroryMatching/tbTheroryMatching";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("match:tbTheroryMatching:tbTheroryMatching")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<TbTheroryMatchingDO> tbTheroryMatchingList = tbTheroryMatchingService.list(query);
		int total = tbTheroryMatchingService.count(query);
		PageUtils pageUtils = new PageUtils(tbTheroryMatchingList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("match:tbTheroryMatching:add")
	String add(){
	    return "match/tbTheroryMatching/add";
	}

	@GetMapping("/edit/{theoryGuid}")
	@RequiresPermissions("match:tbTheroryMatching:edit")
	String edit(@PathVariable("theoryGuid") String theoryGuid,Model model){
		Map map=new HashMap();
		map.put("theoryGuid",theoryGuid);
		TbTheroryMatchingDO tbTheroryMatching = tbTheroryMatchingService.get(theoryGuid);
		List<TbTheroryMatchingListDO> tbTheroryMatchingList = tbTheroryMatchingListService.list(map);
		model.addAttribute("tbTheroryMatchingList", tbTheroryMatchingList);
		model.addAttribute("tbTheroryMatching", tbTheroryMatching);
	    return "match/tbTheroryMatching/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("match:tbTheroryMatching:add")
	public R save(@RequestParam Map map, HttpServletRequest request){
		HttpSession session = request.getSession();
		String userId = session.getAttribute("USER_ID")==null?"":session.getAttribute("USER_ID").toString();
        map.put("userId",userId);
		if(tbTheroryMatchingService.save(map)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("match:tbTheroryMatching:edit")
	public R update( @RequestParam Map map, HttpServletRequest request){
		tbTheroryMatchingService.update(map);
		return R.ok();
	}
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("match:tbTheroryMatching:remove")
	public R remove( String theoryGuid){
		if(tbTheroryMatchingService.remove(theoryGuid)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("match:tbTheroryMatching:batchRemove")
	public R remove(@RequestParam("ids[]") String[] theoryGuids){
		tbTheroryMatchingService.batchRemove(theoryGuids);
		return R.ok();
	}
	
}
