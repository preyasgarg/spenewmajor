package com.example.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;


import javax.persistence.*;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor

@Getter
@Setter
@ToString
@Entity
@Table
@IdClass(CountplatesPKID.class)
public class Countplates {

    @Id
    private Integer studentid;
    @Id
//    @Temporal(TemporalType.DATE)
//    private Date date=new Date(System.currentTimeMillis());
    private String date;
    private Integer breakfast;

    private Integer lunch;
    private Integer dinner;
    private Integer breakfastrating;
    private Integer lunchrating;
    private Integer dinnerrating;
    private String  feedback;

    }



