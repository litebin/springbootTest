package com.testfan;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

//import com.testfan.dao.CaseSystemMapper;
import com.testfan.model.CaseSystem;
import com.testfan.service.MyTestService;

@Controller
@RequestMapping(value = "/hello")
public class HelloSpringboot {

	@Autowired
	MyTestService testservice;

//	@Autowired
//	CaseSystemMapper caseSystemMapper;

	private static Logger log = LoggerFactory.getLogger(HelloSpringboot.class);

	@Autowired
	private ServletContext servletContext;

	// 上传文件存储目录
	private static final String UPLOAD_DIRECTORY = "upload";

	@ResponseBody
	@RequestMapping(value = "/map")
	public Map<String, Object> getALL() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", "zhangsan");
		map.put("age", 100);
		return map;
	}

	@RequestMapping(value = "/mvc", method = RequestMethod.GET)
	public String HelloWorld(Model model) {

		model.addAttribute("message", "Hello Spring MVC!!!"); // 传参数给前端

		// 视图渲染，/WEB-INF/view/HelloWorld.jsp
		return "HelloWorld"; // 页面的名称，根据此字符串会去寻找名为HelloWorld.jsp的页面
	}

	@RequestMapping(value = "/upload", method = RequestMethod.GET)
	public String showUploadPage() {
		return "uploadFile"; // 上传单个文件
	}

	/**
	 * 上传单个文件操作
	 * 
	 * @param file
	 * @return
	 */
	@RequestMapping(value = "/doUpload", method = RequestMethod.POST)
	public String doUploadFile(@RequestParam("file") MultipartFile file) {

		if (!file.isEmpty()) {
			log.debug("Process file: {}", file.getOriginalFilename());
			try {
				String uploadPath = servletContext.getRealPath("./") + File.separator + UPLOAD_DIRECTORY;
				System.out.println("upload " + uploadPath);
				// 这里将上传得到的文件保存至 d:\\temp\\file 目录
				FileUtils.copyInputStreamToFile(file.getInputStream(),
						new File(uploadPath, System.currentTimeMillis() + file.getOriginalFilename()));
			} catch (IOException e) {
				e.printStackTrace();
				log.error(e.toString());
			}
		}

		return "success";
	}

//	@ResponseBody
//	@RequestMapping(value = "/testdb", method = RequestMethod.GET)
//	public List<CaseSystem> testdb() {
//		List<CaseSystem> list = caseSystemMapper.selectByExample(null);
//		return list;
//	}
	
//	@ResponseBody
//	@RequestMapping(value = "/testpage", method = RequestMethod.GET)
//	public Object testpage() {
//		return testservice.list(1, 2);
//	}

}
