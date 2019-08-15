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
    	Persona per= (Persona)request.getAttribute("person");
    	String action=(String)request.getAttribute("action");
    %>
  </head>

  <body>

    <div class="container">
      <form class="form-signin" id="myForm" name="myForm" action="" method="post">
        <h2 class="form-signin-heading"><%=action%> <%=per.getNombre()+" "+per.getApellido()%></h2>
        <label for="inputId" class="sr-only">Id</label>
        <input name="id" value="<%=per.getId()%>" id="inputId" class="form-control" placeholder="id" required="" autofocus="" type="">
        <label for="inputTipoDoc" class="sr-only">Tipo Documento</label>
        <input name="tipoDoc" value="<%=per.getDocumento().getTipo()%>" id="inputTipoDoc" class="form-control" placeholder="Tipo Documento" required="" autofocus="" type="">
        <label for="inputNroDoc" class="sr-only">Nro Documento</label>
        <input name="nroDoc" value="<%=per.getDocumento().getNro()%>" id="inputNroDoc" class="form-control" placeholder="Nro Documento" required="" autofocus="" type="">
        <label for="inputNombre" class="sr-only">Nombre</label>
        <input name="nombre" value="<%=per.getNombre()%>" id="inputNombre" class="form-control" placeholder="nombre" required="" autofocus="" type="">
        <label for="inputApellido" class="sr-only">Apellido</label>
        <input name="apellido" value="<%=per.getApellido()%>" id="inputApellido" class="form-control" placeholder="apellido" required="" autofocus="" type="">
        <label for="inputEmail" class="sr-only">Email</label>
        <input name="email" value="<%=per.getEmail()%>" id="inputEmail" class="form-control" placeholder="email" required="" autofocus="" type="">

        <div class="custom-control custom-checkbox">
			<input name="habilitado" type="checkbox" class="custom-control-input" id="isHabilitado" <%=per.isHabilitado()?"checked":""%>>
			<label class="custom-control-label" for="isHabilitado"><%=per.isHabilitado()?"Si":"No"%></label>
		</div>

        <label for="inputPassword" class="sr-only">Password</label>
        <input name="password" id="inputPassword" class="form-control" placeholder="password" required="" autofocus="" type="">
        <button class="btn btn-lg " onclick="javascript: submitForm('persona/consulta')">Save</button>
        <button class="btn btn-lg " onclick="javascript: submitForm('persona/alta')">Cancel</button>
      </form>

    </div> <!-- /container -->


    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="style/ie10-viewport-bug-workaround.js"></script>
  

</body></html>