package com.assignportal.subscription.exception;

import model.exception.AlreadyRegisteredToCourse;
import model.exception.CourseNotActive;
import model.exception.CourseNotExists;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

@ControllerAdvice
public class ControlAdvisor extends ResponseEntityExceptionHandler {

    @ExceptionHandler(CourseNotActive.class)
    public ResponseEntity<Object> handleCourseNotActive(
            CourseNotActive courseNotActive, WebRequest request){
        Map<String,Object> body=new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("message", courseNotActive.getMessage());

        return new ResponseEntity<>(body, HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler(CourseNotExists.class)
    public ResponseEntity<Object> handleCourseNotExists(
            CourseNotExists courseNotExists, WebRequest request){
        Map<String,Object> body=new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("message", courseNotExists.getMessage());

        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(AlreadyRegisteredToCourse.class)
    public ResponseEntity<Object> handleAlreadyRegisteredToCourse(
            AlreadyRegisteredToCourse alreadyRegisteredToCourse,WebRequest webRequest){
        Map<String,Object> body=new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("message", alreadyRegisteredToCourse.getMessage());

        return new ResponseEntity<>(body, HttpStatus.NOT_ACCEPTABLE);
    }
}
