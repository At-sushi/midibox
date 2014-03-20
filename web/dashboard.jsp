<%-- 
    Document   : dashboard
    Created on : 2014/01/23, 17:55:01
    Author     : soji_2
--%>

<%@page import="java.util.ListIterator"%>
<%@page import="java.util.List"%>
<%@page import="midibox.MidiDataInfo"%>
<%@page import="midibox.PMF"%>
<%@page import="javax.jdo.PersistenceManager"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.google.appengine.api.blobstore.BlobstoreServiceFactory" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>個別ページ</h1>
        <table>
            <%
                PersistenceManager pmf = PMF.get().getPersistenceManager();
                List<MidiDataInfo> midiDataList = (List<MidiDataInfo>)pmf.newQuery(MidiDataInfo.class).execute();
                
                for (MidiDataInfo mdi : midiDataList) {
                    %>
            <tr>
                <td><%= mdi.name %></td>
                <td>最終更新日</td>
                <td>長さ</td>
                <td><a href="/blob?<%= mdi.getBlobKey().getKeyString() %>">PV</a></td>
            </tr>
            <tr>
                <td colspan="5"><% if ( mdi.comment != null) System.out.print(mdi.comment.getValue()); %></td>
            </tr>
            <%
                }
            %>
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
        <form action="<%= BlobstoreServiceFactory.getBlobstoreService().createUploadUrl("/upload") %>" method="post" enctype="multipart/form-data">
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
