package com.example;

import com.example.model.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
				
				session.getTransaction().commit();		
				session.close();			 													

				 /* if there is an user or not */
				 if (Results.size() > 0)
				 {
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
