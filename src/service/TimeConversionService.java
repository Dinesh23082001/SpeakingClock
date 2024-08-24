package service;

public class TimeConversionService {

    public String convertTimeToWords(String time) {
        String[] timeParts = time.split(":");
        int hours = Integer.parseInt(timeParts[0]);
        int minutes = Integer.parseInt(timeParts[1]);

        if (hours == 0 && minutes == 0) {
            return "It's Midnight";
        } else if (hours == 12 && minutes == 0) {
            return "It's Midday";
        }

        return "It's " + convertHoursToWords(hours) + " " + convertMinutesToWords(minutes);
    }

    private String convertHoursToWords(int hours) {
        String[] words = {"twelve", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven", "twelve"};
        return words[hours % 12];
    }

    private String convertMinutesToWords(int minutes) {
        if (minutes == 0) {
            return "o'clock";
        } else if (minutes < 10) {
            return "oh " + convertSingleDigitToWord(minutes);
        } else {
            return convertTensToWord(minutes);
        }
    }

    private String convertSingleDigitToWord(int digit) {
        String[] words = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

        return words[digit];
    }

    private String convertTensToWord(int minutes) {
        String[] tensWords = {"", "", "twenty", "thirty", "forty", "fifty"};
        int tens = minutes / 10;
        int units = minutes % 10;
        if (tens == 1) {
            String[] teensWords = {"ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
            return teensWords[units];
        } else {
            return tensWords[tens] + (units != 0 ? " " + convertSingleDigitToWord(units) : "");
        }
    }
}
