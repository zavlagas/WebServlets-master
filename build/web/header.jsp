<%-- 
    Document   : header
    Created on : 8 Οκτ 2020, 8:10:03 μμ
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<header>
    <nav>
        <ul>
            <li id="logo"><a href="/WebServlet/index.jsp">Sales Company</a></li>
            <li id="product-li"><a href="/WebServlet/ListProductServlet">Products</a></li>
            <li id="customer-li"><a href="/WebServlet/ListCustomerServlet">Customers</a></li>
            <li id="salesman-li"><a href="/WebServlet/ListSalesmanServlet">Salesman</a></li>
            <li id="sales-li"><a href="/WebServlet/ListSalesServlet">Sales</a></li>
            <li id="logged-li"><a href="#">User: ${username}</a></li>
            <li id="logout-li"><a href="/WebServlet/LogoutServlet">Logout</a></li>
        </ul>
    </nav>
</header>