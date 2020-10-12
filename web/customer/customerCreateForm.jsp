<%-- 
    Document   : customerCreateForm
    Created on : 10 Οκτ 2020, 8:39:27 μμ
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create Customer</title>
        <link rel="stylesheet" href="../styling/styling.css" />
    </head>
    <body>
        <jsp:include page="../header.jsp"/>
        <section class="container">
            <h2>Create Customer</h2>
            <form class="form" action="${pageContext.request.contextPath}/customer/create" method="POST">
                <label for="cname">Enter Name</label>
                <input id="cname" type="text" name="name"/>
                <input class="btn" type="submit" value="Submit"/>
            </form>
        </section>

        <jsp:include page="../footer.jsp"/>
    </body>
</html>
