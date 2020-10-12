<%-- 
    Document   : salesmanEditForm
    Created on : 11 Οκτ 2020, 12:34:25 πμ
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="../styling/styling.css" />
        <title>Edit Salesman</title>
    </head>
    <body>
        <jsp:include page="../header.jsp"/>
        <section class="container">
            <h2>Create Salesman</h2>
            <form class="form" action="${pageContext.request.contextPath}/salesman/editSalesman" method="POST" >
                <label for="slid">Id</label>
                <input id="slid" type="number" value="${salesman.scode}" name="id" readonly />
                <label for="slname">Enter Name</label>
                <input id="slname" type="text" value="${salesman.sname}" name="name"/>
                <label for="slCity">Enter City</label>
                <input id="slCity" type="text" value="${salesman.scity}" name="city"/>
                <label for="slcomm">Enter Commision</label>
                <input id="slcomm" type="number" value="${salesman.scomm}" name="comm"/>
                <input class="btn" type="submit" value="Submit"/>
            </form>
        </section>
        <jsp:include page="../footer.jsp"/>
    </body>
</html>
