<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<link rel="icon" href="imgs/favicon.ico">
<link rel="stylesheet" href="style.css">
<title>MVC - Editar</title>
</head>
<header>
	<img src="imgs/google-contacts.png" class="logo">
	<p class="logoText">Editar contato</p>
	
	<a href="main" class = "headerMenu">Contatos</a>
	<a href="lixeiraP" class = "headerMenu">Lixeira</a> 
	<a href="index.html" style="position: absolute; right: 5%; top: 3%; font-weight: bold;" class = "headerMenu">Sair</a>
</header>
<body>
	<h1>Editar contato: <%out.print(request.getAttribute("nome"));%></h1>
	<form action="update">
		<table class = "tableLogin">
			<tr>
				<td><input type="text" style = "display: none" name="idcon" readonly value="<%out.print(request.getAttribute("idcon"));%>"></td>
			</tr>
			<tr>
				<td><input type="text" name="nome" class="camp0" value="<%out.print(request.getAttribute("nome"));%>" required></td>
			</tr>
			<tr>
				<td><input type="text" name="fone" class="camp0" maxlength="11" value="<%out.print(request.getAttribute("fone"));%>" required></td>
			</tr>
			<tr>
				<td><input type="text" name="email" class="camp0" value="<%out.print(request.getAttribute("email"));%>"></td>
			</tr>
		</table>
		<input type="submit" class="login" style="width: 100px" value="Salvar">
	</form>
	<script src = "scripts/master_script.js"></script>
</body>
</html>