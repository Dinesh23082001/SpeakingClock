package model;

public class TimeResponse {
    private String timeInWords;

    public TimeResponse(String timeInWords) {

        this.timeInWords = timeInWords;
    }

    public String getTimeInWords() {
        return timeInWords;
    }

    public void setTimeInWords(String timeInWords) {
        this.timeInWords = timeInWords;
    }
}
