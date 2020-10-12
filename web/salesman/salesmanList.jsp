<%-- 
    Document   : salesmanList
    Created on : 8 Οκτ 2020, 3:02:22 μμ
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List Of Salesman</title>
        <link rel="stylesheet" href="styling/styling.css" />
    </head>
    <body>
        <jsp:include page="../header.jsp"/>
        <section class="container">
            <h2>List Of Salesman</h2>
            <div class="btn-area">
                <a  class="btn" href="${pageContext.request.contextPath}/salesman/createSalesman">Create A New Salesman</a>
            </div>
            <table class="table">
                <thead>
                    <tr>
                        <th>Id</th>
                        <th>Name</th>
                        <th>City</th>
                        <th>Commision</th>
                        <th>Family</th>
                        <th colspan="2">Action</th>
                    </tr>
                </thead>

                <tbody>
                    <c:forEach items="${salesmen}" var="sm">
                        <tr>
                            <td>${sm.scode}</td>
                            <td>${sm.sname}</td>
                            <td>${sm.scity}</td>
                            <td>${sm.scomm}</td>
                            <td class="buttontd"><a class="btn" href="salesman/inspectFamily?id=${sm.scode}">Inspect</a></td>
                            <td class="buttontd"><a class="btn" href="salesman/editSalesman?id=${sm.scode}">Edit</a></td>
                            <td class="buttontd"><a class="btn" href="salesman/deleteSalesman?id=${sm.scode}">Delete</a></td>
                        </tr>
                    </c:forEach>
                </tbody>


            </table>
        </section>
        <jsp:include page="../footer.jsp"/>
    </body>
</html>
