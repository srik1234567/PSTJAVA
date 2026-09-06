class Solution {

    public String dayOfTheWeek(int day, int month, int year) {

        String[] week = {
            "Sunday", "Monday", "Tuesday", "Wednesday",
            "Thursday", "Friday", "Saturday"
        };

        int[] days = {
            0, 31, 28, 31, 30, 31, 30,
            31, 31, 30, 31, 30, 31
        };

        int total = 0;

        // Days from 1971 to previous year
        for (int y = 1971; y < year; y++) {
            total += isLeap(y) ? 366 : 365;
        }

        // Days in previous months
        for (int m = 1; m < month; m++) {
            total += days[m];
        }

        // Leap year adjustment
        if (month > 2 && isLeap(year)) {
            total++;
        }

        // Add current day - 1
        total += day - 1;

        // Jan 1, 1971 = Friday (index 5)
        int index = (total + 5) % 7;

        return week[index];
    }

    private boolean isLeap(int year) {
        return year % 400 == 0 ||
               (year % 4 == 0 && year % 100 != 0);
    }
}