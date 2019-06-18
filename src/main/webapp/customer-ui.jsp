<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Customer Name</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<script src="https://unpkg.com/gijgo@1.9.13/js/gijgo.min.js" type="text/javascript"></script>
<link href="https://unpkg.com/gijgo@1.9.13/css/gijgo.min.css" rel="stylesheet" type="text/css" />

<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
</head>
<body>
<jsp:include page="navbar.jsp" />
	<div class="container">
		<div class="col-lg-6 offset-lg-3 bg-light p-4 mt-5">
			<div class="row form-group">
				<div class="col">
					<a href="#" class="btn btn-primary btn-block" role="button">Deposit</a>
				</div>
			</div>
			<div class="row form-group">
				<div class="col">
					<a href="#" class="btn btn-primary btn-block" role="button">Withdraw</a>
				</div>
			</div>
			<div class="row form-group">
				<div class="col">
					<a href="#" class="btn btn-primary btn-block" role="button">Check Balance</a>
				</div>
			</div>
			<div class="row form-group">
				<div class="col">
					<a href="#" class="btn btn-primary btn-block" role="button">Transfer</a>
				</div>
			</div>
		</div>
	</div>
</body>
</html>