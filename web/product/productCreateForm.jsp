<%-- 
    Document   : productCreateForm
    Created on : 7 Οκτ 2020, 8:44:38 μμ
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Product Form</title>
        <link rel="stylesheet" href="../styling/styling.css" />
    </head>
    <body>
        <%@include file="../header.jsp" %>
        <section class="container">
            <h2>Create A New Product </h2>
            <form class="form"action="${pageContext.request.contextPath}/product/create" method="POST">
                <label for="pdes">Description</label>
                <input id="pdes" type="text" name="description" /><br>
                <label for="ppric">Price</label>
                <input id="ppric" type="number" name="price" /><br>
                <input class="btn" type="submit" value="Submit" />
            </form>
        </section>


        <jsp:include page="../footer.jsp"/>
    </body>
</html>
