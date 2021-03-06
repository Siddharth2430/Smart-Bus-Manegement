<!DOCTYPE html>
<html lang="en">
<head>
	<title>SBManageSVVV Registration</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
<!--===============================================================================================-->
	<link rel="icon" type="image/png" href="images/icons/favicon.ico"/>
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/bootstrap/css/bootstrap.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="fonts/iconic/css/material-design-iconic-font.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/animate/animate.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/css-hamburgers/hamburgers.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/animsition/css/animsition.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/select2/select2.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/daterangepicker/daterangepicker.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="css/util.css">
	<link rel="stylesheet" type="text/css" href="css/main.css">
<!--===============================================================================================-->
</head>
<body>
    <% session.setAttribute("caller","book_cancle.jsp"); %>

	<div class="container-contact100">
		<div class="wrap-contact100">
                    <form class="contact100-form validate-form" method="post" action="Cancel">
				<span class="contact100-form-title">
					<%= session.getAttribute("name") %>
				</span>

                                        <div>  <span><label class="label-input100" ><b>Route:</b> <%= session.getAttribute("route") %><b><br>Stop:</b> <%= session.getAttribute("stop") %></span></div>
                                        
                                        
                                        
                                        
				
                                        	
               	
                       
                                         <div class="container-contact100-form-btn1">
                                   
                                               <button class="contact100-form-btn1" formaction="Book">
						<span>
							Book
							<i class="zmdi zmdi-arrow-right m-l-8"></i>
						</span>
					</button>
                                  <% out.println("");%>
                                                 </div>
                                                 <div><br></div>
                                              <div class="container-contact100-form-btn1">
                                   
		<button class="contact100-form-btn1">
		<span>
		Cancel
		<i class="zmdi zmdi-arrow-right m-l-8"></i>
		</span>
		</button>
                                  
                                                       </div>
                     
                 
                                   
                                         <label class="label-input100" >
					<center>
					<br>
					<br>
					<br>
					<A HREF="javascript:javascript:history.go(-1)"><u>Back</u></A>
					
					</center>
				</label>
								
                        
				
			</form>
		</div>
	</div>



<!--===============================================================================================-->
	<script src="vendor/jquery/jquery-3.2.1.min.js"></script>
<!--===============================================================================================-->
	<script src="vendor/animsition/js/animsition.min.js"></script>
<!--===============================================================================================-->
	<script src="vendor/bootstrap/js/popper.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.min.js"></script>
<!--===============================================================================================-->
	<script src="vendor/select2/select2.min.js"></script>
<!--===============================================================================================-->
	<script src="vendor/daterangepicker/moment.min.js"></script>
	<script src="vendor/daterangepicker/daterangepicker.js"></script>
<!--===============================================================================================-->
	<script src="vendor/countdowntime/countdowntime.js"></script>
<!--===============================================================================================-->
	<script src="js/main.js"></script>


<!-- Global site tag (gtag.js) - Google Analytics -->
<script async src="https://www.googletagmanager.com/gtag/js?id=UA-23581568-13"></script>
<script>
  window.dataLayer = window.dataLayer || [];
  function gtag(){dataLayer.push(arguments);}
  gtag('js', new Date());

  gtag('config', 'UA-23581568-13');
</script>

</body>
</html>
