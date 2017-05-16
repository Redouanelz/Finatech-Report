package com.example;

import com.opensymphony.xwork2.ActionSupport;

public class Worked extends ActionSupport {

	public Worked()
	{
		
	}
	
	public String IsLoggedIn(Object obj)
	{
		if(obj == null)
		{
			System.out.println("IsLoggedIn : redirect to login.");
			return LOGIN;			
		}
		else{
			System.out.println("IsLoggedIn : redirect to success.");
			return SUCCESS;
		}

	}
}
