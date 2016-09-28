<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../favicon.ico">
 <script type="text/javascript" src="http://code.jquery.com/jquery-2.1.1.min.js"></script>
    <title>Control Panel</title>

    <!-- Bootstrap core CSS -->
    <link href="resources/css/bootstrap.min.css" rel="stylesheet">
     <link href="resources/css/datapicker/bootstrap-datepicker.standalone.min.css" rel="stylesheet">

    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <link href="resources/css/ie10-viewport-bug-workaround.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="resources/css/starter-template.css" rel="stylesheet">

    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
    <script src="resources/js/ie-emulation-modes-warning.js"></script>
	 <script src="resources/js/bootstrap-datepicker.ru.min.js"></script>
	  <script src="resources/js/bootstrap-datepicker.min.js"></script>
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
    
   
  

    
    
    <style type="text/css">
     /*  html, body { height: 100%; margin: 0; padding: 0; } */
      #map { height: 85%;}
    </style>
    
  </head>

  <body>

  
            <!------------------------code---------------start---------------->
            <nav class="navbar navbar-default navbar-fixed-top">
                <div class="container-fluid">
                    <!-- Brand and toggle get grouped for better mobile display -->
                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle navbar-toggle-sidebar collapsed">
                            MENU
                        </button>
                        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                            <span class="sr-only">Toggle navigation</span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button>
                        <a class="navbar-brand" href="#">
				name@name.com <%-- <%= request.getAttribute("markers").toString() %> --%>
			</a>
                    </div>

                    <!-- Collect the nav links, forms, and other content for toggling -->
                    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                      <!--   <form class="navbar-form navbar-left" method="GET" role="search">
                            <div class="form-group">
                                <input type="text" name="q" class="form-control" placeholder="Search">
                            </div>
                            <button type="submit" class="btn btn-default"><i class="glyphicon glyphicon-search"></i></button>
                        </form> -->
                        <ul class="nav navbar-nav navbar-right">
                            <li><a href="http://google.com" target="_blank">Logout</a></li>
                           
                        </ul>
                    </div>
                    <!-- /.navbar-collapse -->
                </div>
                <!-- /.container-fluid -->
            </nav>
            
            
            
       
            <div class="container-fluid main-container">
                <div class="col-md-2 sidebar">
                     <div class="row">
                        <!-- uncomment code for absolute positioning tweek see top comment in css -->
                        <div class="absolute-wrapper"> </div>
                        <!-- Menu -->
                        <div class="side-menu">
                            <nav class="navbar navbar-default" role="navigation">
                                <!-- Main Menu -->
                                <div class="side-menu-container">
                                    <ul class="nav nav-tabs nav-stacked">
                                       	<li class="active"><a href="#"><span class="glyphicon glyphicon-pencil"></span> Dashboard</a></li>
                                        <li><a href="#"><span class="glyphicon glyphicon-cloud"></span> Active Link</a></li>
                                        <li><a href="#"><span class="glyphicon glyphicon-menu-hamburger"></span> Link</a></li>
										<li><a href="#"><span class="glyphicon glyphicon-signal"></span> Link</a></li>
										
                                        <!-- Dropdown-->
                                        <li class="panel panel-default" id="dropdown">
                                            <a data-toggle="collapse" href="#dropdown-lvl1">
                                                <span class="glyphicon glyphicon-pencil"></span> My Phones <span class="caret"></span>
                                            </a>

                                            <!-- Dropdown level 1 -->
                                            <div id="dropdown-lvl1" class="panel-collapse collapse">
                                                <div class="panel-body">
                                                    <ul class="nav navbar-nav">
                                                    
                                                       <a href ="#" id="ph">no phone</a>
                                                       <script>
var phones, text, fLen, i;

phones =  <%= request.getAttribute("phones") %>
fLen = phones.length;
text = "<ul>";
for (i = 0; i < fLen; i++) {
    text += "<a href = " + phones[i] + "><li>" + phones[i] + "</li></a>";
}
text += "</ul>";
document.getElementById("ph").innerHTML = text;
</script>
                                                    </ul>
                                                </div>
                                            </div>
                                        </li>

                                        

                                    </ul>
                                </div>
                                <!-- /.navbar-collapse -->
                            </nav>

                        </div>
                    </div>
           <div class="container">
    <div class="row">
        <div class='col-sm-2'> 
		<input class="datepicker" type ="hidden"/>

		<script type="text/javascript"> 
					$(function(){
			$('.datepicker').datepicker(); 
								});
		</script> 
	<div class="input-group date" data-provide="datepicker"> 
	<input type="text" class="form-control"> 
	<div class="input-group-addon"> 
	<span class="glyphicon glyphicon-cloud"></span> 
	</div> 
</div> 


</div>
       
    </div>
</div>
                </div>
                
                
                <div class="col-md-10 content">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            Dashboard
                        </div>
                        <div class="panel-body">
 
	<div id="map" class = "panel panel-default"></div>
    <script type="text/javascript">
    
    function initMap() {
    	  var map = new google.maps.Map(document.getElementById('map'), {
    	    zoom: 10,
    	    center: {lat: -33.9, lng: 151.2}
    	  });

    	  setMarkers(map);
    	}

    	// Data for the markers consisting of a name, a LatLng and a zIndex for the
    	// order in which these markers should display on top of each other.
    	var beaches = <%= request.getAttribute("markers") %> 

    	function setMarkers(map) {
    	  // Adds markers to the map.

    	  // Marker sizes are expressed as a Size of X,Y where the origin of the image
    	  // (0,0) is located in the top left of the image.

    	  // Origins, anchor positions and coordinates of the marker increase in the X
    	  // direction to the right and in the Y direction down.
    	  var image = {
    	    url: 'images/beachflag.png',
    	    // This marker is 20 pixels wide by 32 pixels high.
    	    size: new google.maps.Size(20, 32),
    	    // The origin for this image is (0, 0).
    	    origin: new google.maps.Point(0, 0),
    	    // The anchor for this image is the base of the flagpole at (0, 32).
    	    anchor: new google.maps.Point(0, 32)
    	  };
    	  // Shapes define the clickable region of the icon. The type defines an HTML
    	  // <area> element 'poly' which traces out a polygon as a series of X,Y points.
    	  // The final coordinate closes the poly by connecting to the first coordinate.
    	  var shape = {
    	    coords: [1, 1, 1, 20, 18, 20, 18, 1],
    	    type: 'poly'
    	  };
    	  for (var i = 0; i < beaches.length; i++) {
    	    var beach = beaches[i];
    	    var marker = new google.maps.Marker({
    	      position: {lat: beach[1], lng: beach[2]},
    	      map: map,
    	      //icon: image,
    	      shape: shape,
    	      title: beach[0],
    	      zIndex: beach[3]
    	    });
    	  }
    	}
	</script>
	 <script async defer
      src="https://maps.googleapis.com/maps/api/js?key=AIzaSyD2jLuDuu10-lGeQNulmyBLha6ZO70D81g&callback=initMap">
    </script>

    </div>
    </div>
     </div>
     </div>
     </div>
   <!--  </div>
    </div> -->
    

  
	
	
	

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script>window.jQuery || document.write('<script src="resources/js/vendor/jquery.min.js"><\/script>')</script>
    <script src="resources/js/bootstrap.min.js"></script>
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="resources/js/ie10-viewport-bug-workaround.js"></script>
  </body>
</html>