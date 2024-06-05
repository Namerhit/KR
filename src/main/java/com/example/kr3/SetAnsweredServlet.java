package com.example.kr3;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.*;
import java.util.*;
import com.example.kr3.Question;
import com.example.kr3.SessionManager;
@WebServlet("/SetAnsweredServlet")
public class SetAnsweredServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int questionNumber = Integer.parseInt(request.getParameter("questionNumber"));
        boolean isAnswered = Boolean.parseBoolean(request.getParameter("answered"));

        HttpSession session = request.getSession();
        List<Question> questions = (List<Question>) session.getAttribute("questions");

        if (questions != null && questionNumber >= 0 && questionNumber < questions.size()) {
            Question question = questions.get(questionNumber);
            question.setAnswered(isAnswered);
        }

        response.sendRedirect("index.jsp");
    }
}
