<%-- 
    Document   : salesEditForm
    Created on : 12 Οκτ 2020, 5:21:45 μμ
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="../styling/styling.css" />
        <title>Edit Sale</title>
    </head>
    <body>
        <jsp:include page="../header.jsp"/>
        <section class="container">
            <h2>Edit Sale </h2>
            <form class="form"action="${pageContext.request.contextPath}/sales/editSales" method="POST">
                <label for="sm">Salesman</label>
                <input type="text" value=""
                <label for="cu">Select Customer</label>
                <select id="cu" name="customer">
                    <c:forEach items="${sessionScope.customers}" var="c">
                        <option value="${c.ccode}">${c.cname}</option>
                    </c:forEach>             
                </select>
                <label for="pro">Select Product</label>
                <select id="pro" name="product">
                    <c:forEach items="${sessionScope.products}" var="p">
                        <option value="${p.pcode}">${p.pdescr}</option>
                    </c:forEach>             
                </select>
                <label for="quant">Select Quantity</label>
                <input name="quantity" id="quant" type="number"/>
                <label for="cost">Cost</label>
                <input name="cost" id="cost" type="number"/>
                <label for="date">Date</label>                  
                <input name="date" id="date" type="date" value="${LocalDate.now()}"/>
                <input class="btn" type="submit" value="Submit" />
            </form>
        </section>
        <jsp:include page="../footer.jsp"/>

    </body>
</html>