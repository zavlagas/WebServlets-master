
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Product</title>
        <link rel="stylesheet" href="../styling/styling.css" />
    </head>
    <body>

            <%@include file="../header.jsp" %>
            <section class="container">
                <h2>Edit Product</h2>
                <form class="form" action="${pageContext.request.contextPath}/product/editProduct" method="POST">
                    <label for="pcode">Code</label>
                    <input id="pcode" type="text" name="pcode" value="${product.pcode}" readonly/><br>
                    <label for="pdescr">Description</label>
                    <input id="pdescr" type="text" name="description" value="${product.pdescr}" /><br>
                    <label for="pprice">Price</label>
                    <input id="pprice" type="number" step="0.01" min="0" name="price" value="${product.pprice}" /><br>
                <input class="btn" type="submit" value="Submit" />
            </form>
                
            </section>
            
            <jsp:include page="../footer.jsp"/>
    </body>
</html>
