<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="Entourage Music" content="The online platform for the driven emerging musician">
        <meta name="generator" content="Jekyll v3.8.5">
        <title>Rural Blockhain - The online platform for citizen to safely register  their land.</title>

        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
              integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous" />

        <!-- Bootstrap core CSS -->
        <link type="text/css"
              href="${pageContext.request.contextPath}/resources/css/boutique.css"
              rel="stylesheet" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
              crossorigin="anonymous" />

        <!-- Bootstrap core CSS -->
        <link type="text/css"
              href="${pageContext.request.contextPath}/resources/css/boutique.css"
              rel="stylesheet" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
              crossorigin="anonymous" />

        <style>
            .bd-placeholder-img {
                font-size: 1.125rem;
                text-anchor: middle;
                -webkit-user-select: none;
                -moz-user-select: none;
                -ms-user-select: none;
                user-select: none;
            }

            @media (min-width: 768px) {
                .bd-placeholder-img-lg {
                    font-size: 3.5rem;
                }
            }
        </style>
    </head>

    <body>

        <div class="container">
            <header class="blog-header py-3">
                <!-- Image and text -->
                <nav class="navbar navbar-light bg-light">
                    <a class="navbar-brand" href="${pageContext.request.contextPath}/">
                        <img src="https://www.nkeyapo.com/wp-content/uploads/2019/06/Entourage_small.jpg" width="30" height="30" class="d-inline-block align-top" alt="">
                        Rural Land Blockchain
                    </a>

                    <div class="col-8-xsmall d-flex justify-content-end align-items-left">
                        <a class="text-muted" href="#">
                            <svg xmlns="http://www.w3.org/2000/svg" width="20" 
                                 height="20" fill="none" stroke="currentColor"
                                 stroke-linecap="round" stroke-linejoin="round"
                                 stroke-width="2" class="mx-3" role="img" 
                                 viewBox="0 0 24 24" focusable="false">
                            <title>Search</title><circle cx="10.5" cy="10.5" r="7.5"/>
                            <path d="M21 21l-5.2-5.2"/>
                            </svg>
                        </a>
                    </div>
                       
                </nav>
            </header>

            <!-- Jumbotron Bootstrap -->
            <div class="jumbotron p-4 p-md-5 text-white rounded bg-success" >
                <div class="col-md-6 px-0">
                    <h1 class="display-4 font-italic">Rural Blockchain</h1>
                    <p class="lead my-3">By using blockchain technologies,
                        CIV RURAL BLOCKCHAIN can provide its citizens with 
                        a digital certificate of their land, supported with 
                        cryptographical proof published to the Ethereum Blockchain.
                        
                    </p>

                </div>
            </div>
            <div>
                <center>
		<div id="loginbox" style="margin-top: 50px;"
			class="mainbox col-md-3 col-md-offset-2 col-sm-6 col-sm-offset-2">
                    <div class="panel panel-primary">
			<div class="panel-heading">
                            <div class="panel-title"></div>
			</div>
			<div style="padding-top: 5px" class="panel-body">
			<!-- Registration Form -->
			<form:form action="${pageContext.request.contextPath}/register/processUserRegistrationForm" 
                                    modelAttribute="crmUser" class="form-horizontal">
                            <!-- Place for messages: error, alert etc ... -->
                            <div class="form-group row">
                                <div class="col-xs-15">
                                    <div>
                                        <!-- Check for registration error -->
                                        <c:if test="${registrationError != null}">
                                            <div class="alert alert-danger col-xs-offset-1 col-xs-10">
                                                    ${registrationError}
                                            </div>
                                        </c:if>
                                    </div>
                                </div>
                            </div>
                        
                            <!-- User name -->
                            <div style="margin-bottom: 25px" class="input-group">
				<span class="input-group-addon">
                                    <i class="glyphicon glyphicon-user"></i>
                                </span>
				<form:errors path="userName" cssClass="error" />
				<form:input path="userName" placeholder="username (*)" class="form-control" />
                            </div>

                            <!-- Password -->
                            <div style="margin-bottom: 25px" class="input-group">
                                <span class="input-group-addon">
                                    <i class="glyphicon glyphicon-lock"></i>
                                </span> 
				<form:errors path="password" cssClass="error" />
				<form:password path="password" placeholder="password (*)" class="form-control" />
                            </div>
                            <!-- Confirm Password -->
                            <div style="margin-bottom: 25px" class="input-group">
				<span class="input-group-addon">
                                    <i class="glyphicon glyphicon-lock"></i>
                                </span> 
				<form:errors path="matchingPassword" cssClass="error" />
				<form:password path="matchingPassword" 
                                               placeholder="confirm password (*)" 
                                               class="form-control" />
                            </div>
                            <!-- Email -->
                            <div style="margin-bottom: 25px" class="input-group">
				<span class="input-group-addon">
                                    <i class="glyphicon glyphicon-user"></i>
                                </span> 
				<form:errors path="email" cssClass="error" />
				<form:input path="email" 
                                            placeholder="email (*)" 
                                            class="form-control" />
                            </div>
                            <!--TypeUser -->
                            <div style="margin-bottom: 25px" class="input-group">
				<span class="input-group-addon">
                                    <i class="glyphicon glyphicon-user"></i>
                                </span> 
				<form:errors path="typeUser" cssClass="error" />
                                <form:select path="typeUser" 
                                             placeholder="Type User (*)" 
                                             class="form-control" >
                                    <form:option value="Select" label="Select..."/>  
                                    <form:option value="ROLE_OWNER" label="Owner"/>
                                </form:select> 
                            </div>
                            <!-- Register Button -->
                            <div style="margin-top: 10px" class="form-group">						
				<div class="col-sm-6 controls">
                                    <button type="submit" class="btn btn-primary">
                                        Register
                                    </button>
				</div>
                            </div>
			</form:form>

                        </div>
                    </div>
                </div>
                </center>
            </div>


        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </body>
</html>
