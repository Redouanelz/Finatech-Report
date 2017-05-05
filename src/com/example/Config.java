package com.example;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.opensymphony.xwork2.ActionSupport;

import com.example.model.User;
import com.example.model.Validity;
import com.example.model.Parameter;

public class Config extends ActionSupport {

	private static final String key = "-1";
	private static final String value = "Aucune selection";
	
	private Map<String, String>  entityList = new LinkedHashMap<String, String>();
	private String entityResult;
	
	private Map<String, String>  metersList = new LinkedHashMap<String, String>();
	private String metersResult;
	
	private Map<String, String>  parametersList = new LinkedHashMap<String, String>();
	private String parametersResult;
	
	private Map<String, String>  validityList = new LinkedHashMap<String, String>();
	private String validityResult;
	private String validityResultKey;
	private String NewValidityResult;
	
	public String Flash;
	
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
	public Config(){
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
	public String display() {
		try{
			System.out.println("display called");
			entityList = this.FillList("Client", "name", "id");	
			metersList.put(key, value);
			parametersList.put(key, value);		
			return NONE;
		}	 
		catch (Exception e)
		 {
			 System.out.println("Exception");
			 e.printStackTrace() ;	
			 return ERROR;
		 }	
	}
	
	
	/* DISPLAY2 */
	public String display2() {
		try{
			System.out.println("display called");
			
			entityList = this.FillList("Client", "name", "id");	
			
			/* avec condition where */			
			String where = " client = " + this.getEntityResult();
			metersList = this.FillList("Meter", "reference","id" , where);
			
			parametersList.put(key, value);		
			return SUCCESS;
		}	 
		catch (Exception e)
		 {
			 System.out.println("Exception");
			 e.printStackTrace() ;	
			 return ERROR;
		 }	
	}
	
	
	/* DISPLAY 3 */
	public String display3() {
		try{
			System.out.println("display called");
			
			entityList = this.FillList("Client", "name", "id");	
			
			/* avec condition where */			
			String where = " client = " + this.getEntityResult();
			metersList = this.FillList("Meter", "reference","id" , where);
			
			/* avec condition where */			
			String where_ = " meter = " + this.getMetersResult();
			parametersList = this.FillList("Parameter", "label","id" , where_);
			
			return SUCCESS;
		}	 
		catch (Exception e)
		 {
			 System.out.println("Exception");
			 e.printStackTrace() ;	
			 return ERROR;
		 }	
	}

	
	/* DISPLAY 4 - VALUES */
	public String display4() {
		try{
			System.out.println("display called");
			
			entityList = this.FillList("Client", "name", "id");	
			
			/* avec condition where */			
			String where = " client = " + this.getEntityResult();
			metersList = this.FillList("Meter", "reference","id" , where);
			
			/* avec condition where */			
			String where_ = " meter = " + this.getMetersResult();
			parametersList = this.FillList("Parameter", "label","id" , where_);
			
			
			/* validity .. */
			 String where__ = " parameter = " + this.getParametersResult() + "  ORDER BY id DESC";
			 validityList = this.FillList("Validity", "value", "id", where__, 1);
			 Map.Entry<String,String> entry = validityList.entrySet().iterator().next();
			 this.validityResult = entry.getValue();
			 this.validityResultKey = entry.getKey();
			return SUCCESS;
		}	 
		catch (Exception e)
		 {
			 System.out.println("Exception");
			 e.printStackTrace() ;	
			 return ERROR;
		 }	
	}

	
	
	/* PARAMETRER 5 */
	public String parametrer(){
		try{
			System.out.println("parametrer called");
			System.out.println("NewValidityResult " + this.NewValidityResult);
			System.out.println("ValidityResult " + this.validityResult);
			System.out.println("ValidityResultKey " + this.validityResultKey);

			SessionFactory SF = new Configuration().configure().buildSessionFactory();		
			Session session;
		    session = SF.openSession();		
			session.beginTransaction();		
			/* Dates */
			DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			Date today = new Date();
			Date dateNow = formatter.parse(formatter.format(today));
			
		    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date end = new Date();
			Date endDate = sdf.parse("2999-12-12");

			/* update the actual validity value date*/
			Validity actualValidity = new Validity();
			Integer id = Integer.parseInt(this.getValidityResultKey());
			actualValidity = (Validity) session.get(Validity.class, id );	
			actualValidity.setEndDate(dateNow);
			session.update(actualValidity);
			
			/* new validity value */
			double newValidityValue = Double.parseDouble(NewValidityResult);
			
			
			Parameter parameter = new Parameter();
			Integer id_ = Integer.parseInt(this.getParametersResult());
			parameter = (Parameter) session.get(Parameter.class, id_ );	
			
			Validity newValidity = new Validity();
			newValidity.setStartDate(dateNow);
			newValidity.setEndDate(endDate);			
			newValidity.setValue(newValidityValue);
			newValidity.setParameter(parameter);
			
			session.save(newValidity);
			session.save(parameter);
			
			/* commit */
			session.getTransaction().commit();		
			session.close();			 																							

			/* DoFlash*/
			this.setFlash("Parametrage Sauvgarder!");
			return SUCCESS;
		}
		catch (Exception e)
		 {
			 System.out.println("Exception");
			 e.printStackTrace() ;	
			 return ERROR;
		 }	
	}
	
	/* Geters & Seters */

	public Map<String, String> getParametersList() {
		return parametersList;
	}
	


	public void setParametersList(Map<String, String> parametersList) {
		this.parametersList = parametersList;
	}


	public String getParametersResult() {
		return parametersResult;
	}


	public void setParametersResult(String parametersResult) {
		this.parametersResult = parametersResult;
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



	public Map<String, String> getValidityList() {
		return validityList;
	}



	public void setValidityList(Map<String, String> validityist) {
		this.validityList = validityist;
	}



	public String getValidityResult() {
		return validityResult;
	}



	public void setValidityResult(String validityResult) {
		this.validityResult = validityResult;
	}



	public static String getKey() {
		return key;
	}



	public static String getValue() {
		return value;
	}



	public String getValidityResultKey() {
		return validityResultKey;
	}



	public void setValidityResultKey(String validityResultKey) {
		this.validityResultKey = validityResultKey;
	}



	public String getNewValidityResult() {
		return NewValidityResult;
	}



	public void setNewValidityResult(String newValidityResult) {
		NewValidityResult = newValidityResult;
	}



	public String getFlash() {
		return Flash;
	}



	public void setFlash(String flash) {
		Flash = flash;
	}

	
	
	
	
}
