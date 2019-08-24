package com.bootdo.common.controller;

import com.bootdo.common.config.BootdoConfig;
import com.bootdo.common.domain.FileDO;
import com.bootdo.common.service.FileService;
import com.bootdo.common.utils.*;
import javax.servlet.http.HttpServletRequest;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 文件上传
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2017-09-19 16:02:20
 */
@Controller
@RequestMapping("/common/sysFile")
public class FileController extends BaseController {

	@Autowired
	private FileService sysFileService;

	@Autowired
	private BootdoConfig bootdoConfig;

	@GetMapping()
	@RequiresPermissions("common:sysFile:sysFile")
	String sysFile(Model model) {
		Map<String, Object> params = new HashMap<>(16);
		return "common/file/file";
	}

	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("common:sysFile:sysFile")
	public PageUtils list(@RequestParam Map<String, Object> params) {
		// 查询列表数据
		Query query = new Query(params);
		List<FileDO> sysFileList = sysFileService.list(query);
		int total = sysFileService.count(query);
		PageUtils pageUtils = new PageUtils(sysFileList, total);
		return pageUtils;
	}

	@GetMapping("/add")
	// @RequiresPermissions("common:bComments")
	String add() {
		return "common/sysFile/add";
	}

	@GetMapping("/edit")
	// @RequiresPermissions("common:bComments")
	String edit(Long id, Model model) {
		FileDO sysFile = sysFileService.get(id);
		model.addAttribute("sysFile", sysFile);
		return "common/sysFile/edit";
	}

	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("common:info")
	public R info(@PathVariable("id") Long id) {
		FileDO sysFile = sysFileService.get(id);
		return R.ok().put("sysFile", sysFile);
	}

	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("common:save")
	public R save(FileDO sysFile) {
		if (sysFileService.save(sysFile) > 0) {
			return R.ok();
		}
		return R.error();
	}

	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("common:update")
	public R update(@RequestBody FileDO sysFile) {
		sysFileService.update(sysFile);

		return R.ok();
	}

	/**
	 * 删除
	 */
	@PostMapping("/remove")
	@ResponseBody
	// @RequiresPermissions("common:remove")
	public R remove(Long id, HttpServletRequest request) {
		if ("test".equals(getUsername())) {
			return R.error(1, "演示系统不允许修改,完整体验请部署程序");
		}
		String fileName = bootdoConfig.getUploadPath() + sysFileService.get(id).getUrl().replace("/files/", "");
		if (sysFileService.remove(id) > 0) {
			boolean b = FileUtil.deleteFile(fileName);
			if (!b) {
				return R.error("数据库记录删除成功，文件删除失败");
			}
			return R.ok();
		} else {
			return R.error();
		}
	}

	/**
	 * 删除
	 */
	@PostMapping("/batchRemove")
	@ResponseBody
	@RequiresPermissions("common:remove")
	public R remove(@RequestParam("ids[]") Long[] ids) {
		if ("test".equals(getUsername())) {
			return R.error(1, "演示系统不允许修改,完整体验请部署程序");
		}
		sysFileService.batchRemove(ids);
		return R.ok();
	}

	@ResponseBody
	@PostMapping("/upload")
	R upload(@RequestParam("file") MultipartFile file, HttpServletRequest request) {
		if ("test".equals(getUsername())) {
			return R.error(1, "演示系统不允许修改,完整体验请部署程序");
		}
		String fileName = file.getOriginalFilename();
		fileName = FileUtil.renameToUUID(fileName);
		FileDO sysFile = new FileDO(FileType.fileType(fileName), "/files/" + fileName, new Date());
		try {
			FileUtil.uploadFile(file.getBytes(), bootdoConfig.getUploadPath(), fileName);
		} catch (Exception e) {
			return R.error();
		}

		if (sysFileService.save(sysFile) > 0) {
			return R.ok().put("fileName",sysFile.getUrl());
		}
		return R.error();
	}

	@GetMapping("/multiple")
	String multiple(Model model,HttpServletRequest request) {
		model.addAttribute("url",request.getParameter("url"));
		model.addAttribute("ext",request.getParameter("ext"));
		model.addAttribute("sizelimit",request.getParameter("sizelimit"));
		model.addAttribute("btn",request.getParameter("btn"));
		model.addAttribute("callback",request.getParameter("callback"));
		return "common/file/multiple";
	}

	@GetMapping("/testMultiple")
	String testMultiple(Model model,HttpServletRequest request) {
		return "common/file/testMultiple";
	}

	@ResponseBody
	@PostMapping("/mutilpFileUpload")
	Map mutilpFileUpload(@RequestParam("file") MultipartFile file,Model model,HttpServletRequest request) {
		Map map = new HashMap();
		try{
			System.out.println(request.getParameter("username"));//  获取 ionic 传递参数 params:{username : "张三",age : "20",height : "190"}
//			System.out.println(request.getParameter("params"));
			String fileName1 = file.getOriginalFilename();
			String fileName = FileUtil.renameToUUID(fileName1);
			String webUrl = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort();
			FileDO sysFile = new FileDO(FileType.fileType(fileName), "/files/" + fileName, new Date());
			try {
				File targetFile = new File(bootdoConfig.getUploadPath());
				if (!targetFile.exists()) {
					targetFile.mkdirs();
				}
				FileOutputStream out = new FileOutputStream(bootdoConfig.getUploadPath() + fileName);
				out.write(file.getBytes());
				out.flush();
				out.close();

//				FileUtil.uploadFile(file.getBytes(), bootdoConfig.getUploadPath(), fileName);
			} catch (Exception e) {
				return R.error();
			}

			String realPath = bootdoConfig.getUploadPath()+fileName;
			String extension = fileName.substring(fileName.lastIndexOf(".")+1);
			String uuFileName = realPath.substring(realPath.lastIndexOf("/")+1,realPath.lastIndexOf("."));
			map.put("fileName",fileName1);
			map.put("extension",extension);
			map.put("filePath",sysFile.getUrl());
			if(extension.equals("doc")||extension.equals("DOC")){
				//word转换成html
				map.put("htmlfilePath", "/files/"+uuFileName+".html");
				map.put("isImg", "false");
				PoiWordToHtml.PoiWord03ToHtml(realPath);
			}else if(extension.equals("DOCX")||extension.equals("docx")){
				map.put("htmlfilePath", "/files/"+uuFileName+".html");
				map.put("isImg", "false");
				PoiWordToHtml.PoiWord07ToHtml(realPath);

			}else if(extension.equals("PDF")||extension.equals("pdf")||extension.equals("zip")||extension.equals("rar")){
				map.put("htmlfilePath", "/files/"+fileName);
				map.put("isImg", "false");
			}else if(extension.equals("mp4")||extension.equals("MP4")) {
				map.put("filePath", "/files/h-"+uuFileName+".mp4");
				map.put("isImg", "true");//视频采用图片样式
				String outPath = bootdoConfig.getUploadPath()+"h-"+fileName;
				FFMpegUtil.convetor(realPath, outPath);
				FileUtil.deleteFile(realPath);
			}else{
				map.put("isImg", "true");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return map;
	}

	@ResponseBody
	@PostMapping("/deleteServerFile")
	R deleteServerFile(Model model,HttpServletRequest request) {
		try{
			String filePath = request.getParameter("url");
			String fileName = bootdoConfig.getUploadPath() + filePath.replace("/files/", "");
			boolean b = FileUtil.deleteFile(fileName);
			return R.ok();
		}catch(Exception e){
			return R.error();
		}

	}

}
