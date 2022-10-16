import java.util.List;

public class DaySchedule {
    private DaysOfWeek day;
    private List<String> activities;

    public DaySchedule(DaysOfWeek day, List<String> activities) {
        this.day = day;
        this.activities = activities;
    }

    public DaysOfWeek getDay() {
        return day;
    }

    public List<String> getActivities() {
        return activities;
    }
}
