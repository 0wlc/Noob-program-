package com.ozc.controller;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import com.ozc.entity.User;
import com.ozc.implem.IUserDao;

@Controller
@Scope("prototype")
public class UserController extends BaseController<User> {
	@Autowired
	private IUserDao userdao;
	
	@RequestMapping("user_list.do")
	public String list() throws Exception{
		Map<String,Object> param = new HashMap<>();
		if (req.getParameter("commit")!=null) {
			param.put("name", obj.getName());
			param.put("username", obj.getUsername());
			param.put("sex", obj.getSex());
			param.put("loginFlag", obj.getLoginFlag());
		}
		//查询总记录数
		getPage().setTotalRows(userdao.list(param).size());
		//把page传到Dao
		param.put("page", getPage());
		setList(userdao.list(param));
		return "user/list";
	}
	
	@RequestMapping("user_add.do")
	public String add(MultipartFile upload) throws Exception{	//“upload”与页面上传File的input标签名对应
		//文件上传
		if(upload!=null){
			//上传文件名
			String upFile = upload.getOriginalFilename();
			String type = upFile.substring(upFile.lastIndexOf("."));
			String fileName = System.currentTimeMillis() + type;
			obj.setFilePath(fileName);
			
			String path = "D:/temp/" + fileName;
			upload.transferTo(new File(path));
		}else{
			obj.setFilePath("");
			int i = userdao.add(obj);
			setMsg(i>0?"添加操作成功":"添加操作失败");
		}
		return "user/list";
	}
	
	@RequestMapping("user_update.do")
	public String update(MultipartFile upload) throws Exception{
		if(commit==false){//请求转发
			obj = userdao.getObjById(obj.getId());
			return "teacher/update";
		}else{
			//文件上传
			if(upload!=null){
				//上传文件名
				String upFile = upload.getOriginalFilename();
				String type = upFile.substring(upFile.lastIndexOf("."));
				String fileName = System.currentTimeMillis() + type;
				obj.setFilePath(fileName);
				
				String path = "D:/temp/" + fileName;
				upload.transferTo(new File(path));
			}
			int i = userdao.update(obj);
			setMsg(i>0?"更新操作成功":"更新操作失败");
			return "user/list";
		}
	}
	
	public String delete() throws Exception{
		int i = userdao.delete(obj.getId());
		setMsg(i>0?"删除操作成功":"删除操作失败");
		return "user/list";
	}

}