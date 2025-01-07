/*
 * Tracker app for tracking activities and reporting calories
 */
package io.codething;

import io.codething.activity.Activity;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TrackerApp {
    private final Map<User, List<Activity>> userActivities = new ConcurrentHashMap<>();

    public void addActivity(User user, Activity activity) {
        userActivities.computeIfAbsent(user, k -> new ArrayList<>()).add(activity);
    }

    public int totalActivities() {
        return userActivities.values().stream()
                .mapToInt(List::size)
                .sum();
    }

    public int totalCalories() {
        return userActivities.entrySet().stream()
                .mapToInt(entry -> entry.getValue().stream()
                        .mapToInt(activity -> activity.getCaloriesBurntFromActivity() + entry.getKey().getBmr() * activity.getDuration())
                        .sum())
                .sum();
    }

    public int getTotalCaloriesForUser(User user) {
        return userActivities.get(user).stream()
                .mapToInt(activity -> activity.getCaloriesBurntFromActivity() + user.getBmr() * activity.getDuration())
                .sum();
    }

    public int getTotalCaloriesFromActivityForUser(User user) {
        return userActivities.get(user).stream()
                .mapToInt(Activity::getCaloriesBurntFromActivity)
                .sum();
    }

    public int getTotalCaloriesFromBmrForUser(User user) {
        return userActivities.get(user).stream()
                .mapToInt(activity -> user.getBmr() * activity.getDuration())
                .sum();
    }

    public int totalDuration() {
        return userActivities.values().stream()
                .flatMap(List::stream)
                .mapToInt(Activity::getDuration)
                .sum();
    }
}
