<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form:form action="PlaceOrder.jsp" modelAttribute="User">
User Id:
<input type="text" name="userid"><br/><br/>
User Name:
<input type="text" name="username"/><br/><br/>
<input type="submit" value="Go"/>
</form:form>
</body>
</html>