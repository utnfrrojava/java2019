<!DOCTYPE html>
<%@page import="java.util.ArrayList"%>
<%@page import="entities.Persona"%>
<html lang="en"><head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="http://getbootstrap.com/favicon.ico">

    <title>Java Web Intro</title>

    <!-- Bootstrap core CSS -->
    <link href="style/bootstrap.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="style/start.css" rel="stylesheet">

    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
    <script src="style/ie-emulation-modes-warning.js"></script>

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
    <script type="text/javascript">
    	function submitForm(met) {
    		document.myForm.action=met;
    		//document.getElementById("myFrom").submit();
        }
    </script>
    <% 
    	Persona p= (Persona)session.getAttribute("usuario");
    	ArrayList<Persona> lp=(ArrayList<Persona>)request.getAttribute("listaPersonas");
    %>
  </head>

  <body>

    <div class="container">
      <form class="form-signin" id="myForm" name="myForm" action="" method="post">
        <h2 class="form-signin-heading">Hola <%=p.getNombre()+" "+p.getApellido()%></h2>
        <label for="inputEmail" class="sr-only">User</label>
        <input email="email" id="inputEmail" class="form-control" placeholder="email" required="" autofocus="" type="">
        <label for="inputUsername" class="sr-only">User</label>
        <input name="username" id="inputUsername" class="form-control" placeholder="userame" required="" autofocus="" type="">
        <label for="inputPassword" class="sr-only">User</label>
        <input name="password" id="inputPassword" class="form-control" placeholder="password" required="" autofocus="" type="">
        <button class="btn btn-lg " onclick="javascript: submitForm('persona/consulta')">Search</button>
        <button class="btn btn-lg " onclick="javascript: submitForm('persona/alta')">New</button>
        <button class="btn btn-lg " onclick="javascript: submitForm('persona/modificacion')">Edit</button>
        <button class="btn btn-lg " onclick="javascript: submitForm('persona/baja')">Delete</button>
      </form>
      <div class="row">
		 <h4>Personas</h4>
		  <div class="col-12 col-sm-12 col-lg-12">
		   <div class="table-responsive">
		    <table class="table">
		     <thead>
		      <tr>
		        <th>id</th>
		        <th>nombre</th>
		        <th>apellido</th>
		        <th>email</th>
		        <th>tel</th>
		        <th>habilitado</th>
		        <th></th>
		        <th></th>
		      </tr>
		    </thead>
		    <tbody>
		    <% for (Persona per : lp) {%>
		      <tr>
		        <td><%=per.getId()%></td>
		        <td><%=per.getNombre()%></td>
		        <td><%=per.getApellido()%></td>
		        <td><%=per.getEmail()%></td>
		        <td><%=per.getTel()%></td>
		        <td>
		        <div class="custom-control custom-checkbox">
  					<input type="checkbox" class="custom-control-input" id="defaultDisabled" <%=per.isHabilitado()?"checked":""%> disabled>
  					<label class="custom-control-label" for="defaultDisabled"><%=per.isHabilitado()?"Si":"No"%></label>
				</div>
				</td>
				<td><a href="personas/modificacion?id=<%=per.getId()%>">Editar</a></td>
				<td><a href="personas/baja?id=<%=per.getId()%>">Borrar</a></td>
		      </tr>
		      <%} %>
		    </tbody>
		  </table>
		  </div>
	    </div><!-- end col-12 -->
	  </div><!-- end row -->

    </div> <!-- /container -->


    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="style/ie10-viewport-bug-workaround.js"></script>
  

</body></html>