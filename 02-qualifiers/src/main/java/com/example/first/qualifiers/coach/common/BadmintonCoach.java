package com.example.first.qualifiers.coach.common;
import org.springframework.stereotype.Component;

@Component
public class BadmintonCoach implements Coach {
    @Override
    public String getDailyWorkout() {
        return "Practice badminton daily for 30mins";
    }
}