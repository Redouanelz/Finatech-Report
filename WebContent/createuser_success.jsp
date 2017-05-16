<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<jsp:include page="inc_head.jsp"/>
	<body class="container">
	
	<div class="row">
		<div class="col-md-3 col-md-offset-1  col-sm-12">
			<jsp:include page="inc_header.jsp"/>		
		</div>

		 <div class="col-md-4 col-sm-12 " >	
			  <div class="page-header">
			    <h1 class="colored">Utilisateur crée :  <s:property value="login"/> <br>
			    </h1>
			  </div>
	 		
	 		<div class="row">
	 			<div class="col-md-2">
	 				<img alt="" src="images/0.jpg" class="img-circle" width="80px" height="80px">
	 			</div>
	 			<div class="col-md-4">
	 			<div class="padding-10">
	 			
	 			</div>
	 			<div class="padding-10">
	 			
	 			</div>	 		
			 	
	 			</div>
	 		</div>
		  
		  	<br>
		  	<hr>
		 		 	
						    <a href="createuser.action" class="btn btn-reverse btn-block">
						    <i class="fa fa-user-plus"></i>	
						    <b>Ajouter un autre utilisateur</b>
						    </a>
						
				
						    <a href="home.jsp" class="btn btn-rlz btn-block">
						    <i class="fa fa-home"></i>	
						    <b>Retour a l'acueille</b>
						    </a>
					
	    </div>
	  
	</div>
</body>
</html>