<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register</title>
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

<script src="https://unpkg.com/gijgo@1.9.13/js/gijgo.min.js" type="text/javascript"></script>
<link href="https://unpkg.com/gijgo@1.9.13/css/gijgo.min.css" rel="stylesheet" type="text/css" />

<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<style>
	body {
		background: #1F618D;
	}
</style>
</head>
<body>
<jsp:include page="navbar.jsp" />

	<div class="container">
		<div class="row form-group mt-5">
			<div class="col-lg-6 offset-lg-3 p-4 rounded bg-white">
			<p class="h3 font-weight-light">Create Account</p>
			<hr>
			<form action="register" method="post">
		
				<div class="row form-group">
					<div class="col-lg-6">
						<input value="${param.firstname}" class="form-control" name="firstname" type="text" placeholder="First name"/>
					</div>
					<div class="col-lg-6">
						<input value="${param.lastname}" class="form-control" name="lastname" type="text" placeholder="Last name"/>
					</div>
				</div>
				<div class="row form-group">
					<div class="col">
						<input value="${param.birthdate}" id="datepicker" name="birthdate" width="100%" placeholder="Birth Date"/>
					</div>
				</div>
				<div class="row form-group">
					<div class="col">
						<input value="${param.email}" class="form-control" name="email" type="text" placeholder="Email"/>
					</div>
				</div>
				
				<div class="row form-group">
					<div class="col">
						<input  class="form-control" name="password" type="password" placeholder="Password"/>
					</div>
				</div>
				
				<div class="row form-group ml-0">
				<label class="text-muted">Account Type: </label>
					<div class="col text-right">
						<div class="form-check form-check-inline">
						  <input <c:if test="${not empty param.checking}">checked</c:if> name="checking" class="form-check-input" type="checkbox" id="inlineCheckbox1" value="Checking">
						  <label class="form-check-label text-muted" for="inlineCheckbox1">Checking</label>
						</div>
						<div class="form-check form-check-inline">
						  <input <c:if test="${not empty param.savings}">checked</c:if> name="savings" class="form-check-input" type="checkbox" id="inlineCheckbox2" value="Savings">
						  <label class="form-check-label text-muted" for="inlineCheckbox2">Savings</label>
						</div>
					</div>
				</div>
				
				<div class="row form-group">
					<div class="col">
						<input value="${param.street}" class="form-control" name="street" type="text" placeholder="Street"/>
					</div>
				</div>
				<div class="row form-group">
					<div class="col">
						<input value="${param.city}" class="form-control" name="city" type="text" placeholder="City"/>
					</div>
				</div>
				<div class="row form-group">
					<div class="col-md-6">
						<input value="${param.state}" class="form-control" name="state" type="text" placeholder="State"/>
					</div>
					<div class="col-md-6">
						<input value="${param.zip}" class="form-control" name="zip" type="text" placeholder="Zip"/>
					</div>
				</div>	
				<div class="row form-group">
					<div class="col text-right mt-3">
						<button name="submit" type="submit" class="btn btn-block bg-warning">Create</button>
					</div>
				</div>
				
				<div class="row form-group">
					<div class="col text-right">
						<a href="/" role="button" aria-pressed="true">Go Back to Login</a>
					</div>
				</div>
			</form>	
			</div>
		</div>
	</div>
</body>
<script>
	$('#datepicker').datepicker({
	    uiLibrary: 'bootstrap4'
	});
</script>

</html>