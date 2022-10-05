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
<title>MVC - Lista</title>
</head>
<header>
	<img src="imgs/google-contacts.png" class="logo">
	<p class="logoText">Seus contatos</p>
	
	<a href="main" class = "headerMenu">Contatos</a>
	<a href="lixeiraP" class = "headerMenu">Lixeira</a> 
	<a href="index.html" style="position: absolute; right: 5%; top: 3%; font-weight: bold;" class = "headerMenu">Sair</a>
</header>
<body>
	<section style="margin-top: 5%">
		<a href="novo.html" class="novoC"><img src="imgs/add.png" class="imgButtonC"> Criar contato</a>
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
						href="select?idcon=<%=lista.get(i).getIdcontatos_ctt()%>" title="Editar contato"><img
							src="imgs/edit.png" class="imgButton"></a> <a
						href="javascript: alertDelLix(<%=lista.get(i).getIdcontatos_ctt()%>,'<%=lista.get(i).getNome_ctt()%>')" title="Enviar para Lixeira"><img
							src="imgs/delete.png" class="imgButton"></a></td>
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