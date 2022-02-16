
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Average Calculator</title>
    </head>
    <body>
        <h1>Average Calculator</h1>
        
        <form action="average" method="get">
            <label>Enter a Number:</label>
            <input type="number" name="number">
            <br>
            <input type="submit" value="Average Numbers">
        </form>
        
        
        <form action="average" method="get">
            <input type="submit" value="Reset">
            <input type="hidden" name="operation" value="reset">
        </form>
        
        <p><b>Average:</b> ${average}</p>
        
        
    </body>
</html>
