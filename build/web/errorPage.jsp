<%-- 
    Document   : errorPage
    Created on : 7 Οκτ 2020, 7:42:01 μμ
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h4>Product could not be Deleted!!!</h4>
        <p>
            <strong>${minima}</strong>
        </p>
        <a href="${pageContext.request.contextPath}/ListProductServlet">Go To Product List </a>
    </body>
</html>
