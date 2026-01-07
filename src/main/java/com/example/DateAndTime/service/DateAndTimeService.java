package com.example.DateAndTime.service;

import com.example.DateAndTime.entity.DateAndTime;
import com.example.DateAndTime.respository.DateAndTimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class DateAndTimeService {

    @Autowired
    DateAndTimeRepository dateAndTimeRepository;

    public ResponseEntity<DateAndTime> saveDateAndTime(DateAndTime dateAndTime){
        dateAndTimeRepository.save(dateAndTime);
        return ResponseEntity.ok().build();
    }
}
