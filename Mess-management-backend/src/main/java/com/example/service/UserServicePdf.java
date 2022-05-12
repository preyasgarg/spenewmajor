package com.example.service;

import com.example.dao.CountplatesRepository;
import com.example.model.Countplates;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServicePdf {
    @Autowired
    private CountplatesRepository countplatesRepository;

    public List<Countplates> listAll() {
        return countplatesRepository.findAll(Sort.by("date").ascending());
    }
}
