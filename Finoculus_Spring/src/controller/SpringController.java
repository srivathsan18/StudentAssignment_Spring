package controller;


import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import database.Database;
import pojo.Addpojo;
import pojo.Deletepojo;
import pojo.Signinpojo;
import pojo.Signuppojo;
import pojo.Viewpojo;
import totalcode.Totalcode;

@Controller  
public class SpringController {
    @RequestMapping("/signinform")  
    public ModelAndView Signinform() {  
        
        return new ModelAndView("signin", "command","Welcome to Sign in page");  
    }  
    @RequestMapping("/signupform")  

    public ModelAndView Signupform() {
    	return new ModelAndView("signup", "message","Welcome to Signup page");    	
    }
    
    @RequestMapping(value="/signup",method = RequestMethod.POST)  
    public ModelAndView Signup(@ModelAttribute("su")Signuppojo su ){
    	Totalcode t=new Totalcode();
    	int i=0;
    	if(su.getPass().equals(su.getRpass())) {
    	 Date dNow = new Date( );
	      SimpleDateFormat ft =new SimpleDateFormat ("yyMMddHHmmss");
	     String sid = ft.format(dNow)+"";
	     su.setSid(sid);
    	i=t.signup(su);
    	}
    	if(i>0) {
    		return new ModelAndView("signin", "message","Successfully Signed Up");
    	}
    	else
    		return new ModelAndView("signup", "message","Signup Unsuccessfull");	
    	
    }
    @RequestMapping(value="/signin",method = {RequestMethod.POST})
    public ModelAndView Signin(HttpServletRequest request,HttpServletResponse response,@ModelAttribute("si")Signinpojo si ){
    	Totalcode t=new Totalcode();
    	String id=t.signin(si);
    	
    	if(!id.equals("")) {
    		HttpSession session=request.getSession();
    		session.setAttribute("ses",id);
    		return new ModelAndView ("preview");
    	}
    	else {
    		return new ModelAndView ("signin","message","sorry enter correct email and password");

    	}

		
    }

    @RequestMapping("/addjsp")
    public ModelAndView Add(HttpServletRequest request,HttpServletResponse response){
    	HttpSession session=request.getSession();
		String id="";
		try{
		id=(String)session.getAttribute("ses");
		if(id.equals("")){
    		return new ModelAndView ("signin","message","login again");

			
		}
		else 
    		return new ModelAndView ("add_assignment","message","add your assignment");

		}
		catch(Exception e){
    		return new ModelAndView ("signin","message","login again");
		}

		

    	}
    @RequestMapping(value="/addassignment",method = RequestMethod.POST)
    public ModelAndView Addassignment(HttpServletRequest request,HttpServletResponse response,@ModelAttribute("su")Addpojo ap ){
    
HttpSession session=request.getSession();
String id="";
		
		id=(String)session.getAttribute("ses");
		ap.setId(id);
    	Totalcode t=new Totalcode();
		int i=t.add(ap);
		if(i>0) {
    		return new ModelAndView ("preview","message","Successfully Added");

			
		}
		else {
    		return new ModelAndView ("preview","message","error occured during adding assignment");

		}
    }
		 @RequestMapping(value="/editassignment",method = RequestMethod.POST)
		    public ModelAndView Editassignment(HttpServletRequest request,HttpServletResponse response,@ModelAttribute("vp")Viewpojo vp ){
			 ModelAndView m=null;
			 HttpSession session=request.getSession();
				String id="";
				
				id=(String)session.getAttribute("ses");
				
			
				
				String ai=request.getParameter("aid");
				int aid=Integer.parseInt(ai);
				vp.setAid(aid);
				Totalcode t=new Totalcode();
				int i=t.update(vp,id);
				if(i>0) {
					 m=new  ModelAndView ("view");
				}

return m;
		 


		
    }
		 @RequestMapping(value="/deleteassignment",method = RequestMethod.POST)
		    public ModelAndView Deleteassignment(@ModelAttribute("vp")Deletepojo dp ){
			 ModelAndView m=null;
		int i=0;
			 Totalcode t=new Totalcode();
				i=t.delete(dp.getId(),dp.getAid());
				if(i>0) {
					 m=new  ModelAndView ("view");
				}
return m;
}	    	
		 @RequestMapping(value="/viewassignment",method = {RequestMethod.GET})
		    public ModelAndView View(HttpServletRequest request,HttpServletResponse response){
		    		HttpSession session=request.getSession();
		    	String id=(String)session.getAttribute("ses");
		    	if(id.equals("")) {
		    		return new ModelAndView ("signin","message","please sign in to continue");
		    	}
		    	else {
		    		return new ModelAndView ("view");
		    	}
		    	}		 
		 @RequestMapping(value="/signout")
		    public ModelAndView Signout(HttpServletRequest request,HttpServletResponse response){
		    		HttpSession session=request.getSession();
		    		session.removeAttribute("ses");
		    		
		    		return new ModelAndView ("index","message","Signed out Successfully");
		    	}		
		 
		 
		 
		 @RequestMapping("/view")
		    public ModelAndView View(){
	    		return new ModelAndView ("view");

		    	}		 

}




