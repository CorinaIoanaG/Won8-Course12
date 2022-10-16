public class NoActivityException extends RuntimeException {
    private String activity;

    public NoActivityException(String activity) {
        this.activity = activity;
    }

    public String getActivity() {
        return activity;
    }

    public String getMessage() {
        return String.format("No Activity Exception %s", this.activity);
    }
}

