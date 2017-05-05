<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Authentification</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <link rel="stylesheet" href="Bootstrap/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="Bootstrap/bootstrap.min.js"></script>
</head>
<body><p align="center">
<br>
<br>
	</p><div class="container" style="margin-top:150px;">
		<div class="row vertical-offset-0">
			<div class="col-md-4 col-md-offset-4">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">Authentification</h3>
					</div>
					<div class="panel-body">
						<s:form accept-charset="UTF-8" role="form" action="Login" theme="simple">
						<fieldset>
							<div class="input-group form-group">
							  <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
							  <s:textfield id="login" type="text" class="form-control" name="login" placeholder="Entrer Login" />
							</div>
							<div class="input-group">
							  <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
							  <s:textfield id="password" type="password" class="form-control" name="password" placeholder="Entrer Mot de passe"/>
							</div>
							<div class="checkbox">
								<label>
									<input name="remember" type="checkbox" value="Remember Me"> Se souvenir de moi
								</label>
							</div>
							<s:submit class="btn btn-lg btn-primary btn-block" type="submit" value="Se connecter"/>
						</fieldset>
						</s:form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>