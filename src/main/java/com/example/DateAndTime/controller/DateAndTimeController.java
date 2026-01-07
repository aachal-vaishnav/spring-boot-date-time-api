package com.example.DateAndTime.controller;

import com.example.DateAndTime.entity.DateAndTime;
import com.example.DateAndTime.service.DateAndTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/datetime")
public class DateAndTimeController {
    @Autowired
    DateAndTimeService dateAndTimeService;

    @PostMapping("/create")
    public ResponseEntity<DateAndTime> saveDateAndTime(@RequestBody DateAndTime dateAndTime){
        return dateAndTimeService.saveDateAndTime(dateAndTime);
    }

}
