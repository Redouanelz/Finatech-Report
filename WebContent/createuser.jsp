<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<jsp:include page="inc_head.jsp"/>
<body class="container">
	
	<div class="row">
		<div class="col-md-3  col-sm-12">
			<jsp:include page="inc_header.jsp"/>		
		</div>
		
		 <div class="col-md-4 col-md-offset-1 col-sm-12" >	
			  <div class="page-header">
			    <h1 class="colored">Nouveau Utilisateur</h1>
			  </div>
	 		
	 					 		
		    <s:form action="createuser_.action" class="card" method="POST">			    
				
		      <div class="form-group">
		        <label for="login">Login :</label>
		        <s:textfield type="text" class="form-control" key="login" placeholder="Entrer login" value="" required="true" />
		      </div>
		      <div class="form-group">
		        <label for="prenom">Prenom :</label>
		        <s:textfield type="text" class="form-control" key="lastName" placeholder="Entrer prénom" value="" required="true" />
		      </div>
		      <div class="form-group">
		        <label for="nom">Nom :</label>
		        <s:textfield type="text" class="form-control" key="firstName" placeholder="Entrer nom" value="" required="true"  />
		      </div>
		      <div class="form-group">
		        <label for="password">Mot de passe :</label>
		        <s:textfield type="text" class="form-control" key="password" placeholder="Entrer Mot de passe" value="free" required="true"  />
		      </div>  	
		      <div class="form-group">
		        <label for="Organisme">Entité  :</label>
						<s:select cssClass="form-control"
							headerKey="" headerValue="Selectionner"   required="true" 
							list="entityList" 
							name="entityResult" 
						   />		        	       		     		      
		       </div>
		       <br>
		       <div class="form-group">
		        <label>Rôles : </label>
		        <br />		        
			    <s:checkboxlist list="rolesList" key="rolesResult"  ></s:checkboxlist>
		        	      
		       </div>
		
		       <br>				
						    <s:submit  cssClass="btn btn-success" value="Ajouter" ></s:submit>									
						    <button type="reset" class="btn btn-primary">Annuler</button>						
		  </s:form>
		  
		  
	    </div>
	  
	</div>
</body>
</html>