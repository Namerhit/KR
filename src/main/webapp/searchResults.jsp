<%@ page import="java.util.List" %>
<%@ page import="com.example.kr3.Question" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Search Results</title>
    <style>
        .question {
            border: 1px solid #ccc;
            padding: 10px;
            margin-bottom: 20px;
        }
    </style>
</head>
<body>
<h1>Search Results</h1>

<%
    List<Question> matchingQuestions = (List<Question>) request.getAttribute("matchingQuestions");
    if (matchingQuestions != null && !matchingQuestions.isEmpty()) {
        for (Question question : matchingQuestions) {
%>
<div class="question">
    <p><strong>Question:</strong> <%= question.getQuestionText() %></p>
    <p><strong>Keywords:</strong> <%= String.join(", ", question.getKeywords()) %></p>
</div>
<%
    }
} else {
%>
<p>No matching questions found.</p>
<%
    }
%>

<form action="AllQuestionsServlet" method="get">
    <input type="submit" value="Show All Questions">
</form>

<form action="ClearQuestionsServlet" method="post">
    <input type="submit" value="Clear All Questions">
</form>

<a href="index.jsp">Back to Main Page</a>

</body>
</html>
