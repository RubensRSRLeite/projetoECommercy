<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags/" prefix="tag" %>
<html lang="pt-br">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>E-Commerce - Form Categoria</title>
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
        <nav class="navbar navbar-expand-lg navbar-dark fixed-top" id="mainNav">
            <div class="container">
                <a class="navbar-brand js-scroll-trigger" href="#page-top"><img src="assets/img/logos/logo.png" alt="Logo" /></a>
                <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
                    Menu
                    <i class="fas fa-bars ml-1"></i>
                </button>
                <div class="collapse navbar-collapse" id="navbarResponsive">
                    <ul class="navbar-nav text-uppercase ml-auto">
                        <li class="nav-item"><a class="nav-link js-scroll-trigger" href="categorias">Categorias</a></li>
                        <li class="nav-item"><a class="nav-link js-scroll-trigger" href="produtos#portfolio">Produtos</a></li>
                        <li class="nav-item"><a class="nav-link js-scroll-trigger" href="login.">Login</a></li>
                        <li class="nav-item"><a class="nav-link js-scroll-trigger" href="cadastrar#cadastrar">Cadastrar-se</a></li>
                    </ul>
                </div>
            </div>
        </nav>
        <!-- Masthead-->
        <header class="masthead" id="login">
            <div class="container">
               
            </div>
        </header>
        <!-- formcategoria-->
        <section class="page-section" id="formcategoria">
            <div class="container">
                <div class="text-center">
                    <h2 class="section-heading text-uppercase">Nova Categoria/Editar Categoria</h2>
                </div>
                
                <c:if test="${not empty errors}">
	                <div class="alert alert-danger" role="alert">
	                	<c:forEach var="error" items="${errors}">
	                	
	                		${error.message}<br/>	
	                		     	
	                	</c:forEach>
	                </div>
                </c:if>
                
                <form method="post" action="<c:url value="/formCategorias/salvaCategoria"/>">
                	<input  type="hidden"  name="categoria.id" value= "${categoria.getId()}">
                	<input type="hidden" name="categoria.ativo" value= "${categoria.isAtivo()}">
                    <div class="row justify-content-md-center mb-5 text-center">
                        <div class="col-md-12 align-self-center text-center">
                            <div class="form-group input-login mx-auto">
                                <input class="form-control" id="email" name="categoria.nomeCategoria" minlength="2" maxlength="100" value="${categoria.getNomeCategoria()}"  type="text" placeholder="Nome *" required="required" data-validation-required-message=" insira nome de categoria de 3 até 100 caracteres" />
                                <p class="help-block text-danger"></p>
                            </div>
                            <button type="submit" class="btn btn-primary btn-xl text-uppercase js-scroll-trigger" >Salvar</button>
                        </div> 
                    </div>
                </form>
            </div>
        </section>
    
        
'
        <footer class="footer py-4">
            <div class="container">
                <div class="row align-items-center">
                    <div class="col-lg-4 text-lg-left">Copyright SenaiCommerce 2021</div>
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
        <script>

        </script>
    </body>
</html>
