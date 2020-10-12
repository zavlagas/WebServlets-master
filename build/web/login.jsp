<%-- 
    Document   : login
    Created on : 8 Οκτ 2020, 8:32:36 μμ
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <link rel="stylesheet" href="styling/styling.css" />
    </head>
    <body>
        <div class="container login">
            <h2>Welcome Please Login</h2>
            <form  class="form"action="${pageContext.request.contextPath}/LoginServlet" method="POST">
                <label for="username">Username:</label>
                <input id="username" type="text" name="username">
                <label for="password">Password:</label>
                <input id="password" type="password" name="password">
                <input class="btn" type="submit" value="Submit">
                <p id="login-msg">${param.message}</p>
            </form>

        </div>
        <jsp:include page="footer.jsp"/>
    </body>
</html>
