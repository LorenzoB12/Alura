<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/entrada" var="linkServletNovaEmpresa"/>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form action="${linkServletNovaEmpresa }" method="post">
	
		Nome: <input type="text" name="nome"  />
		Data Abertura: <input type="text" name="data"  />
		<input type="hidden" name="acao" value="NovaEmpresa" />
	
		<input class="btn btn-success" type="submit" />
	</form>
	
	<c:import url="logout.jsp"></c:import>

</body>
</html>