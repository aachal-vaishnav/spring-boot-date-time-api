package com.example.DateAndTime.respository;

import com.example.DateAndTime.entity.DateAndTime;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DateAndTimeRepository extends JpaRepository<DateAndTime,Long> {

}
