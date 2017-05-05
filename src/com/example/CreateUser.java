package com.example;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.derby.tools.sysinfo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.example.model.User;
import com.example.model.Client;
import com.example.model.Role;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

public class CreateUser extends ActionSupport implements Action  {
	
	private Integer id;
	private String login;
	private String firstName;
	private String lastName;
	private String password;

	private Set<Client> clients = new HashSet<Client>(0);
	private Set<Role> roles = new HashSet<Role>(0);
	
	private List<String> rolesList;
	private String rolesResult;

	private List<String> entityList;
	private String entityResult;

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

	/* CONSTRUCT */
	public CreateUser(){
		System.out.println("Fill List");			
		rolesList = this.FillList("Role", "label");		
		entityList = this.FillList("Client", "name");		
	}
	
	
	/* DISPLAY */
	public String display() {
		System.out.println("display called");

		return NONE;
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
					 role = (Role) session0.get(Role.class, 1);		
					 client = (Client) session0.get(Client.class, 1);		
					 
					 User user = new User();
					 user.setLogin(login);
					 user.setFirstName(firstName);
					 user.setLastName(lastName);
					 user.setPassword(password);
					 user.getRoles().add(role);
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

	public List<String> getRolesList() {
		return rolesList;
	}

	public void setRolesList(List<String> rolesList) {
		this.rolesList = rolesList;
	}


	public String getRolesResult() {
		return rolesResult;
	}

	public void setRolesResult(String rolesResult) {
		this.rolesResult = rolesResult;
	}

	public List<String> getEntityList() {
		return entityList;
	}

	public void setEntityList(List<String> entityList) {
		this.entityList = entityList;
	}

	public String getEntityResult() {
		return entityResult;
	}

	public void setEntityResult(String entityResult) {
		this.entityResult = entityResult;
	}


	
}
