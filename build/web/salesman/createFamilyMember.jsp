<%-- 
    Document   : createFamilyMember
    Created on : 11 Οκτ 2020, 4:57:27 μμ
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create Family Member</title>
        <link rel="stylesheet" href="../styling/styling.css" />
    </head>
    <body>
        <jsp:include page="../header.jsp"/>
        <section class="container">
            <h2>Create Salesman</h2>
            <form class="form" action="${pageContext.request.contextPath}/salesman/createSalesmanFamily" method="POST" >
                <input type="hidden" name="id" value="${salesmanId}"/>
                <label for="fname">Enter Name</label>
                <input id="fname" type="text" name="name"/>
                <label for="relation">Enter Relationship</label>
                <input id="relation" type="text" name="relation"/>
                <label for="dob">Enter Date Of Birth</label>
                <input id="dob" type="date" name="dob"/>
                <input class="btn" type="submit" value="Submit"/>
            </form>
        </section>
        <jsp:include page="../footer.jsp"/>
    </body>
</html>
