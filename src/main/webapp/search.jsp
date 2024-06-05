<%@ page import="java.util.List" %>
<%@ page import="java.util.Arrays" %>
<%@ page import="com.example.kr3.Question" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Search Page</title>
</head>
<body>
<h1>Search Page</h1>
<form action="AllQuestionsServlet" method="get">
    <input type="submit" value="Show All Questions">
</form>

<form action="SearchServlet" method="post">
    <label for="searchKeywords">Keywords:</label><br>
    <input type="text" id="searchKeywords" name="searchKeywords"><br><br>
    <input type="submit" value="Search">
</form>

<hr>

<a href="index.jsp">Back to Main Page</a>

</body>
</html>
