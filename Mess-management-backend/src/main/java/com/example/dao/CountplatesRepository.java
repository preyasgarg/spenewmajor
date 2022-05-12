package com.example.dao;

import com.example.model.Countplates;
import com.example.model.CountplatesPKID;
import com.example.model.History;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Temporal;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import javax.persistence.TemporalType;
import java.util.Date;
import java.util.List;

@Repository
public interface CountplatesRepository extends JpaRepository<Countplates, CountplatesPKID> {

    @Query(value = "select sum(breakfast) from countplates where date=curdate()",
            nativeQuery = true)
    public Integer getcountofbreakfast();

    @Query(value = "select sum(lunch) from countplates   ",
            nativeQuery = true)
    public Integer getcountoflunch();

    @Query(value = "select sum(dinner) from countplates where date=curdate()",
            nativeQuery = true)
    public Integer getcountofdinner();


    @Query(value = "select count(*) from countplates where breakfastrating=?1 " ,
        nativeQuery = true)
    public Integer getbybreakfastrating(Integer ratingNo);

    @Query(value = "select count(*) from countplates where lunchrating=?1",
            nativeQuery = true)
    public Integer getbylunchrating(Integer ratingNo);

    @Query(value = "select count(*) from countplates where dinnerrating=?1",

            nativeQuery = true)
    public Integer getbydinnerrating(Integer ratingNo);




    @Query(
            value="select date,breakfast,lunch,dinner from countplates c where c.studentid=?1",
            nativeQuery = true
    )
    public List<History> findIDateAndBreakfastAndLunchAndDinnerById(Integer studentid);




    @Query( "select c from Countplates c where c.studentid= :n and c.date= :x")
    public Countplates getUserByIdAndCurrDate(@Param("n")Integer req, @Param("x") String date);




    @Query(
            value="select * from countplates group by studentid",
            nativeQuery = true
    )
    public List<Countplates> findAll();

}
