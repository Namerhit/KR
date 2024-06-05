package com.example.kr3;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.*;
import java.util.*;
import com.example.kr3.Question;
import com.example.kr3.SessionManager;
@WebServlet("/DeleteQuestionServlet")
public class DeleteQuestionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int questionNumber = Integer.parseInt(request.getParameter("questionNumber"));


        HttpSession session = request.getSession();
        List<Question> questions = (List<Question>) session.getAttribute("questions");


        for (Iterator<Question> iterator = questions.iterator(); iterator.hasNext();) {
            Question question = iterator.next();
            if (question.getQuestionNumber() == questionNumber) {
                iterator.remove();
                break;
            }
        }


        response.sendRedirect("index.jsp");
    }
}
