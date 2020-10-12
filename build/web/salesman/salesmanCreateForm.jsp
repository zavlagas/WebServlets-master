<%-- 
    Document   : salesmanCreateForm
    Created on : 8 Οκτ 2020, 3:14:57 μμ
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create Salesman</title>
        <link rel="stylesheet" href="../styling/styling.css" />
    </head>
    <body>
        <jsp:include page="../header.jsp"/>
        <section class="container">
            <h2>Create Salesman</h2>
            <form class="form" action="${pageContext.request.contextPath}/salesman/createSalesman" method="POST" >
                <label for="slname">Enter Name</label>
                <input id="slname" type="text" name="name"/>
                <label for="slCity">Enter City</label>
                <input id="slCity" type="text" name="city"/>
                <label for="slcomm">Enter Commision</label>
                <input id="slcomm" type="number" name="comm"/>
                <input class="btn" type="submit" value="Submit"/>
            </form>
        </section>
        <jsp:include page="../footer.jsp"/>
    </body>
</html>
