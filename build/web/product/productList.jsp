<%-- 
    Document   : productList
    Created on : 6 Οκτ 2020, 8:31:07 μμ
    Author     : User
--%>

<%@page import="emergon.entity.Product"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List Of Products</title>
        <link rel="stylesheet" href="styling/styling.css" />
    </head>
    <body>
        <%@include file="../header.jsp" %>
        <section class="container">
            <h2>List Of Products</h2>
            <div class="btn-area">
                <a  class="btn" href="${pageContext.request.contextPath}/product/create">Create a New Product</a> 
            </div>
            <table class="table">
                <thead>
                    <tr>
                        <th>Id</th>
                        <th>Description</th>
                        <th>Price</th>
                        <th colspan="2">Action</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${products}" var="p">
                        <tr>
                            <td>${p.pcode}</td>
                            <td>${p.pdescr}</td>
                            <td>${p.pprice}</td>
                            <td class="buttontd"><a class="btn" href="product/editProduct?id=${p.pcode}">Edit</a>
                            <td class="buttontd"><a class="btn" href="product/deleteProduct?id=${p.pcode}">Delete</a>
                        </tr>
                    </c:forEach>
                </tbody>


            </table>
        </section>
        <jsp:include page="../footer.jsp"/>
    </body>
</html>
