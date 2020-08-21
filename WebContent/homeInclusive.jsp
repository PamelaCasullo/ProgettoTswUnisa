<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Homepage</title>
</head>
<body>

<div class=article-preview>
<div class="container-sm">
  <div class="container left">
        <div class="title">
            <h3 class="mt-5">Articoli</h3>
        </div>
	<!-- CAROSELLO IMMAGINI -->        
        <div class="section" id="carousel">
        <div class="container left">
            <div class="row">
                <div class="col-md-8 mr-auto ml-auto">
<!-- CAROSELLO -->
                    <div class="card card-raised card-carousel">
                        <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel" data-interval="3000">
                          <ol class="carousel-indicators">
                            <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
                            <li data-target="#carouselExampleIndicators" data-slide-to="1" class=""></li>
                            <li data-target="#carouselExampleIndicators" data-slide-to="2" class=""></li>
                          </ol>
                          <div class="carousel-inner">
                            <div class="carousel-item active">
                               <img class="d-block w-100" src="https://media-cdn.tripadvisor.com/media/photo-s/12/28/ef/0f/getlstd-property-photo.jpg" alt="Third slide">
                              <div class="carousel-caption d-none d-md-block">
                                <h4>
                                   <span id="article-preview">
                                   <a href=article1.jsp><button class="btn btn-primary btn-lg"> LA NOSTRA LOBBY!!<br><br>
                                    Unitevi a noi e vivete l'esport a 360 gradi!</button></a> 
                                    </span> 
                                </h4>
                              </div>
                            </div>
                            <div class="carousel-item">
                              <img class="d-block w-100" src="https://esports.thegamesmachine.it/wp-content/uploads/2019/06/6-6-660x330.jpg"  alt="Second slide">
                              <div class="carousel-caption d-none d-md-block">
                                <h4>
                                    <span id="article-preview">
                                    <a href=article2.jsp><button class="btn btn-primary btn-lg">NUOVA STAGIONE E-SPORT PER I MAD DISCORD</button></a>
                                    </span>
                                </h4>
                              </div>
                            </div>
                            <div class="carousel-item">
                            	<img class="d-block w-100" src="https://esportsobserver.com/wp-content/uploads/2018/09/43859811844_acd3b01b76_k-e1536737361509.jpg" alt="First slide">
                              <div class="carousel-caption d-none d-md-block">
                                <h4>
                                    <span id="article-preview">
                                   <a href=article3.jsp><button class="btn btn-primary btn-lg">MOBA E-sports<br><br>
                                    INCREDIBILI PARTITE TI ASPETTANO!</button></a></span>
                                </h4>
                              </div>
                            </div>
                          </div>
                          <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
                            <i class="material-icons"><</i>
                            <span class="sr-only">Previous</span>
                          </a>
                          <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
                            <i class="material-icons"> > </i>
                            <span class="sr-only">Next</span>
                          </a>
                        </div>
                    </div>
                    <!-- FINE CAROSELLO-->

                </div>
            </div>
        </div>
    </div>
    </div>
    </div>
    </div>
</body>
</html>