package com.example.service;

import com.example.dao.CountplatesRepository;
import com.example.model.Countplates;
import com.example.model.History;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import java.util.Date;
import java.time.LocalTime;
import java.util.List;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class CountplateService {

    @Autowired
    private CountplatesRepository countplatesRepository;

    public List<Integer> fetchplatecount(){
//        List<Integer> res;
//
//        res=countplatesRepository.getcountofplates();
//        System.out.println(res);
//        return res;
        Integer b,l,d;
        b=countplatesRepository.getcountofbreakfast();
        l=countplatesRepository.getcountoflunch();
        d=countplatesRepository.getcountofdinner();
        List<Integer> res = new ArrayList<Integer>();
        res.add(b);
        res.add(l);
        res.add(d);
        return res;

    }
    public List<History> getPlatehistory(Integer studentid){   //from student side to see date and plate count history
       // List<Integer> res = new ArrayList<Integer>();
        //List<ArrayList<String>> listOfLists = new ArrayList<ArrayList<String>>();
        List<History>his=countplatesRepository.findIDateAndBreakfastAndLunchAndDinnerById(studentid);
       // res.add(his.getDate());

//        res.add(his.getBreakfast());
//        res.add(his.getLunch());
//        res.add(his.getDinner());

        return his;
    }

    public Countplates postPlate(Countplates countplates){
        Countplates c1=countplatesRepository.getUserByIdAndCurrDate(countplates.getStudentid(),java.time.LocalDate.now().toString());
        System.out.println(c1);
        countplates.setDate(java.time.LocalDate.now().toString());
       if(c1==null)  //if no entry that is each new day
            return countplatesRepository.save(countplates);
       else {  //if want to update current food
            c1.setDate(java.time.LocalDate.now().toString());
            c1.setBreakfast(countplates.getBreakfast());
            c1.setLunch(countplates.getLunch());
            c1.setDinner(countplates.getDinner());
            return countplatesRepository.save(c1);
        }
    }



}
