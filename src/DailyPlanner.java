import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DailyPlanner {
    private List<DaySchedule> dailyPlanner;

    public DailyPlanner(List<DaySchedule> dailyPlanner) {
        this.dailyPlanner = dailyPlanner;
        dailyPlanner.add(new DaySchedule(DaysOfWeek.MONDAY, new ArrayList<>()));
        dailyPlanner.add(new DaySchedule(DaysOfWeek.TUESDAY, new ArrayList<>()));
        dailyPlanner.add(new DaySchedule(DaysOfWeek.WEDNESDAY, new ArrayList<>()));
        dailyPlanner.add(new DaySchedule(DaysOfWeek.THURSDAY, new ArrayList<>()));
        dailyPlanner.add(new DaySchedule(DaysOfWeek.FRIDAY, new ArrayList<>()));
        dailyPlanner.add(new DaySchedule(DaysOfWeek.SATURDAY, new ArrayList<>()));
        dailyPlanner.add(new DaySchedule(DaysOfWeek.SUNDAY, new ArrayList<>()));
    }

    public List<DaySchedule> getDailyPlanner() {
        return dailyPlanner;
    }

    public void addActivity(Integer day, String activity) throws NoActivityException {
        if (activity.equals(null)) {
            throw new NoActivityException(activity);
        } else {
            DaysOfWeek dayOfWeek;
            dayOfWeek = DaysOfWeek.getDayOfWeek(day);
            for (DaySchedule daySchedule : dailyPlanner) {
                if (daySchedule.getDay() == dayOfWeek) {
                    daySchedule.getActivities().add(activity);
                }
            }
        }
    }

    public void removeActivity(Integer day, String activity) throws NoActivityException {
        DaysOfWeek dayOfWeek;
        dayOfWeek = DaysOfWeek.getDayOfWeek(day);
        for (DaySchedule daySchedule : dailyPlanner) {
            if (daySchedule.getDay() == dayOfWeek) {
                if (!daySchedule.getActivities().contains(activity)) {
                    throw new NoActivityException(activity);
                }
                daySchedule.getActivities().remove(activity);
            }
        }
    }

    public List<String> getActivities(Integer day) {
        List<String> activities = new ArrayList<>();
        DaysOfWeek dayOfWeek;
        dayOfWeek = DaysOfWeek.getDayOfWeek(day);
        for (DaySchedule daySchedule : dailyPlanner) {
            if (daySchedule.getDay() == dayOfWeek) {
                activities = daySchedule.getActivities();
            }
        }
        return activities;
    }

    public Map<DaysOfWeek, List<String>> endPlanning() throws NoActivitiesForDayException {
        Map<DaysOfWeek, List<String>> result = new HashMap<>();
        DaysOfWeek day;
        for (DaySchedule daySchedule : dailyPlanner) {
            day = daySchedule.getDay();
            if (daySchedule.getActivities().size() == 0) {
                throw new NoActivitiesForDayException(day);
            }
            result.put(day, new ArrayList<>());
            result.get(day).add(daySchedule.getActivities().toString());
        }
        return result;
    }
}
