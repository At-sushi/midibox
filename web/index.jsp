<%-- 
    Document   : index
    Created on : 2014/01/18, 14:55:10
    Author     : soji_2
--%>

<%@page import="com.google.appengine.api.users.UserServiceFactory"%>
<%@page import="com.google.appengine.api.users.UserService"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>仮版ページ</h1>
        <table>
            <tr>
                <td>名前</td>
                <td>投稿者</td>
                <td>最終更新日</td>
                <td>長さ</td>
                <td>PV</td>
            </tr>
            <tr>
                <td colspan="5">コメント</td>
            </tr>
        </table>
        <% if (request.getUserPrincipal() == null) { %>
            <a href="<%= UserServiceFactory.getUserService().createLoginURL(request.getRequestURI()) %>">ログイン</a>
        <% } else { %>
            <a href="dashboard.jsp">ダッシュボード</a>
            <a href="<%= UserServiceFactory.getUserService().createLogoutURL(request.getRequestURI()) %>">ログアウト</a>
        <% } %>
    </body>
</html>
