<%-- 
    Document   : dashboard
    Created on : 2014/01/23, 17:55:01
    Author     : soji_2
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>個別ページ</h1>
        <table>
            <tr>
                <td>名前</td>
                <td>最終更新日</td>
                <td>長さ</td>
                <td>PV</td>
            </tr>
            <tr>
                <td colspan="5">コメント</td>
            </tr>
        </table>
        <form action="" method="post" enctype="multipart/form-data">
            <input type="file" name="source">
            名前：<input type="text" name="dataname">
            ライセンス：
            <input type="radio" name="reserved" checked> All rights reserved
            <input type="radio" name="CC"> Creative Commons
            <input type="radio" name="asaComment"> コメントに記載
            コメント：
            <textarea name="commentText"></textarea>
            <input type="submit" value="追加">
            <input type="reset" value="リセット">
        </form>
        投稿
        プロフィール編集
        設定
    </body>
</html>
