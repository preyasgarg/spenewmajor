package com.example.controller;


import com.example.service.PopulateDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
public class populateDataController {

   @Autowired
   private PopulateDataService populateDataService;
    @PostMapping("/populatestudententries")
    public ResponseEntity<?> populatestudententries(){
        populateDataService.populatestudentdetails();
        return ResponseEntity.ok("Working");
    }


    @PostMapping("/populatemesstime")
    public ResponseEntity<?> populatemesstime() {
        populateDataService.populatemesstime();
        return ResponseEntity.ok("Working");
    }

    @PostMapping("/populatecountplates")
    public ResponseEntity<?> populatecountplates(){
       populateDataService.populatecountplates();
        return ResponseEntity.ok("Working");
    }

    @PostMapping("/populateinstruction")
    public ResponseEntity<?> populateinstruction() {
        populateDataService.populateinstruction();
        return ResponseEntity.ok("Working");
    }

}
