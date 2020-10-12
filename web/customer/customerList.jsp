<%-- 
    Document   : customerList
    Created on : 10 Οκτ 2020, 8:38:50 μμ
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Customers List</title>
        <link rel="stylesheet" href="styling/styling.css" />
    </head>
    <body>
        <jsp:include page="../header.jsp"/>
        <section class="container">
            <h2>List Of Customers</h2>
            <div class="btn-area">
                <a  class="btn" href="${pageContext.request.contextPath}/customer/create">Create A New Customer</a> 
            </div>
            <table class="table">
                <thead>
                    <tr>
                        <th>Id</th>
                        <th>Name</th>
                        <th colspan="2">Action</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${customers}" var="cu">
                        <tr>
                            <td>${cu.ccode}</td>
                            <td>${cu.cname}</td>
                            <td class="buttontd"><a class="btn" href="customer/editCustomer?id=${cu.ccode}">Edit</a></td>
                            <td class="buttontd"><a class="btn" href="customer/deleteCustomer?id=${cu.ccode}">Delete</a></td>
                        </tr>
                    </c:forEach>
                </tbody>


            </table>
        </section>
        <jsp:include page="../footer.jsp"/>
    </body>
</html>
