<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="/struts-tags" prefix="s" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<jsp:include page="inc_head.jsp"/>
<body class="container">
	<div class="row">
		<div class="col-md-3  col-sm-12">
			<jsp:include page="inc_header.jsp"/>
		</div>

		<div class=" col-md-4  col-md-offset-1  col-sm-12">
			<div class="page-header">
		  		<h1 class="colored">Parametrages</h1>
		  		<s:property value="Flash"/>
			</div>
			
			
			<s:form action="config_" method="POST">
				<div class="form-group ">
			    	<label for="entite">Entité :</label>
						<s:select key="entityResult" list="entityList" class="form-control" onchange="this.form.submit()"/>				     
				</div>
			</s:form>
			<s:form action="config__" method="POST">
			<div class="form-group ">
					<s:textfield type="hidden" key="entityResult"></s:textfield>
			    	<label for="Compteur">Compteur :</label>
					<s:select key="metersResult" list="metersList" class="form-control" onchange="this.form.submit()" />				     	
				</div>
			</s:form>
			<s:form action="configValues" method="POST">
				<div class="form-group">
			    	<label for="Heure">Parammetres :</label>
					<s:select key="parametersResult" list="parametersList" class="form-control" onchange="this.form.submit()" />				     				
					<s:textfield type="hidden" key="entityResult"></s:textfield>
					<s:textfield type="hidden" key="metersResult"></s:textfield>		
				</div>
			</s:form>
			<br><br><br>
			<s:form class="card" method="GET" action="configParametrer">
									
				<div class="">
					<div class="form-group">
						  <label>Ancienne valeur (%) :</label>					  
						  <s:textfield  class="form-control" key="ValidityResult" disabled="disabled"></s:textfield>
						  <s:textfield type="hidden" key="ValidityResultKey" disabled="disabled"></s:textfield>
						  <s:textfield type="hidden" key="parametersResult" disabled="disabled"></s:textfield>
					
					</div>
					
					<div class="form-group">
						  <label>Nouvelle valeur (%):</label>
						  <s:textfield key="NewValidityResult" class="form-control"></s:textfield>
					</div>
					<hr>
			
							    <s:submit  cssClass="btn btn-success" value="Enregistrer" ></s:submit>				
							    <button type="reset" class="btn btn-primary">Annuler</button>		
					
				</div>
			</s:form>
		</div>
	</div>
</body>
</html>