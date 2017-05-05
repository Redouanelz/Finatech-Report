<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="/struts-tags" prefix="s" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<jsp:include page="inc_head.jsp"/>
	<jsp:include page="inc_head.jsp"/>
	<body class="inner-container">
	
	<div class="row">
		<div class="col-md-4 col-sm-12">
			<jsp:include page="inc_header.jsp"/>		
		</div>

		 <div class="col-md-8 col-sm-12 " >	
  		<div class="page-header">
  			<h1 class="colored">Modifier Utilisateur</h1>
		</div>
		<s:form action="updateuser_continue.action" method="GET">
			<div class="bloc" style="margin-bottom: 20px;">
						<label for="Organisme">Choisissez l'utilisateur :</label>				

				<s:select key="usersResult" list="usersList" class="form-control" onchange="this.form.submit()" required="true"  />
			</div>
	    	
				
	  	</s:form>	  
		 	<s:form action="updateuser_" style=" padding-bottom: 100px;" method="GET">
	  	
	 
		  		  	 <s:textfield key="usersResult" type="hidden"></s:textfield>
	  		  	<hr> <br>
	  		  		 <div class="form-group">	  		  	  			  		 
				        <label for="prenom">Login :</label>  
				        <s:textfield type="text" class="form-control"  name="login" placeholder="Entrer votre login"  />
				      </div>
	  		  		  <div class="form-group">	  		  	  			  		 
				        <label for="prenom">Prenom :</label>
				        <s:textfield type="text" class="form-control" key="lastName" placeholder="Entrer prénom"  />
				      </div>
				      <div class="form-group">
				        <label for="nom">Nom :</label>
				        <s:textfield type="text" class="form-control" key="firstName" placeholder="Entrer nom"  />
				      </div>
				      <div class="form-group">
				        <label for="password">Mot de passe :</label>
				        <s:textfield type="text" class="form-control" key="password" placeholder="Entrer Mot de passe"  />
				      </div>  	
				      <div class=form-group>
				      	<label>Entité</label>
						<s:select key="entityResult" list="entityList" class="form-control" />				     
				      </div>
				      <div class=form-group>
				      	<label>roles</label> <br>
						  <s:radio list="rolesList" name="rolesResult" value="rolesResult"></s:radio>  
				      </div>
		
		
		     		  <br>
					<div class="row">
						<div class="col-md-6">
						    <s:submit  cssClass="btn btn-reverse btn-block" value="Modifier" ></s:submit>
						
						</div>
						<div class="col-md-2">
						    <a href="home.jsp" class="btn btn-rlz">Annuler</a>		
						</div>
					</div>	
	  	
	  	</s:form>
	</div>
  </div>
</body>
</html>