package com.example;

import com.example.model.Client;
import com.example.model.Role;
import com.example.model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.opensymphony.xwork2.ActionSupport;


public class Login extends ActionSupport implements SessionAware  {
	
	/* DECLARATION */
	 private String login; 
	 private String password;
	 private SessionMap<String,Object> sessionMap;  
	 
	 /* SET SESSION */
	 @Override  
	 public void setSession(Map<String, Object> map) {  
	     sessionMap=(SessionMap)map;  
	     sessionMap.put("login","true");  	     
	 }  
	   
	 
	 /* EXECUTE  */	
	 public String execute() {
		 try{
			 
			    User user = new User();
				user.setLogin(login);
				user.setPassword(password);
			 
				/* save */	
				SessionFactory SF = new Configuration().configure().buildSessionFactory();		
				Session session;
			    session = SF.openSession();		
				session.beginTransaction();		

				Query query = session.createQuery("FROM User WHERE login = :login AND password = :password ");
				query.setParameter("login", login);
				query.setParameter("password", password);  
				List<User> Results = (List<User>) query.list();
				
				/* get actual loged user roles */
				Set<Role> roles = Results.get(0).getRoles();
				List<String> rolesAutorizations = new ArrayList<>();
				for ( Role r : roles)	rolesAutorizations.add(r.getId().toString());	
				for ( String s : rolesAutorizations )
				{
					if(s.equals("1"))
						 sessionMap.put("Autorization_users", "show" );
					if(s.equals("2"))
						 sessionMap.put("Autorization_config", "show" );						
				}
				
				session.getTransaction().commit();		
				session.close();			 													

				 /* if there is an user or not */
				 if (Results.size() > 0)
				 {
					 sessionMap.put("login_user", Results.get(0));
					 sessionMap.put("login_roles", rolesAutorizations );
					 
					 System.out.println("Login Success for : " + Results.get(0).getLogin());
				
					 return SUCCESS;
				 }
				 else
				 {
					 System.out.println("Login Error");
					 return ERROR;
				 }				 				 				
		 } 
		 catch (Exception e)
		 {
			 System.out.println(e);
			 return ERROR;
		 }
	  }
				
				
	/* LOGOUT */
	 public String logout(){  		 
		 if(sessionMap!=null) {  sessionMap.invalidate();   } 
		 return SUCCESS;  	 
	}  
	 
	 
	 /* getters & setters */
	 public String getLogin() {
	  return login;
	 }
	 public void setLogin(String login) {
	  this.login = login;
	 }
	 public String getPassword() {
	  return password;
	 }
	 public void setPassword(String password) {
	  this.password = password;
	 }
	 
	
		  
	

}
