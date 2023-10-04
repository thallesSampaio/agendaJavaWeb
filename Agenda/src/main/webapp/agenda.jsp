<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="Model.JavaBeans"%>
<%@ page import="java.util.ArrayList"%>
<%
ArrayList<JavaBeans> lista = (ArrayList<JavaBeans>) request.getAttribute("contatos");
%>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
<meta charset="UTF-8">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
	crossorigin="anonymous">
<title>Agenda de Contatos</title>
<link rel="icon" href="imgs/favIcon.png">
</head>
<body>
	<div style="width: 60%;" class="container-sm">
		<h1>Agenda de Contatos</h1>
		<a href="novo.html">
			<button type="button" class="btn btn-primary">Novo Contato</button>
		</a>
		<table style="margin-top: 20px;" class="table table-hover">
			<thead class="table table-primary">
				<tr>
					<th>ID</th>
					<th>Nome</th>
					<th>Telefone</th>
					<th>Email</th>
					<th>Editar</th>
					<th>Excluir</th>
				</tr>
			</thead>
			<tbody>
				<%
				for (JavaBeans jb : lista) {
				%>
				<tr>
					<td><%=jb.getContato_id()%></td>
					<td><%=jb.getNome()%></td>
					<td><%=jb.getTelefone()%></td>
					<td><%=jb.getEmail()%></td>
					<td class="row"><a
						href="select?contato_id=<%=jb.getContato_id()%>"
						class="btn btn-primary">Editar</a></td>
					<td><a href="javascript: confirmar(<%=jb.getContato_id()%>)"
						class="btn btn-danger">Excluir</a></td>
				</tr>
				<%
				}
				%>

			</tbody>
		</table>
	</div>
	<script src="scripts/confirmador.js"></script>
</body>
</html>