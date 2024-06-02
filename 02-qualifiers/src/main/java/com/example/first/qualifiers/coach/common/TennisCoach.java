package com.example.first.qualifiers.coach.common;

import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach{
    @Override
    public String getDailyWorkout() {
        return "Practice Tennis daily for 40mins";
    }
}
