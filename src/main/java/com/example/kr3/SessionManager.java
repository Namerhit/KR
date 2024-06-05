// SessionManager.java
package com.example.kr3;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.util.*;
import com.example.kr3.Question;
public class SessionManager {
    public static List<Question> getQuestions(HttpServletRequest request) {
        HttpSession session = request.getSession();
        List<Question> questions = (List<Question>) session.getAttribute("questions");

        if (questions == null) {
            questions = new ArrayList<>();
            session.setAttribute("questions", questions);
        }

        return questions;
    }
}
