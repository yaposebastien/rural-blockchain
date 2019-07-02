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
                    <a class="navbar-brand" href="${pageContext.request.contextPath}/connectedUser">
                        <img src="https://www.nkeyapo.com/wp-content/uploads/2019/06/Entourage_small.jpg" 
                             width="30" height="30" class="d-inline-block align-top" alt="">
                        Rural Land Blockchain
                    </a>
                    <div class="col-8-xsmall d-flex justify-content-end align-items-left">
                        <a class="text-muted" href="${pageContext.request.contextPath}/connectedUser"></a>
                        <!-- Display Username -->
                        <button type="button" class="btn btn-link">
                             <b>
                                 <security:authentication property="principal.username" />
                             </b>
                        </button>
                        <!--Adding Menu for Account Settings -->
                        <p></p>
                        <div class="dropdown">
                            <button class="btn btn-dark btn-sm dropdown-toggle"
                                    type="button" id="menuAccountSettings" 
                                    data-toggle="dropdown" aria-haspopup="true" 
                                    aria-expanded="false">
                            <b>My Settings</b>
                            </button>
                            <div class="dropdown-menu" 
                                 aria-labelledby="menuAccountSettings">
                                <a class="dropdown-item" href="#">Account</a>
                                <div class="dropdown-divider"></div>
                                <a class="dropdown-item" href="#">Add new land title</a>
                                <div class="dropdown-divider"></div>
                                <a class="dropdown-item" href="#">List of my land titles</a>
                               
                            </div> 
                        </div>
                         <!-- Add a logout button -->
                        <form:form action="${pageContext.request.contextPath}/logout" 
                                           method="POST">
                            <input type="submit" value="Logout" 
                                   class="btn btn-info btn-sm" />
                        </form:form> 
                    </div> <!--End col-8-xsmall d-flex justify-content-end align-items-left -->
                </nav> <!-- End of the Nav Section -->
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
                <img src="https://www.nkeyapo.com/wp-content/uploads/2019/07/blockchain.png" 
                             width="307" height="164" class="d-inline-block align-right" alt="">
            </div>

            <!--Adding Security Layer to display the account appropriate info -->
            <!-- Add a link to point OWNER -->
            <security:authorize access="hasRole('OWNER')">	
		
                <p>
                    <a href="${pageContext.request.contextPath}/connectedUser">
                        LAND OWNER PAGE
                    </a>
		</p>
                 <p>
                     
                            
                            User: <security:authentication property="principal.username" />
                            <br><br>
                            Role(s): <security:authentication property="principal.authorities" />
                            <br><br>
                            Email: ${user.email}
                            
                           
                            
                 </p>
                
            </security:authorize>
            <!-- End Section Of Owner -->
        
           
        <!-- Add a link to point to the Admin Page -->
	<security:authorize access="hasRole('ADMIN')">  

            <p>
		<a href="${pageContext.request.contextPath}/">
                    Admin
                </a>
	</p>
	
	</security:authorize>
	<!-- End Section Of Venue -->
	<hr>

        
            <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
            <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
            <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </body>
</html>











