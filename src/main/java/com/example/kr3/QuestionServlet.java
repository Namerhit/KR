package com.example.kr3;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.*;
import java.util.*;
import com.example.kr3.Question;
import com.example.kr3.SessionManager;
@WebServlet("/QuestionServlet")
public class QuestionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String questionText = request.getParameter("questionText");
        String keywords = request.getParameter("keywords");

        HttpSession session = request.getSession();
        List<Question> questions = (List<Question>) session.getAttribute("questions");

        if (questions == null) {
            questions = new ArrayList<>();
            session.setAttribute("questions", questions);
        }

        int nextQuestionNumber = questions.size() + 1;
        Question questionToEdit = (Question) session.getAttribute("questionToEdit");
        if (questionToEdit != null) {
            questionToEdit.setQuestionText(questionText);
            questionToEdit.setKeywords(Arrays.asList(keywords.split(",")));
            session.setAttribute("questionToEdit", questionToEdit);
        } else {
            Question question = new Question(questionText, Arrays.asList(keywords.split(",")));
            questions.add(question);
        }

        response.sendRedirect("index.jsp");
    }
}
