<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<jsp:include page="inc_head.jsp"/>
	
	
<body class="container">
	<div class="row">
		<div class="col-md-3 col-sm-12">
		<jsp:include page="inc_header.jsp"/>
		</div>
		<div class="col-md-4 col-md-offset-1 col-sm-12">
				<h1 class="colored">Facturation</h1>
				<hr>
			<div class="card">
			    <s:form action="facturation_" method="POST">
				<div class="form-group ">
			    	<label for="entite">Entité :</label>
					<s:select key="entityResult" list="entityList" class="form-control" onchange="this.form.submit()"/>				     
				</div>
		 	</s:form>
			<s:form action="facturation__" method="POST">
			<div class="form-group ">
					<s:textfield type="hidden" key="entityResult"></s:textfield>
			    	<label for="Compteur">Compteur :</label>
					<s:select key="metersResult" list="metersList" class="form-control" />				     	
				</div>
		
				<div class="form-group">
					<label >Mois :</label>
					<s:textfield type="month"  key="month" cssClass="form-control"/>
					<hr>
					<s:submit class="btn btn-success" value="Valider" />
				</div>				
			</s:form>
			</div>
		</div>
	</div>
</body>
</html>