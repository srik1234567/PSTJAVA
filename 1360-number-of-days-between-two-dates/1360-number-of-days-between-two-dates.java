class Solution {

    public int daysBetweenDates(String date1, String date2) {
        return Math.abs(toDays(date1) - toDays(date2));
    }

    private int toDays(String date) {
        String[] p = date.split("-");

        int year = Integer.parseInt(p[0]);
        int month = Integer.parseInt(p[1]);
        int day = Integer.parseInt(p[2]);

        int[] days = {0, 31, 28, 31, 30, 31, 30,
                      31, 31, 30, 31, 30, 31};

        int total = 0;

        // Count complete years
        for (int y = 1971; y < year; y++) {
            if (isLeap(y))
                total += 366;
            else
                total += 365;
        }

        // Count complete months
        for (int m = 1; m < month; m++) {
            total += days[m];
        }

        // Add leap day if necessary
        if (month > 2 && isLeap(year))
            total++;

        total += day;

        return total;
    }

    private boolean isLeap(int year) {
        return year % 400 == 0 ||
               (year % 4 == 0 && year % 100 != 0);
    }
}