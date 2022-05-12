package com.example.controller;

import com.example.model.Foodmenu;
import com.example.model.Instruction;
import com.example.model.Messtime;
import com.example.service.InstructionService;
import com.example.service.MenuService;
import com.example.service.TimeService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
public class foodcomController {

    private static final Logger logger = LogManager.getLogger(foodcomController.class);

    @Autowired
    private TimeService timeService;

    @Autowired
    private InstructionService instructionService;

    @Autowired
    private MenuService menuService;

    @PutMapping("/updateTime/{id}")
    public Messtime updateTime(@RequestBody Messtime messtime, @PathVariable("id") Integer id) {
        Messtime res=timeService.updatemessTime(messtime, id);

        if(res==null)
            logger.info("[" + HttpStatus.NOT_FOUND + "]");
        else
            logger.info("[" + HttpStatus.OK + "]");
        return res;
    }


    @PutMapping("/updateInstruction/{id}")
    public ResponseEntity<?> updateInstruction(@RequestBody Instruction instruction, @PathVariable("id") Integer id) {
        Instruction res=instructionService.updatemessInstruction(instruction, id);
        if(res==null)
            logger.info("[" + HttpStatus.NOT_FOUND + "]");
        else
            logger.info("[" + HttpStatus.OK + "]");
        return ResponseEntity.ok(instructionService.updatemessInstruction(instruction, id));
    }

    @PostMapping("/updateMenu")
    public ResponseEntity<?> updateMenu(@RequestBody Foodmenu foodmenu) {
        Foodmenu res=menuService.updateFoodMenu(foodmenu);
        System.out.println(foodmenu);
        if(res==null)
            logger.info("[" + HttpStatus.NOT_FOUND + "]");
        else
            logger.info("[" + HttpStatus.OK + "]");
        return ResponseEntity.ok(menuService.updateFoodMenu(foodmenu));
    }


}
