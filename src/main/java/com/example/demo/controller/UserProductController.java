package com.example.demo.controller;

import com.example.demo.exceptions.DuplicateProductUserException;
import com.example.demo.model.UserProduct;
import com.example.demo.model.UserProductDto;
import com.example.demo.service.up.UserProductService;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.validation.Valid;

@RestController
@RequestMapping("/userProduct")
public class UserProductController {

    private static final Logger LOGGER = LogManager.getLogger(UserProductController.class);
    @Autowired
    UserProductService userProductService;

    @PostMapping("/defineCommission")
    public ResponseEntity defineCommission(@RequestBody  UserProductDto userProductDto) {
        LOGGER.info("Start defineCommission method {}");
        ResponseEntity responseEntity;
        try {
            responseEntity = new ResponseEntity<UserProductDto>(userProductService.defineCommission(userProductDto), HttpStatus.OK);
        } catch (DuplicateProductUserException e) {
            responseEntity = new ResponseEntity<String>("Your userId and ProductId are duplicate !!!", HttpStatus.BAD_REQUEST);
        }

        return responseEntity;
    }
}
