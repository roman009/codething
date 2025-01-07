package io.codething.activity;

/**
 * Activities
 */
public interface Activity {
    int getDuration();

    int getDistance();

    int getCalories();

    default int getCaloriesBurntFromActivity() {
        return getCalories() * getDuration();
    }
}
