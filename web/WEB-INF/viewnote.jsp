<%-- 
    Document   : viewnote
    Created on : Sep 18, 2019, 8:24:39 PM
    Author     : 784564
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
   <body>
    <form action="note" method="get">
        <div>
           <h1>Simple Note Keeper</h1>
            <h2>View Note</h2>
           
            <h3><b>Title:</b></h3>${ReadNote.title}
            <br>
            <h3><b>Contents:</b></h3>${ReadNote.contents}
            <h3>Contents go here</h3>
            <br>
            
           
        </div>
        <a href="/note?edit">Edit</a>
    </form>
</body>
</html>
