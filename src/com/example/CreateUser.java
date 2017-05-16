package com.example;

import java.util.ArrayList;
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
import com.example.model.Client;
import com.example.model.Role;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

public class CreateUser extends ActionSupport implements SessionAware  {
	
	private Integer id;
	private String login;
	private String firstName;
	private String lastName;
	private String password;

	private Set<Client> clients = new HashSet<Client>(0);
	private Set<Role> roles = new HashSet<Role>(0);
	
	private Map<String, String>  rolesList;
	private List<String> rolesResult;

	private Map<String, String> entityList;
	private String entityResult;

	private Map<String, Object> session;
	
	@Override
	public void setSession(Map<String, Object> session) {
		// TODO Auto-generated method stub
		this.session = session;					
	}
	/* FILL LIST */
	public List<String> FillList(String Modal, String Champ){
		 try{			 			   
				/* save */	
				SessionFactory SF = new Configuration().configure().buildSessionFactory();		
				Session session;
			    session = SF.openSession();		
				session.beginTransaction();		

				Query query = session.createQuery(" SELECT " + Champ  + " FROM " + Modal);	
				List<String> Results = (List<String>) query.list();
				
				session.getTransaction().commit();		
				session.close();			 													
				
				return Results;
		 } 
		 catch (Exception e)
		 {
			 return null;
		 }
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
	public CreateUser(){
		System.out.println("Fill List");			
		rolesList = this.FillList("Role", "label","id");		
		entityList = this.FillList("Client", "name","id");		
	}
	
	
	/* DISPLAY */
	public String display() {
		System.out.println("display called");

		
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
	


	/* EXECUTE */
	public String create(){
			 System.out.println("execute called");
					
				/* SAVE */					
				SessionFactory SF = new Configuration().configure().buildSessionFactory();		
				  	 Session session0;
					 session0 = SF.openSession();		
					 session0.beginTransaction();		
					 Role role = new Role();
					 Client client = new Client();
					
					 
					 /* roles geted from from view */
				    Set<Role> rolesResultList = new HashSet<Role>(0);
					 for (String r : this.rolesResult) {
						    rolesResultList.add( (Role) session0.get(Role.class, Integer.parseInt(r)));
					 }
					 /* client geted from the view */
					 client = (Client) session0.get(Client.class, Integer.parseInt(getEntityResult()));					
					 
					 
					 User user = new User();
					 user.setLogin(login);
					 user.setFirstName(firstName);
					 user.setLastName(lastName);
					 user.setPassword(password);
					 user.getRoles().addAll(rolesResultList);
					 user.getClients().add(client);
					 
					 session0.save(user);					
					 System.out.println("user "+ login  +" saved with success");
	
					session0.getTransaction().commit();		
					session0.close();		 																				 
		return  SUCCESS;
	}
	

	
	
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Client> getClients() {
		return clients;
	}

	public void setClients(Set<Client> clients) {
		this.clients = clients;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	
	public String getEntityResult() {
		return entityResult;
	}

	public void setEntityResult(String entityResult) {
		this.entityResult = entityResult;
	}



	public Map<String, String> getRolesList() {
		return rolesList;
	}



	public void setRolesList(Map<String, String> rolesList) {
		this.rolesList = rolesList;
	}



	public List<String> getRolesResult() {
		return rolesResult;
	}



	public void setRolesResult(List<String> rolesResult) {
		this.rolesResult = rolesResult;
	}



	public Map<String, String> getEntityList() {
		return entityList;
	}



	public void setEntityList(Map<String, String> entityList) {
		this.entityList = entityList;
	}

	

	
}
