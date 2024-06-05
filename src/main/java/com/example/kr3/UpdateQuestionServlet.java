package com.example.kr3;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.*;
import java.util.*;
import com.example.kr3.Question;
import com.example.kr3.SessionManager;
@WebServlet("/UpdateQuestionServlet")
public class UpdateQuestionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int questionNumber = Integer.parseInt(request.getParameter("questionNumber"));
        boolean answered = request.getParameter("answered") != null;

        HttpSession session = request.getSession();
        List<Question> questions = (List<Question>) session.getAttribute("questions");
        Question questionToEdit = (Question) session.getAttribute("questionToEdit");

        if (questions != null && questionToEdit == null) {
            for (Question question : questions) {
                if (question.getQuestionNumber() == questionNumber) {
                    question.setAnswered(answered);
                    break;
                }
            }
        }

        response.sendRedirect("index.jsp");
    }
}
