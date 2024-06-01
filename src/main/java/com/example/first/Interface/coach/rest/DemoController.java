package com.example.first.Interface.coach.rest;

import com.example.first.Interface.coach.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    // define a private field for dependency
    private Coach myCoach;
    //define a constructor for DI
    @Autowired
    public DemoController(Coach theCoach) {
        myCoach = theCoach;
    }
    @GetMapping("/workout")
        public String getDailyWorkout() {
            return myCoach.getDailyWorkout();
        }
}
