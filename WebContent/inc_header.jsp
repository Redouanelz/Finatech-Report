<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="/struts-tags" prefix="s" %>    
	<style type="text/css">
	.a1{
		font-family:Georgia, 'Times New Roman', Times, serif;
		font-size:20px;
	}
	.a2{
		font-family:Georgia, 'Times New Roman', Times, serif;
		font-size:16px;
	}
	.a3{
		font-family:Georgia, 'Times New Roman', Times, serif;
		font-size:12px;
	}
	
	.icon{
		margin-top:9px;
		margin-left:5px;
		float: left;
		width:20px;
		height:20px;
	}
	</style>
	<nav  style="margin-top: 100px;">
		<ul class="nav nav-pills nav-stacked" style ="background-color:#f1f1f1;border: solid #cecaca 3px;" role="tablist">
			<li><img src="images/AdminLogo.png" class="icon" alt="icon"/><a class="a1" style="padding-left:10px;padding-top:5px; padding-bottom:5px;margin-left:25px;" ><strong>Administration</strong></a></li>
				
			<li class="dropdown" style="width:205px;margin-left:20px;">
				<a class="dropdown-toggle" data-toggle="dropdown" class="a2" href="">Gestion Des Utilisateurs <span class="caret"></span></a>
				<ul class="dropdown-menu" role="menu" style="background-color:#f1f1f1;">
					<li><a href="createuser.action" class="a3" style="color:#2c6ad3">Nouvel Utilisateur</a></li>
					<li><a href="updateuser.action" class="a3" style="color:#2c6ad3">Modifier Utilisateur</a></li>
				</ul>
			</li>
				
			<li class="dropdown" style="width:205px;margin-left:20px;">
				<a class="dropdown-toggle" data-toggle="dropdown" class="a2" href="#">Configuration <span class="caret"></span></a>
				<ul class="dropdown-menu" role="menu" style="background-color:#f1f1f1;">
					<li><a href="config.action" class="a3" style="color:#2c6ad3">Parametrage</a></li>                       
				</ul>
			</li>
			<li><img src="images/BillingLogo2.png" class="icon" alt="icon"/><a class="a1" style="padding-left:10px;padding-top:5px; padding-bottom:5px;margin-left:25px;" href="facturation.action"><strong>Facturation</strong></a>	</li>
			<li><img src="images/Disconnect.png" class="icon" alt="icon"/><a class="a1" style="padding-left:10px;padding-top:5px; padding-bottom:5px;margin-left:25px;" href="<s:url action='Logout'/>"><strong>Déconnexion</strong></a>	</li>

		</ul>
</nav>