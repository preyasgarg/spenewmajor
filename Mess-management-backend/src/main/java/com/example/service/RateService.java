package com.example.service;

import com.example.dao.CountplatesRepository;
import com.example.model.Countplates;
import com.example.model.Foodmenu;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Temporal;
import org.springframework.stereotype.Service;

import javax.persistence.TemporalType;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import java.util.Date;
import java.time.LocalTime;
import java.util.List;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class RateService {

    @Autowired
    private CountplatesRepository countplatesRepository;

    public List<Integer> fetchRate(Integer id) {
        if(id==1)
        {
            List<Integer> res=new ArrayList<Integer>();
            Integer rating1,rating2,rating3,rating4,rating5;
            res.add(rating1=countplatesRepository.getbybreakfastrating(1));
            res.add(rating2=countplatesRepository.getbybreakfastrating(2));
            res.add(rating3=countplatesRepository.getbybreakfastrating(3));
            res.add(rating4=countplatesRepository.getbybreakfastrating(4));
            res.add(rating5=countplatesRepository.getbybreakfastrating(5));
            return res;
        }
        else if(id==2){
            List<Integer> res=new ArrayList<Integer>();
            Integer rating1,rating2,rating3,rating4,rating5;
            res.add(rating1=countplatesRepository.getbylunchrating(1));
            res.add(rating2=countplatesRepository.getbylunchrating(2));
            res.add(rating3=countplatesRepository.getbylunchrating(3));
            res.add(rating4=countplatesRepository.getbylunchrating(4));
            res.add(rating5=countplatesRepository.getbylunchrating(5));

            return res;


        }

        else
        {
            List<Integer> res=new ArrayList<Integer>();
            Integer rating1,rating2,rating3,rating4,rating5;
            res.add(rating1=countplatesRepository.getbydinnerrating(1));
            res.add(rating2=countplatesRepository.getbydinnerrating(2));
            res.add(rating3=countplatesRepository.getbydinnerrating(3));
            res.add(rating4=countplatesRepository.getbydinnerrating(4));
            res.add(rating5=countplatesRepository.getbydinnerrating(5));
            return res;
        }
    }

    public Countplates postRating(Countplates countplates){
       Countplates c1=countplatesRepository.getUserByIdAndCurrDate(countplates.getStudentid(), java.time.LocalDate.now().toString());
        if(c1==null)
        {
            //u hv not selected meal, so cant give feedback today
            System.out.println("You have not taken meal today so, You can't rate ");
            return null;
        }
        else {
          c1.setBreakfastrating(countplates.getBreakfastrating());
          c1.setLunchrating(countplates.getLunchrating());
          c1.setDinnerrating(countplates.getDinnerrating());
          c1.setFeedback(countplates.getFeedback());
        return countplatesRepository.save(c1);

        }
    }

}
