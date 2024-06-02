package com.example.first.qualifiers.coach.common;

import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach {
    @Override
    public String getDailyWorkout() {
        return "Practice fast balling daily for 15min !!";
    }
}
