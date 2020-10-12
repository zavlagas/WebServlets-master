<%-- 
    Document   : customerEditForm
    Created on : 10 Οκτ 2020, 8:39:09 μμ
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="../styling/styling.css" />
        <title>Edit Customer</title>
    </head>
    <body>
        <%@include file="../header.jsp" %>
        <section class="container">
            <h2>Create Customer</h2>
            <form class="form" action="${pageContext.request.contextPath}/customer/editCustomer" method="POST">
                <label for="customerid">Id</label>
                <input id="customerid" type="number" value="${customer.ccode}" readonly name="id"/>
                <label for="cname">Name</label>
                <input id="cname" type="text" value="${customer.cname}"name="name"/>
                <input class="btn" type="submit" value="Submit"/>
            </form>
        </section>
        <jsp:include page="../footer.jsp"/>
    </body>
</html>
