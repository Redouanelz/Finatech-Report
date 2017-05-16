package com.example;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.derby.tools.sysinfo;
import org.apache.struts2.interceptor.SessionAware;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.example.model.User;
import com.opensymphony.xwork2.ActionSupport;


import com.example.model.Consumption;
import com.example.model.Role;


public class Facturation extends ActionSupport implements SessionAware {


	private static final String key = "-1";
	private static final String value = "Aucune selection";
	
	private Map<String, String>  entityList = new LinkedHashMap<String, String>();
	private String entityResult;
	
	private Map<String, String>  metersList = new LinkedHashMap<String, String>();
	private String metersResult;
	
	private String month;
	
	private Map<String, Object> session;
	
    Set<Role> roles = new HashSet<Role>(0);

	@Override
	public void setSession(Map<String, Object> session) {
		// TODO Auto-generated method stub
		this.session = session;					
	}
	
	
	
	
	/* FILL LIST */
	public Map<String, String> FillList(String Modal, String Champ,String Key){
		 try{			
			 						
				Map<String, String> RMap = new LinkedHashMap<String, String>();

			 	SessionFactory SF = new Configuration().configure().buildSessionFactory();		
				Session session;
			    session = SF.openSession();		
				session.beginTransaction();		

				
				Query QKey = session.createQuery(" SELECT "+ Key+" FROM " + Modal);	
				List<String> RKey = (List<String>) QKey.list();
				
				Query QVal = session.createQuery(" SELECT " + Champ  + " FROM " + Modal);	
				List<String> RVal = (List<String>) QVal.list();
							
				RMap.put( this.key, this.value);
				Iterator<String> i1 = RKey.iterator();
				Iterator<String> i2 = RVal.iterator();
				while (i1.hasNext() && i2.hasNext()) {
				    RMap.put( String.valueOf(i1.next())  , String.valueOf(i2.next()));
				}
				
				
				session.getTransaction().commit();		
				session.close();			 																							

				return RMap;
		 } 
		 catch (Exception e)
		 {
			 System.out.println("Exception");
			 e.printStackTrace() ;
			 return null;
		 }
	}


	public Map<String, String> FillList(String Modal, String Champ,String Key , String Where) {
		 try{			
			 						
				Map<String, String> RMap = new LinkedHashMap<String, String>();

			 	SessionFactory SF = new Configuration().configure().buildSessionFactory();		
				Session session;
			    session = SF.openSession();		
				session.beginTransaction();		

				
				Query QKey = session.createQuery(" SELECT "+ Key+" FROM " + Modal + " WHERE " + Where );	
				List<String> RKey = (List<String>) QKey.list();
				
				Query QVal = session.createQuery(" SELECT " + Champ  + " FROM " + Modal + " WHERE " + Where );	
				List<String> RVal = (List<String>) QVal.list();
				
				RMap.put( this.key, this.value);

				Iterator<String> i1 = RKey.iterator();
				Iterator<String> i2 = RVal.iterator();
				while (i1.hasNext() && i2.hasNext()) {
				    RMap.put( String.valueOf(i1.next())  , String.valueOf(i2.next()));
				}
				
				
				session.getTransaction().commit();		
				session.close();			 																							

				return RMap;
		 } 
		 catch (Exception e)
		 {
			 System.out.println("Exception");
			 e.printStackTrace() ;
			 return null;
		 }
	}


	public Map<String, String> FillList(String Modal, String Champ,String Key , String Where, int Max) {
		 try{			
			 						
				Map<String, String> RMap = new LinkedHashMap<String, String>();

			 	SessionFactory SF = new Configuration().configure().buildSessionFactory();		
				Session session;
			    session = SF.openSession();		
				session.beginTransaction();		

				
				Query QKey = session.createQuery(" SELECT "+ Key+" FROM " + Modal + " WHERE " + Where );	
				List<String> RKey = (List<String>) QKey.list();
				QKey.setMaxResults(Max);
				
				Query QVal = session.createQuery(" SELECT " + Champ  + " FROM " + Modal + " WHERE " + Where );	
				QVal.setMaxResults(Max);
				List<String> RVal = (List<String>) QVal.list();
							
				Iterator<String> i1 = RKey.iterator();
				Iterator<String> i2 = RVal.iterator();
				while (i1.hasNext() && i2.hasNext()) {
				    RMap.put( String.valueOf(i1.next())  , String.valueOf(i2.next()));
				}
				
				
				session.getTransaction().commit();		
				session.close();			 																							

				return RMap;
		 } 
		 catch (Exception e)
		 {
			 System.out.println("Exception");
			 e.printStackTrace() ;
			 return null;
		 }
	}

	/* CONSTRUCT */
	public Facturation(){
		try{
			System.out.println("Fill List");					
		}
		 catch (Exception e)
		 {
			 System.out.println("Exception");
			 e.printStackTrace() ;		
		 }
	}
		
	/* DISPLAY */
	public String display(){
		
		try{
			System.out.println("display called");
			entityList = this.FillList("Client", "name", "id");	
			metersList.put(key, value);
			
			User user = (User) this.session.get("login_user");
			if(user == null)
			{
				System.out.println("IsLoggedIn : redirect to login.");
				return LOGIN;			
			}
			else{
				System.out.println("IsLoggedIn : redirect to success.");
				return NONE;
			}

		}	 
		catch (Exception e)
		 {
			 System.out.println("Exception");
			 e.printStackTrace() ;	
			 return ERROR;
		 }	
	
	}

	
	/* DISPLAY 2 */
	public String display2(){
		try{
			System.out.println("display2 called");
			
			entityList = this.FillList("Client", "name", "id");	
			
			/* avec condition where */			
			String where = " client = " + this.getEntityResult();
			metersList = this.FillList("Meter", "reference","id" , where);			
			return SUCCESS;
		}	 
		catch (Exception e)
		 {
			 System.out.println("Exception");
			 e.printStackTrace() ;	
			 return ERROR;
		 }	
	
	}
	
	/* FACTURATION 3 */
	public String facturation(){
		try{
			System.out.println("facturation called");
			
			entityList = this.FillList("Client", "name", "id");	
			
			/* avec condition where */			
			String where = " client = " + this.getEntityResult();
			metersList = this.FillList("Meter", "reference","id" , where);		
			
			System.out.println("Month : " + this.getMonth());
			
			/* select * from consumption WHERE  day = '2017-05-01' */
		 	SessionFactory SF = new Configuration().configure().buildSessionFactory();		
			Session session;
		    session = SF.openSession();		
			session.beginTransaction();	
			
			
			/*  Date */
			String day = month+"-01";
			System.out.println("day : " + day);
			
		    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date day_ = sdf.parse(day);
			
			System.out.println("day_ : " + day_);

			Query query = session.createQuery("FROM Consumption WHERE day = :day ");
		
			query.setParameter("day", day_);
			List<Consumption> Results = (List<Consumption>) query.list();
						
			session.getTransaction().commit();		
			session.close();
			
			for(Consumption R : Results)
			{
				System.out.println(R.getId());
				System.out.println(R.getIndexDay());
			}

			return SUCCESS;			
		}	 
		catch (Exception e)
		 {
			 System.out.println("Exception");
			 e.printStackTrace() ;	
			 return ERROR;
		 }	
	
	}
	
	

	public Map<String, String> getEntityList() {
		return entityList;
	}


	public void setEntityList(Map<String, String> entityList) {
		this.entityList = entityList;
	}


	public String getEntityResult() {
		return entityResult;
	}


	public void setEntityResult(String entityResult) {
		this.entityResult = entityResult;
	}


	public Map<String, String> getMetersList() {
		return metersList;
	}


	public void setMetersList(Map<String, String> metersList) {
		this.metersList = metersList;
	}


	public String getMetersResult() {
		return metersResult;
	}


	public void setMetersResult(String metersResult) {
		this.metersResult = metersResult;
	}


	public String getMonth() {
		return month;
	}


	public void setMonth(String month) {
		this.month = month;
	}


	
}
