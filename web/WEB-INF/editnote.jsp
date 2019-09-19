<%-- 
    Document   : editnote
    Created on : Sep 18, 2019, 8:24:55 PM
    Author     : 784564
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Note App</title>
    </head>
    <body>
        <form action="note" method="post">
        <div>
            <h1>Simple Note Keeper</h1>
            <h2>Edit Note</h2>
           
            <h3><b>Title:</b></h3><input type="text" name="title" value="${ReadNote.title}"><br>
            
            <h3><b>Contents:</b></h3>
            <input type="textbox" name="content" width="48" height="48" value="${ReadNote.contents}">
            
            <br>
            ${result}
        </div>
            <input type="submit" value="Save">
    </form>
    </body>
    
    
</html>
