package controller;

import java.util.Scanner;

import model.TimeResponse;
import service.TimeConversionService;

public class SpeakingClockController {

    private TimeConversionService timeConversionService;

    public SpeakingClockController() {

        this.timeConversionService = new TimeConversionService();

    }

    public TimeResponse getCurrentTime() {
        String currentTime = java.time.LocalTime.now().toString().substring(0, 5);
        String timeInWords = timeConversionService.convertTimeToWords(currentTime);
        return new TimeResponse(timeInWords);
    }

    public TimeResponse convertTime(String time) {
        String timeInWords = timeConversionService.convertTimeToWords(time);
        return new TimeResponse(timeInWords);
    }

    public static void main(String[] args) {
        SpeakingClockController controller = new SpeakingClockController();

        // Example usage
        System.out.println("Enter a time in HH:mm format or type 'current' for the current time:");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        TimeResponse response;
        if (input.equalsIgnoreCase("current")) {
            response = controller.getCurrentTime();
        } else {
            response = controller.convertTime(input);
        }

        System.out.println(response.getTimeInWords());
    }
}
