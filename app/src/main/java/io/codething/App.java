package io.codething;

import io.codething.activity.RunningActivity;
import io.codething.activity.SwimmingActivity;
import io.codething.activity.WalkingActivity;

import java.util.UUID;

public class App {
    public static void main(String[] args) {
        System.out.println("Hello!");

        TrackerApp trackerApp = new TrackerApp();

        User user1 = User.builder().id(UUID.randomUUID()).bmr(10).build();
        User user2 = User.builder().id(UUID.randomUUID()).bmr(20).build();

        trackerApp.addActivity(user1, RunningActivity.builder().duration(10).distance(30).build());
        trackerApp.addActivity(user1, SwimmingActivity.builder().duration(5).distance(1).build());
        trackerApp.addActivity(user1, WalkingActivity.builder().duration(60).distance(5).build());

        trackerApp.addActivity(user2, RunningActivity.builder().duration(20).distance(50).build());
        trackerApp.addActivity(user2, SwimmingActivity.builder().duration(10).distance(2).build());
        trackerApp.addActivity(user2, WalkingActivity.builder().duration(120).distance(10).build());

        System.out.println("Total activities: " + trackerApp.totalActivities());
        System.out.println("Total calories: " + trackerApp.totalCalories());
        System.out.println("Total duration: " + trackerApp.totalDuration());

        System.out.println("Total calories for user1: " + trackerApp.getTotalCaloriesForUser(user1));
        System.out.println("Total calories from activity for user1: " + trackerApp.getTotalCaloriesFromActivityForUser(user1));
        System.out.println("Total calories from BMR for user1: " + trackerApp.getTotalCaloriesFromBmrForUser(user1));

        System.out.println("Total calories for user2: " + trackerApp.getTotalCaloriesForUser(user2));
        System.out.println("Total calories from activity for user2: " + trackerApp.getTotalCaloriesFromActivityForUser(user2));
        System.out.println("Total calories from BMR for user2: " + trackerApp.getTotalCaloriesFromBmrForUser(user2));
    }
}
