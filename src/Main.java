import java.util.*;

public class Main {
    static Integer day;
    static String activity;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws NoActivitiesForDayException {
        DailyPlanner dailyPlanner = new DailyPlanner(new ArrayList<>());
        int option;
        do {
            System.out.println("Please choose an option:");
            System.out.println("1) add an activity");
            System.out.println("2) remove an activity");
            System.out.println("3) list all activities");
            System.out.println("4) end planning");
            option = scanner.nextInt();
            switch (option) {
                case 1: {
                    readDay();
                    readActivity();
                    dailyPlanner.addActivity(day, activity);
                    break;
                }
                case 2: {
                    readDay();
                    readActivity();
                    dailyPlanner.removeActivity(day, activity);
                    break;
                }
                case 3: {
                    readDay();
                    System.out.println(dailyPlanner.getActivities(day));
                    break;
                }
                case 4:{
                    System.out.println(dailyPlanner.endPlanning().toString());
                    break;
                }
                default:break;
            }
        }
        while (option > 0 && option < 4);
    }

    private static void readDay() {
        do {
            System.out.println("Enter the number of day of the week (1-7)");
            day = scanner.nextInt();
        }
        while (day > 7 || day < 1);
        scanner.nextLine();
    }

    private static void readActivity() {
        System.out.println("Enter the activity");
        activity = scanner.nextLine();
    }

}
