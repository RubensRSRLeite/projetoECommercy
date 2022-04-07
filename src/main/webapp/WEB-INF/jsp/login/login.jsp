<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags/" prefix="tag" %>
<html lang="pt-br">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>E-Commerce - Login</title>
        <link rel="icon" type="image/x-icon" href="assets/img/favicon.ico" />
        <!-- Font Awesome icons (free version)-->
        <script src="https://use.fontawesome.com/releases/v5.15.1/js/all.js" crossorigin="anonymous"></script>
        <!-- Google fonts-->
        <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css" />
        <link href="https://fonts.googleapis.com/css?family=Droid+Serif:400,700,400italic,700italic" rel="stylesheet" type="text/css" />
        <link href="https://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700" rel="stylesheet" type="text/css" />
        <!-- Core theme CSS (includes Bootstrap)-->
        <link href="css/estilo.css" rel="stylesheet" />
    </head>
    <body id="page-top">
        <!-- Navigation-->
       
       <tag:menu-superior>
       </tag:menu-superior>
       
        <!-- Masthead-->
        <header class="masthead" id="login">
            <div class="container">
                <div class="masthead-subheading">Bem Vindo ao ShoppingCommerce!</div>
                <div class="masthead-heading text-uppercase">Login</div>
                
                <c:if test="${not empty errors}">
	                <div class="alert alert-danger" role="alert">
	                	<c:forEach var="error" items="${errors}">
	                	
	                		${error.message}<br/>	
	                	
	                	</c:forEach>
	                
	                </div>
                
                </c:if>
                
                <form method ="post" action="<c:url value="/login/autenticar"/>">
                    <div class="row justify-content-md-center mb-5 text-center">
                        <div class="col-md-12 align-self-center text-center">
                            <div class="form-group input-login mx-auto">
                                <input class="form-control" id="email" name="email" value="${autenticar}" required="required" minlenth="7" type="email"  placeholder="Email *" required="required" data-validation-required-message="Please enter your email address." />
                                <p class="help-block text-danger"></p>
                            </div>
                            <div class="form-group mb-md-0 input-login mx-auto">
                                <input class="form-control" id="phone" name="senha" value="${autenticar}" required="required" minlenth="5"  type="password" placeholder="Senha *" required="required" data-validation-required-message="Insira sua senha." />
                                <p class="help-block text-danger"></p>
                            </div>
                        </div>
                        
                    </div>
                	<button  type="submit"  class="btn btn-primary btn-xl text-uppercase js-scroll-trigger">Login</button>
                </form>
                
            </div>
        </header>
        <!-- beneficios-->
        <section class="page-section" id="beneficios">
            <div class="container">
                <div class="text-center">
                    <h2 class="section-heading text-uppercase">Benef�cios</h2>
                    <h3 class="section-subheading text-muted">Aqui no shoppingCommerce voc� encontra os melhores pre�os!</h3>
                </div>
                <div class="row text-center">
                    <div class="col-md-4">
                        <span class="fa-stack fa-4x">
                            <i class="fas fa-circle fa-stack-2x text-primary"></i>
                            <i class="fas fa-shopping-cart fa-stack-1x fa-inverse"></i>
                        </span>
                        <h4 class="my-3">R�pido</h4>
                        <p class="text-muted">Aqui voc� encontra e realiza sua compra de maneira pr�tica e r�pida! </p>
                    </div>
                    <div class="col-md-4">
                        <span class="fa-stack fa-4x">
                            <i class="fas fa-circle fa-stack-2x text-primary"></i>
                            <i class="fas fa-laptop fa-stack-1x fa-inverse"></i>
                        </span>
                        <h4 class="my-3">Multiplataforma</h4>
                        <p class="text-muted">Consulte sua compra na web por qualquer dispositivo. Celular, Tablet ou Computador!</p>
                    </div>
                    <div class="col-md-4">
                        <span class="fa-stack fa-4x">
                            <i class="fas fa-circle fa-stack-2x text-primary"></i>
                            <i class="fas fa-lock fa-stack-1x fa-inverse"></i>
                        </span>
                        <h4 class="my-3">Compra Segura</h4>
                        <p class="text-muted">Compra segura e em parceiros confiaveis. Caso n�o receba o produto o reembolso imediato!</p>
                    </div>
                </div>
            </div>
        </section>
    
        <!-- Footer-->
        <footer class="footer py-4">
            <div class="container">
                <div class="row align-items-center">
                    <div class="col-lg-4 text-lg-left">Copyright ShoppingCommerce 2021</div>
                    <div class="col-lg-4 my-3 my-lg-0">
                        <a class="btn btn-dark btn-social mx-2" href="#!"><i class="fab fa-twitter"></i></a>
                        <a class="btn btn-dark btn-social mx-2" href="#!"><i class="fab fa-facebook-f"></i></a>
                        <a class="btn btn-dark btn-social mx-2" href="#!"><i class="fab fa-linkedin-in"></i></a>
                    </div>
                    <div class="col-lg-4 text-lg-right">
                        <a class="mr-3" href="#!">Privacy Policy</a>
                        <a href="#!">Terms of Use</a>
                    </div>
                </div>
            </div>
        </footer>
        <!-- Bootstrap core JS-->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js"></script>
        <!-- Third party plugin JS-->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.4.1/jquery.easing.min.js"></script>
        <!-- Contact form JS-->
        <script src="assets/mail/jqBootstrapValidation.js"></script>
        <script src="assets/mail/contact_me.js"></script>
        <!-- Core theme JS-->
        <script src="js/scripts.js"></script>
    </body>
</html>
