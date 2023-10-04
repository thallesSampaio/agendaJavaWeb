<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="Model.JavaBeans"%>
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
	<div style="width: 500px;" class="container-md">
		<h1 class="title">Editar contatos</h1>
		<form name="frmContato" action="update">
			<table>
				<tr>
					<td><input style="margin-bottom: 10px;" type="text"
						name="contato_id" class="form-control" readonly
						value="<%=request.getAttribute("contato_id")%>"></td>
				</tr>
				<tr>
					<td><input style="margin-bottom: 10px;" type="text"
						name="nome" class="form-control"
						value="<%=request.getAttribute("nome")%>"></td>
				</tr>
				<tr>
					<td><input style="margin-bottom: 10px;" type="text"
						name="telefone" class="form-control"
						value="<%=request.getAttribute("telefone")%>"></td>
				</tr>
				<tr>
					<td><input style="margin-bottom: 10px;" type="email"
						name="email" class="form-control"
						value="<%=request.getAttribute("email")%>"></td>
				</tr>
			</table>
			<input type="button" value="Salvar" class="btn btn-primary"
				onclick="validar()">
		</form>
	</div>
	<script src="scripts/validador.js"></script>
</body>
</html>