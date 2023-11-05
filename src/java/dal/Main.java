package dal;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class Main {

    public static void main(String[] args) {
        LocalDateTime currentTime = LocalDateTime.now();
        LocalDateTime targetTime = LocalDateTime.of(currentTime.toLocalDate(), LocalTime.of(12, 0));
        System.out.println(currentTime);
        System.out.println(targetTime);
        // Compare the two times
        if (currentTime.isAfter(targetTime)) {
            System.out.println("The current time has passed the target time.");
        } else if (currentTime.isBefore(targetTime)) {
            System.out.println("The current time is before the target time.");
        } else {
            System.out.println("The current time is the same as the target time.");
        }
    }
}
