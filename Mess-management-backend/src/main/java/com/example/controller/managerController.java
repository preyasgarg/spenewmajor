package com.example.controller;

import com.example.service.CountplateService;
import com.example.service.RateService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
public class managerController {

    private static final Logger logger = LogManager.getLogger(foodcomController.class);

    @Autowired
    private CountplateService countplateservice;

    @Autowired
    private RateService rateService;

    @GetMapping("/getCountplates")
    public ResponseEntity<?> getCountplates(){
        logger.info("[" + HttpStatus.OK + "]");
        return ResponseEntity.ok(countplateservice.fetchplatecount());
    }


    @GetMapping("/getRating/{id}")
    public ResponseEntity<?> getRating(@PathVariable("id") Integer id){
        logger.info("[" + HttpStatus.OK + "]");
        return ResponseEntity.ok(rateService.fetchRate(id));
    }


}
