<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

<script src="https://unpkg.com/gijgo@1.9.13/js/gijgo.min.js" type="text/javascript"></script>
<link href="https://unpkg.com/gijgo@1.9.13/css/gijgo.min.css" rel="stylesheet" type="text/css" />

<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<style>
	body {
		background: #1F618D;
	}
	.material-icons{
	    display: inline-flex;
	    vertical-align: top;
	}
	/* .moving-text {
		-webkit-animation: moving 1s;
    	animation: moving 1s;
    	transform: translateY(200px);
	}
	@-webkit-keyframes moving {
    	from {-webkit-transform: translateY(400px);}
    	to {-webkit-transform: translateY(200px);}
	}

	@keyframes moving {
	    from {transform: translateY(400px);}
	    to {transform: translateY(200px);}
	} */
</style>
</head>
<body>
<jsp:include page="navbar.jsp" />

	<div class="container">
		<div class="row form-group mt-5">
			<div class="col-lg-6 h-100 text-center text-white">
				<p class="h5 font-weight-light mt-lg-5 moving-text"><i class="material-icons md-48">credit_card</i> Access your bank account<br>online</p>
			</div>
		
			<div class="col-lg-5 p-5 rounded bg-white">
			
			<p class="h3 font-weight-light">Sign In</p><span class="text-danger font-weight-light">${invalidLogin.loginError}</span>
			<hr>
			<form action="/" method="post">
				<div class="row form-group">
					<div class="col">
						<input value="${param.email}" class="form-control" name="email" type="text" placeholder="Email" />
					</div>
				</div>
				
				<div class="row form-group">
					<div class="col mt-3">
						<input class="form-control" name="password" type="password" placeholder="Password"/>
					</div>
				</div>
				
				<div class="row form-group">
					<div class="col text-right">
						<a href="">Forgot Password</a>
					</div>
				</div>
				
				<div class="row form-group">
					<div class="col text-right mt-3">
						<button name="submit" type="submit" class="btn btn-block bg-warning">Sign In</button>
					</div>
				</div>
			</form>	
				<div class="row form-group">
					<div class="col mt-5">
						<p class="h5 font-weight-light">Need to Register?</p>
					</div>
				</div>
			
				<div class="row form-group">
					<div class="col">
						<a href="register" class="btn btn-info btn-block active" role="button" aria-pressed="true">Create Account</a>
					</div>
				</div>
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