package com.example.assignment.controller;

import com.example.assignment.model.CustomError;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppErrorController implements ErrorController {

    private static final String PATH = "/error";

    @RequestMapping(value = PATH)
    public ResponseEntity error() {
        return new ResponseEntity(new CustomError("Error","Something goes wrong"), HttpStatus.BAD_REQUEST) ;
    }


}



