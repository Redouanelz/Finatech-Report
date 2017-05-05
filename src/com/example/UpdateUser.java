package com.example;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.example.model.Client;
import com.example.model.Role;
import com.example.model.User;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.sun.glass.ui.CommonDialogs.Type;

public class UpdateUser extends ActionSupport implements Action {
	
	private Integer id;
	private String login;
	private String firstName;
	private String lastName;
	private String password;

	private Set<Client> clients = new HashSet<Client>(0);
	private Set<Role> roles = new HashSet<Role>(0);
	
	private Map<String, String>  usersList;
	private String usersResult;
	
	private Map<String, String>  rolesList;
	private String rolesResult;

	private Map<String, String>  entityList;
	private String entityResult;
	
	
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
	public UpdateUser(){
		try{
			System.out.println("Fill List");		

			entityList = this.FillList("Client", "name","id");
			usersList = this.FillList("User", "login","id");
			rolesList = this.FillList("Role", "label","id");
		}
		 catch (Exception e)
		 {
			 System.out.println("Exception");
			 e.printStackTrace() ;		
		 }

	}
	
	/* DISPLAY */
	public String display() {
		System.out.println("display called");
		return NONE;
	}
	
	/* CONTINUE */
	public String continuer(){
		System.out.println("continue Called");
		
		/* SAVE */					
			SessionFactory SF = new Configuration().configure().buildSessionFactory();		
		  	 Session session0;
			 session0 = SF.openSession();		
			 session0.beginTransaction();	
			 User userget = new User();
			 Role role = new Role();
			 Client client = new Client();
			 
			 
			 int id = Integer.parseInt(getUsersResult());
			 userget = (User) session0.get(User.class, id);	
			 
			 this.usersResult = userget.getId().toString();
			 
			 role = (Role) session0.get(Role.class, 1);		
			 client = (Client) session0.get(Client.class, 1);	
			 
			 this.login = userget.getLogin();
			 this.firstName = userget.getFirstName();
			 this.lastName = userget.getLastName();
			 this.password = userget.getPassword();
					
			 System.out.println("user "+ usersResult +" geted continue with success");

			session0.getTransaction().commit();		
			session0.close();		 
			
		return SUCCESS;
	}
	
	/* EXECUTE */
	public String update(){

		 System.out.println("execute called");
				
			/* SAVE */					
			SessionFactory SF = new Configuration().configure().buildSessionFactory();		
			  	 Session session0;
				 session0 = SF.openSession();		
				 session0.beginTransaction();	
				 User user = new User();
				 Role role = new Role();
				 Client client = new Client();
				 
				 System.out.println("user : "+ this.usersResult + " role : " + getRolesResult()  + " ntity :  " + getEntityResult());
				 user = (User) session0.get(User.class, Integer.parseInt(this.usersResult));	
				 role = (Role) session0.get(Role.class, Integer.parseInt(getRolesResult()));
				 client = (Client) session0.get(Client.class, Integer.parseInt(getEntityResult()));					
				 
				 user.setFirstName(firstName);
				 user.setLastName(lastName);
				 user.setPassword(password);
				 user.getRoles().clear();
				 user.getClients().clear();
				 user.getRoles().add(role);
				 user.getClients().add(client);
				 
				 session0.update(user);	
				 
				 System.out.println("user "+ user.getLogin()  +" update with success");

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

	public Map<String, String> getUsersList() {
		return usersList;
	}

	public void setUsersList(Map<String, String> usersList) {
		this.usersList = usersList;
	}

	public Map<String, String> getRolesList() {
		return rolesList;
	}

	public void setRolesList(Map<String, String> rolesList) {
		this.rolesList = rolesList;
	}

	public String getRolesResult() {
		return rolesResult;
	}

	public void setRolesResult(String rolesResult) {
		this.rolesResult = rolesResult;
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

	public String getUsersResult() {
		return usersResult;
	}
	public void setUsersResult(String usersResult) {
		this.usersResult = usersResult;
	}

	
	
}
