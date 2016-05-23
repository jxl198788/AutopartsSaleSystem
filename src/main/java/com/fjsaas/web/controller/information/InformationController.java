package com.fjsaas.web.controller.information;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSONObject;
import com.fjsaas.web.bean.ActiveUser;
import com.fjsaas.web.bean.Information;
import com.fjsaas.web.bean.UserRole;
import com.fjsaas.web.service.InformationService;
import com.fjsaas.web.service.UserRoleService;
import com.fjsaas.web.service.UserService;
import com.fjsaas.web.session.SessionProvider;


@Controller
@RequestMapping("/information/")
public class InformationController {
	@Autowired
	private InformationService service;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserRoleService userRoleService;
	
	@Autowired 
	private SessionProvider sessionProvider;
	
	@RequestMapping(value="loop.do")
	public String loopList(ModelMap model,HttpServletRequest req,HttpServletResponse res){
		  ActiveUser user = (ActiveUser) sessionProvider.getCurrentUser();
          Integer id = user.getId();
          List<UserRole> userRole = userRoleService.getUserRoleByUserId(id);
          if(userRole !=null && userRole.size()>0){
        	    id = 3;//企业管理员的Role_id
        	    List<Information> list = service.querStatusByCheck(id);
        	    model.addAttribute("list", list);
      		  	JSONObject jsonObject = new JSONObject();
      		  	//jsonObject.put("InformationList",list);
      		    jsonObject.toJSON(list);
      		  	model.addAttribute("json",jsonObject.toJSON(list));
      		  return "information/InformationByCheck";
          }else{
        	  List<Information> list =  service.querStatusByUser(id);
    		  model.addAttribute("list", list);
    		  JSONObject jsonObject = new JSONObject();
    		  //jsonObject.put("InformationList",list);
    		  model.addAttribute("json",  jsonObject.toJSONString(list));
    		  return "information/InformationByUser";
          }
	}
    
	
	@RequestMapping(value="updataInformation.do")
	public void updataInformation(Integer id,HttpServletRequest req,HttpServletResponse res) throws IOException{
		ActiveUser user = (ActiveUser) sessionProvider.getCurrentUser();
        Integer userid = user.getId();
        List<UserRole> userRole = userRoleService.getUserRoleByUserId(userid);
        if(userRole !=null && userRole.size()>0){
        	userid = 3;//企业管理员的Role_id
        	List<Integer> idsList = new ArrayList<Integer>();
        	idsList.add(id);
        	service.readInformationByCheck(userid, idsList);
        	res.getWriter().write("1");
        }else{
        	List<Integer> idsList = new ArrayList<Integer>();
        	idsList.add(id);
        	service.readInformationByCheck(userid, idsList);
        	res.getWriter().write("1");
        }
	}
	
	@RequestMapping(value="delInformation.do")
	public void delInformation(Integer id,HttpServletRequest req,HttpServletResponse res) throws IOException{
		ActiveUser user = (ActiveUser) sessionProvider.getCurrentUser();
        Integer userid = user.getId();
        List<UserRole> userRole = userRoleService.getUserRoleByUserId(userid);
        if(userRole !=null && userRole.size()>0){
        	userid = 3;//企业管理员的Role_id
        	List<Integer> idsList = new ArrayList<Integer>();
        	idsList.add(id);
        	service.delInformationByCheck(userid, idsList);
        	res.getWriter().write("1");
        }else{
        	List<Integer> idsList = new ArrayList<Integer>();
        	idsList.add(id);
        	service.delInformationByUser(userid, idsList);
        	res.getWriter().write("1");
        }
	}
	

	@RequestMapping(value="allOperation.do")
	public void allOperation(Integer id,HttpServletRequest req,HttpServletResponse res) throws IOException{
		ActiveUser user = (ActiveUser) sessionProvider.getCurrentUser();
        Integer userid = user.getId();
        List<UserRole> userRole = userRoleService.getUserRoleByUserId(userid);
        if(userRole !=null && userRole.size()>0){
        	userid = 3;//企业管理员的Role_id
        	if(id.equals(1)){
        		service.allreadInformationByCheck(userid);
        		res.getWriter().write("1");
        	}
        	if(id.equals(2)){
        		service.alldelInformationByCheck(userid);
        		res.getWriter().write("1");
        	}
        	
        }else{
        	if(id.equals(1)){
        		service.allreadInformationByCheck(userid);
        		res.getWriter().write("1");
        	}
        	if(id.equals(2)){
        		service.alldelInformationByCheck(userid);
        		res.getWriter().write("1");
        	}
        }
	}
	   
}
