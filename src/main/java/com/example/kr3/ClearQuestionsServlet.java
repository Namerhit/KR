package com.example.kr3;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.*;
import java.util.*;
import com.example.kr3.Question;
import com.example.kr3.SessionManager;
@WebServlet("/ClearQuestionsServlet")
public class ClearQuestionsServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Question> allQuestions = new ArrayList<>();
        request.setAttribute("allQuestions", allQuestions);

        response.sendRedirect("searchResults.jsp");
    }
}
