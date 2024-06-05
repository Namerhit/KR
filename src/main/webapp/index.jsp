<%@ page import="java.util.List" %>
<%@ page import="java.util.Arrays" %>
<%@ page import="com.example.kr3.Question" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Main Page</title>
    <style>
        .question {
            border: 1px solid #ccc;
            padding: 10px;
            margin-bottom: 10px;
            display: flex;
            align-items: center;
            justify-content: space-between;
        }

        .question-buttons {
            display: flex;
            gap: 10px;
        }

        .question-buttons input[type="submit"] {
            margin-left: auto;
        }

        #editQuestionForm {
            display: none;
            margin-top: 20px;
        }
    </style>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script>
        $(document).ready(function () {
            $(".edit-btn").click(function () {
                var questionNumber = $(this).data("question-number");
                var questionText = $(this).data("question-text");
                var keywords = $(this).data("keywords");

                $("#questionNumber").val(questionNumber);
                $("#editedQuestionText").val(questionText);
                $("#editedKeywords").val(keywords);

                $("#editQuestionForm").show();
            });

            $("#saveEditedQuestionBtn").click(function () {
                var questionNumber = $("#questionNumber").val();
                var editedQuestionText = $("#editedQuestionText").val();
                var editedKeywords = $("#editedKeywords").val();

                $.post("EditQuestionServlet", {
                    questionNumber: questionNumber,
                    editedQuestionText: editedQuestionText,
                    editedKeywords: editedKeywords
                }, function (data, status) {
                    $("#questionText-" + questionNumber).html("<strong>Question " + questionNumber + ":</strong> " + editedQuestionText);
                    $("#keywords-" + questionNumber).html("<strong>Keywords:</strong> " + editedKeywords);

                    $("#editQuestionForm").hide();
                });
            });
        });
    </script>
</head>
<body>
<h1>Main Page</h1>
<a href="search.jsp"><button>Go to Search Page</button></a>




<%
    List<Question> questions = (List<Question>) session.getAttribute("questions");
    if (questions != null && !questions.isEmpty()) {
        for (Question question : questions) {
            String keywords = String.join(", ", question.getKeywords());
%>
<div class="question">
    <p id="questionText-<%= question.getQuestionNumber() %>"><strong>Question <%= question.getQuestionNumber() %>:</strong> <%= question.getQuestionText() %></p>
    <p id="keywords-<%= question.getQuestionNumber() %>"><strong>Keywords:</strong> <%= keywords %></p>
    <form action="DeleteQuestionServlet" method="post">
        <input type="hidden" name="questionNumber" value="<%= question.getQuestionNumber() %>">
        <input class="question-buttons" type="submit" value="Delete">
    </form>
    <form action="UpdateAnswerStateServlet" method="post">
        <input type="hidden" name="questionNumber" value="<%= question.getQuestionNumber() %>">
        <input type="checkbox" name="answered" <% if (question.isAnswered()) { %> checked <% } %>> Answered
        <input class="question-buttons" type="submit" value="Save">
    </form>
    <button class="edit-btn" data-question-number="<%= question.getQuestionNumber() %>" data-question-text="<%= question.getQuestionText() %>" data-keywords="<%= keywords %>">Edit</button>
</div>
<%
        }
    }
%>

<hr>

<h2>Add a New Question:</h2>
<form action="QuestionServlet" method="post">
    <label for="questionText">Question:</label><br>
    <textarea id="questionText" name="questionText" rows="4" cols="50"></textarea><br><br>
    <label for="keywords">Keywords:</label><br>
    <input type="text" id="keywords" name="keywords"><br><br>
    <input type="submit" value="Add Question">
</form>

<div id="editQuestionForm">
    <h2>Edit Question:</h2>
    <form>
        <input type="hidden" id="questionNumber" name="questionNumber">
        <label for="editedQuestionText">Question:</label><br>
        <textarea id="editedQuestionText" name="editedQuestionText" rows="4" cols="50"></textarea><br><br>
        <label for="editedKeywords">Keywords:</label><br>
        <input type="text" id="editedKeywords" name="editedKeywords"><br><br>
        <input type="button" id="saveEditedQuestionBtn" value="Save">
    </form>
</div>

</body>
</html>
