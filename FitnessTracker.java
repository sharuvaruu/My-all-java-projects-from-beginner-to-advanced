import java.util.Scanner;

public class FitnessTracker {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        
        // Get user input for personal information and fitness goals
        System.out.print("Enter your weight in pounds: ");
        double weight = scanner.nextDouble();
        
        System.out.print("Enter your height in inches: ");
        int height = scanner.nextInt();
        
        System.out.print("Enter your daily step goal: ");
        int stepGoal = scanner.nextInt();
        
        System.out.print("Enter your daily calorie goal: ");
        int calorieGoal = scanner.nextInt();
        
        // Initialize variables to track progress towards fitness goals
        int stepsTaken = 0;
        int caloriesBurned = 0;
        
        // Prompt user to input fitness activities for the day
        System.out.println("Enter your fitness activities for the day:");
        System.out.println("(Enter 'done' when finished)");
        
        while (true) {
            System.out.print("Activity: ");
            String activity = scanner.next();
            
            if (activity.equals("done")) {
                break;
            }
            
            System.out.print("Duration (in minutes): ");
            int duration = scanner.nextInt();
            
            // Update steps taken and calories burned based on activity type and duration
            if (activity.equals("walking")) {
                stepsTaken += duration * 100 / 10; // assume 100 steps per 10 minutes of walking
                caloriesBurned += duration * 5; // assume 5 calories burned per minute of walking
            } else if (activity.equals("running")) {
                stepsTaken += duration * 200 / 10; // assume 200 steps per 10 minutes of running
                caloriesBurned += duration * 10; // assume 10 calories burned per minute of running
            } else if (activity.equals("cycling")) {
                stepsTaken += duration * 50 / 10; // assume 50 steps per 10 minutes of cycling
                caloriesBurned += duration * 7; // assume 7 calories burned per minute of cycling
            }
        }
        
        // Display fitness information and progress towards goals to user
        System.out.println("\nFitness Tracker Report:");
        System.out.println("Weight: " + weight + " lbs");
        System.out.println("Height: " + height + " in");
        System.out.println("Daily Step Goal: " + stepGoal);
        System.out.println("Daily Calorie Goal: " + calorieGoal);
        System.out.println("Steps Taken Today: " + stepsTaken);
        System.out.println("Calories Burned Today: " + caloriesBurned);
        
        if (stepsTaken >= stepGoal) {
            System.out.println("You have met your step goal for the day!");
        } else {
            System.out.println("You have " + (stepGoal - stepsTaken) + " steps left to reach your goal.");
        }
        
        if (caloriesBurned >= calorieGoal) {
            System.out.println("You have met your calorie goal for the day!");
        } else {
            System.out.println("You have " + (calorieGoal - caloriesBurned) + " calories left to burn to reach your goal.");
        }
        
        scanner.close();
    }
}