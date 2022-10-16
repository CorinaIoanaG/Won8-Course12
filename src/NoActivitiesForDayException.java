public class NoActivitiesForDayException extends Exception{
    private DaysOfWeek day;

    public NoActivitiesForDayException(DaysOfWeek day) {
        this.day = day;
    }

    public DaysOfWeek getDay() {
        return day;
    }

    public String getMessage() {
        return String.format("No Activity For Day %s Exception", this.day);
    }
}
