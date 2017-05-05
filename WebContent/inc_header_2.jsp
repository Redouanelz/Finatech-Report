<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="/struts-tags" prefix="s" %>    
	<style type="text/css">
	
	</style>
	
	 <!-- Fixed navbar -->
    <nav class="navbar navbar-default navbar-fixed-top">
      <div class="container">
        <div class="navbar-header" style="    padding: 10px 30px;">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href=""> <i class="fa fa-pie-chart" aria-hidden="true"></i> Administration</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse navbar-right" style="padding-top: 10px;">
          <ul class="nav navbar-nav">
            
             <li><a href="home.jsp"> 
             	<b><i class="fa fa-lg fa-home"></i>  Acueille</b>
             </a></li>     
            
             <li><a href="facturation.action"> <i class="fa fa-file-text"></i> Facturation</a></li>     
            
            
             <li class="dropdown">
              <a  class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"> <i class="fa fa-users"></i> Gestion d'utilisateurs <span class="caret"></span></a>
              <ul class="dropdown-menu">
                   <li><a href="createuser.action"> <i class="fa fa-user-plus"></i> Nouveaux</a></li>
         		   <li><a href="updateuser.action"> <i class="fa fa-pencil"></i> Modifier</a></li>          
              </ul>
            </li>
            

            <li class="dropdown">
              <a  class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"> <i class="fa fa-cog"></i> Configuration <span class="caret"></span></a>
              <ul class="dropdown-menu">
                <li><a href="config.action"> <i class="fa fa-cog"></i> Parametrage</a></li>             
              </ul>
            </li>
            
            
              <li class="dropdown">
              <a  class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
              <img class="img img-circle" alt="" src="images/0.jpg" width="40px" height="40px"> 
              <span class="caret"></span>
              </a>
              <ul class="dropdown-menu">
				<li> <a href="<s:url action='Logout'/>"> <i class="fa fa-sign-out"></i> Déconnexion</a>	  </li>          
              </ul>
            </li>
            
            
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </nav>	