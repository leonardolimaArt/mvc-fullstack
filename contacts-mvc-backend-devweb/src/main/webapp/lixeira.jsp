<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="model.JavaBeans"%>
<%@ page import="java.util.ArrayList"%>

<%
ArrayList<JavaBeans> lista = (ArrayList<JavaBeans>) request.getAttribute("contatos");
%>


<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<link rel="icon" href="imgs/favicon.ico">
<link rel="stylesheet" href="style.css">
<title>MVC - Lixeira</title>
</head>
<header>
	<img src="imgs/google-contacts.png" class="logo">
	<p class="logoText">Minha lixeira</p>
	
	<a href="main" class = "headerMenu">Contatos</a>
	<a href="lixeiraP" class = "headerMenu">Lixeira</a>  
	<a href="index.html" style="position: absolute; right: 5%; top: 3%; font-weight: bold;" class = "headerMenu">Sair</a>
</header>
<body>
	<section style="margin-top: 5%">
		<a href="javascript: alertDelAll()" class="novoC"><img src="imgs/delall.png" class="imgButtonC"> Excluir tudo</a>

		<table id="tabela">
			<thead>
				<tr>
					<th>Nome</th>
					<th>Fone</th>
					<th>E-mail</th>
					<th>Opções</th>
				</tr>
			</thead>
			<tbody>
				<%
				for (int i = 0; i < lista.size(); i++) {
				%>
				<tr>
					<td><%=lista.get(i).getNome_ctt()%></td>
					<td><%=lista.get(i).getFone_ctt()%></td>
					<td><%=lista.get(i).getEmail_ctt()%></td>
					<td style="width: 250px;"><a
						href="restaurar?idcon=<%=lista.get(i).getIdcontatos_ctt()%>"><img
							src="imgs/return.png" class="imgButton" title="Restaurar"></a> <a
						href="javascript: alertDelDef(<%=lista.get(i).getIdcontatos_ctt()%>,'<%=lista.get(i).getNome_ctt()%>')" title="Excluir definitivamente"><img
							src="imgs/delperm.png" class="imgButton"></a></td>
				</tr>
				<%
				}
				%>
			</tbody>
		</table>
	</section>
	<script src="scripts/master_script.js"></script>
</body>
</html>