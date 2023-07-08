<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List,br.com.busolli.lorenzo.gerenciador.entidades.Empresa"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Java Standard Taglib</title>
</head>
<body>
	
	Lista de empresas: <br />
	
	<ul>
		<c:forEach items="${empresas}" var="empresa">
			
			<li>
				${empresa.nome } - <fmt:formatDate value="${empresa.dataAbertura }" pattern="dd/MM/yyyy"/> 
				<a href="/gerenciador/entrada?acao=MostraEmpresa&id=${empresa.id }" class="link-success">edita</a>
				<a href="/gerenciador/entrada?acao=RemoveEmpresa&id=${empresa.id }" class="link-success">remove</a>
			</li>
		</c:forEach>
	</ul>
	<a href="/gerenciador/entrada?acao=NovaEmpresaForm" class="link-success">adiciona outra empresa</a>
	
	<c:import url="logout.jsp"></c:import>
</body>
</html>



