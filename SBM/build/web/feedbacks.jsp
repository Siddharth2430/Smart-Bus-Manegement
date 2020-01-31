<!DOCTYPE html>
<%@ page import="java.sql.*"%>
<%@ page import="javax.swing.JOptionPane"%>
<html lang="en">
<head>
	<title>SBManageSVVV Feedbacks</title>
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


	<div class="container-contact100">
		<div class="wrap-contact100">
			<form class="contact100-form validate-form" method="post" action="Feedback">
				<span class="contact100-form-title">
					Feedback
                                </span>
                                                                                           
					<label class="label-input100" for="message">FeedBacks:</label>
				<div class="body">
                            <div class="table-responsive">
                                <table class="table table-hover dashboard-task-infos">
                                    <thead>
                                        <tr>
                                            
                                            <th>Challan Number</th>
                                            <th>Feed</th>
                                            
                                            
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <%
                                            try {
    java.sql.Connection con;
    Class.forName("com.mysql.jdbc.Driver");
    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/smartbusmanagement", "root", "siddharth");
   //JOptionPane.showMessageDialog(null,"database successfully opened.");
    Statement st=con.createStatement();
    ResultSet rs=st.executeQuery("Select challan,feed from complaint");
 int cnt=0;
    while(rs.next())
  {
      cnt=1;
      
          %>
          <tr>

<td><span class="label bg-green"><%= rs.getString(1)%></span> </td>
<td><span class="label"><%= rs.getString(2)%></span></td>


</tr>
               <%   
                   }
if (cnt==0)
{
JOptionPane.showMessageDialog(null,"No Feedbacks.");
}
}
catch(SQLException e) {
    JOptionPane.showMessageDialog(null,e.getMessage());
  }
          %>                      
                                    </tbody>
                                </table>
                            </div>
                        </div>	
				
				<div class="container-contact100-form-btn">
                                    <button class="contact100-form-btn" formaction="Deletef">
						<span>
							Delete
							<i class="zmdi zmdi-arrow-right m-l-8"></i>
						</span>
					</button>
				</div>
								
				<label class="label-input100" for="message">
					<center>
					<br>
					<br>
					<br>
					<A HREF="javascript:javascript:history.go(-1)">back</A>
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
