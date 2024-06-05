<%@ page import="java.util.List" %>
<%@ page import="com.example.kr3.Question" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>All Questions</title>
    <style>
        .question {
            border: 1px solid #ccc;
            padding: 10px;
            margin-bottom: 20px;
        }
    </style>
</head>
<body>
<h1>All Questions</h1>

<%
    List<Question> allQuestions = (List<Question>) request.getAttribute("allQuestions");
    if (allQuestions != null && !allQuestions.isEmpty()) {
        for (Question question : allQuestions) {
%>
<div class="question">
    <p><strong>Question:</strong> <%= question.getQuestionText() %></p>
    <p><strong>Keywords:</strong> <%= String.join(", ", question.getKeywords()) %></p>
</div>
<%
    }
} else {
%>
<p>No questions found.</p>
<%
    }
%>

<a href="index.jsp">Back to Main Page</a>

</body>
</html>
