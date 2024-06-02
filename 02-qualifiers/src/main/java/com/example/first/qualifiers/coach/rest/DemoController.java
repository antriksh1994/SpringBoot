package com.example.first.qualifiers.coach.rest;

import com.example.first.qualifiers.coach.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    // define a private field for dependency
    private Coach myCoach;
    //define a constructor for DI
//    @Autowired
//    public DemoController(Coach theCoach) {
//        myCoach = theCoach;
//    }
//    use of setter injection
    @Autowired
    public void setCoach(@Qualifier("tennisCoach") Coach theCoach) {
        myCoach = theCoach;
    }
    @GetMapping("/workout")
        public String getDailyWorkout() {
            return myCoach.getDailyWorkout();
        }
}
