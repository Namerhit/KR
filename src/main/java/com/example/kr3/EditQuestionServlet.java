package com.example.kr3;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.*;
import java.util.*;

@WebServlet("/EditQuestionServlet")
public class EditQuestionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int questionNumber = Integer.parseInt(request.getParameter("questionNumber"));
        String editedQuestionText = request.getParameter("editedQuestionText");
        String editedKeywords = request.getParameter("editedKeywords");

        HttpSession session = request.getSession();
        List<Question> questions = (List<Question>) session.getAttribute("questions");

        if (questions != null && !questions.isEmpty()) {
            for (Question question : questions) {
                if (question.getQuestionNumber() == questionNumber) {
                    // Оновлюємо тексти питання та ключові слова
                    question.setQuestionText(editedQuestionText);
                    // Додаємо квадратні дужки до ключових слів
//                    editedKeywords = addSquareBrackets(editedKeywords);
                    question.setKeywords(Arrays.asList(editedKeywords.split(",")));
                    break;
                }
            }
        }

        response.sendRedirect("index.jsp");
    }

}
