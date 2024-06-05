package com.example.kr3;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.*;
import java.util.*;
import com.example.kr3.Question;

@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String searchKeywordsString = request.getParameter("searchKeywords");
        if (searchKeywordsString != null && !searchKeywordsString.isEmpty()) {
            String[] keywordsArray = searchKeywordsString.split("\\s*,\\s*");
            List<String> keywords = Arrays.asList(keywordsArray);

            List<Question> allQuestions = new ArrayList<>();
            allQuestions.add(new Question("Яка роздільна здатність Full HD дисплея?", Arrays.asList("роздільна здатність", "Full HD", "дисплей")));
            allQuestions.add(new Question("Що таке SSD?", Arrays.asList("SSD", "накопичувач", "твердотільний диск")));
            allQuestions.add(new Question("Яка ємність батареї у MacBook Air 2020?", Arrays.asList("батарея", "MacBook Air 2020", "ємність")));
            allQuestions.add(new Question("Що таке HDMI порт?", Arrays.asList("HDMI", "порт", "інтерфейс")));
            allQuestions.add(new Question("Яка об'єм оперативної пам'яті у смартфона Samsung Galaxy S20?", Arrays.asList("оперативна пам'ять", "Samsung Galaxy S20", "об'єм")));
            allQuestions.add(new Question("Що означає термін 'Bluetooth'?", Arrays.asList("Bluetooth", "бездротовий зв'язок", "стандарт")));
            allQuestions.add(new Question("Яка тип матриці використовується у смартфоні iPhone 12 Pro?", Arrays.asList("матриця", "iPhone 12 Pro", "тип")));
            allQuestions.add(new Question("Що таке USB Type-C?", Arrays.asList("USB Type-C", "кабель", "інтерфейс")));
            allQuestions.add(new Question("Яка операційна система встановлена на Chromebook?", Arrays.asList("операційна система", "Chromebook", "встановлена")));
            allQuestions.add(new Question("Який чіп використовується у ноутбуці Dell XPS 15?", Arrays.asList("чіп", "Dell XPS 15", "використовується")));
            allQuestions.add(new Question("Які основні характеристики процесорів Intel та AMD?", Arrays.asList("процесор", "Intel", "AMD")));
            allQuestions.add(new Question("Як підключити вторинний монітор до ноутбука?", Arrays.asList("монітор", "підключення", "ноутбук")));
            allQuestions.add(new Question("Як правильно вибрати операційну пам'ять для ноутбука?", Arrays.asList("операційна пам'ять", "вибір", "ноутбук")));
            allQuestions.add(new Question("Як відновити втрачені дані з жорсткого диска ноутбука?", Arrays.asList("дані", "відновлення", "жорсткий диск", "ноутбук")));
            allQuestions.add(new Question("Як вибрати надійний антивірус для захисту ноутбука?", Arrays.asList("антивірус", "захист", "ноутбук")));
            allQuestions.add(new Question("Як підвищити продуктивність ноутбука без заміни апаратних компонентів?", Arrays.asList("продуктивність", "підвищення", "ноутбук")));
            allQuestions.add(new Question("Як встановити операційну систему Windows на ноутбук з USB-накопичувача?", Arrays.asList("Windows", "установка", "USB", "ноутбук")));
            allQuestions.add(new Question("Як збільшити термін служби акумулятора ноутбука?", Arrays.asList("акумулятор", "термін служби", "ноутбук")));
            allQuestions.add(new Question("Як налаштувати безпроводову мережу на ноутбуці?", Arrays.asList("безпроводова мережа", "налаштування", "ноутбук")));
            allQuestions.add(new Question("Як підключити ноутбук до Wi-Fi мережі?", Arrays.asList("Wi-Fi", "підключення", "ноутбук")));

            List<Question> matchingQuestions = new ArrayList<>();
            for (Question question : allQuestions) {
                if (questionContainsKeywords(question, keywords)) {
                    matchingQuestions.add(question);
                }
            }

            request.setAttribute("matchingQuestions", matchingQuestions);
            RequestDispatcher dispatcher = request.getRequestDispatcher("searchResults.jsp");
            dispatcher.forward(request, response);
        } else {
            response.sendRedirect("searchPage.jsp?error=missingKeywords");
        }
    }


    private boolean questionContainsKeywords(Question question, List<String> keywords) {
        List<String> questionKeywords = question.getKeywords();
        for (String keyword : keywords) {
            if (questionKeywords.contains(keyword)) {
                return true;
            }
        }
        return false;
    }
}

