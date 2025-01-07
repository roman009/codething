package io.codething.activity;

import lombok.Builder;

@Builder
public class SwimmingActivity implements Activity {
    private int distance;
    private int duration;
    private final int calories = 200;

    @Override
    public int getCalories() {
        return duration;
    }

    @Override
    public int getDistance() {
        return distance;
    }

    @Override
    public int getDuration() {
        return duration;
    }

    @Override
    public int getCaloriesBurntFromActivity() {
        return getCalories() * getDuration() * 3;
    }
}
