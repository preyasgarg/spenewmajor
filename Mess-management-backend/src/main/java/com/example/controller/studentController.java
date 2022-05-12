package com.example.controller;

import com.example.model.Countplates;
import com.example.model.Instruction;
import com.example.model.Messtime;
import com.example.service.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
public class studentController {
    private static final Logger logger = LogManager.getLogger(foodcomController.class);
    @Autowired
    private TimeService timeService;

    @Autowired
    private InstructionService instructionService;

    @Autowired
    private MenuService menuService;

    @Autowired
    private CountplateService countplateservice;

    @Autowired
    private RateService rateService;


    @GetMapping("/getMesstime")
    public ResponseEntity<?> getMesstime(){
        logger.info("[" + HttpStatus.OK + "]");
        return ResponseEntity.ok(timeService.fetchTime());
    }

    @GetMapping("/getInstruction/{id}")
    public ResponseEntity<?> getInstruction(@PathVariable("id") Integer id){
        logger.info("[" + HttpStatus.OK + "]");
        return ResponseEntity.ok(instructionService.fetchInstruction(id));
    }


    @GetMapping("/getmenu/{day}")
    public ResponseEntity<?> getMenubyday(@PathVariable("day") String day){
        logger.info("[" + HttpStatus.OK + "]");
        return ResponseEntity.ok(menuService.getMenubyday(day));
    }

    @GetMapping("/history/{id}")
    public ResponseEntity<?> getHistory(@PathVariable("id") Integer id){
        logger.info("[" + HttpStatus.OK + "]");
        return ResponseEntity.ok(countplateservice.getPlatehistory(id));
    }

   // requestmapping used when we r sending more than 1 column hv to save
    @PostMapping("/postplatecount")
    public ResponseEntity<?> postPlatecount(@RequestBody Countplates countplates){
        logger.info("[" + HttpStatus.OK + "]");
        return ResponseEntity.ok(countplateservice.postPlate(countplates));
    }
    @PostMapping("/postrating")
    public ResponseEntity<?> postuserRating(@RequestBody Countplates countplates){
        logger.info("[" + HttpStatus.OK + "]");
        return ResponseEntity.ok(rateService.postRating(countplates));
    }



}
