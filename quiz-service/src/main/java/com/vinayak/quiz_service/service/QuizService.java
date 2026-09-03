package com.vinayak.quiz_service.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

// import org.apache.catalina.connector.Response;
import com.vinayak.quiz_service.dao.QuizDao;
import com.vinayak.quiz_service.feign.QuizInterface;
import com.vinayak.quiz_service.model.QuestionWrapper;
import com.vinayak.quiz_service.model.Quiz;
import com.vinayak.quiz_service.model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public class QuizService {

    @Autowired
     QuizDao quizDao;

    @Autowired
        QuizInterface quizInterface;


    public ResponseEntity<String> createQuiz(String category, int numQ, String title) {

        List<Integer> questions =quizInterface.getQuestionsForQuiz(category,numQ).getBody();
        Quiz quiz   = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestionIds(questions);
        quizDao.save(quiz);

        return new ResponseEntity<>("Quiz Created Successfully", HttpStatus.CREATED);
    }

    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id) {
          Quiz quiz = quizDao.findById(id).get();
            List<Integer> questionIds =quiz.getQuestionIds();
            quizInterface.getQuestionFromID(questionIds);
            ResponseEntity<List<QuestionWrapper>>questions = quizInterface.getQuestionFromID(questionIds);
       return questions;

    }

    public ResponseEntity<Integer> calculateResult(Integer id, List<Response> responses) {
     ResponseEntity<Integer> score =quizInterface.getScore(responses);
        return score;
    
    }
}