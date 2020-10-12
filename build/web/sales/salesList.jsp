<%-- 
    Document   : salesList
    Created on : 12 Οκτ 2020, 7:17:27 πμ
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="styling/styling.css" />
        <title>List Of Sales</title>
    </head>
    <body>
        <jsp:include page="../header.jsp"/>
        <section class="container">
            <h2>List Of Sales</h2>
            <div class="btn-area">
                <a  class="btn" href="${pageContext.request.contextPath}/sales/create">Make A New Sale</a>
            </div>
            <table class="table">
                <thead>
                    <tr>
                        <th>Id</th>
                        <th>Salesman</th>
                        <th>Customer</th>
                        <th>Product</th>
                        <th>Quantity</th>
                        <th>Total Cost</th>
                        <th>Date</th>
                        <th colspan="2">Action</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${sales}" var="s">
                        <tr>
                            <td>${s.getScode()}</td>
                            <td>${s.getSalesman().getSname()}</td>
                            <td>${s.getCustomer().getCname()}</td>
                            <td>${s.getProduct().getPdescr()}</td>
                            <td>${s.getProductQuantity()}</td>
                            <td>${s.getProductCost()}</td>
                            <td>${s.getDateOfSale()}</td>
                            <td class="buttontd"><a class="btn" href="sales/editSales?id=${s.getScode()}">Edit</a></td>
                            <td class="buttontd"><a class="btn" href="sales/deleteSales?id=${s.getScode()}">Delete</a></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </section>
        <jsp:include page="../footer.jsp"/>
    </body>
</html>
