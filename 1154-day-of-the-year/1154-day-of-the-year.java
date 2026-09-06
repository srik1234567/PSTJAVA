class Solution {

    public int dayOfYear(String date) {
        int year = Integer.parseInt(date.substring(0, 4));
        int month = Integer.parseInt(date.substring(5, 7));
        int day = Integer.parseInt(date.substring(8, 10));

        int[] days = {0, 31, 28, 31, 30, 31, 30,
                      31, 31, 30, 31, 30, 31};

        int total = day;

        for (int i = 1; i < month; i++) {
            total += days[i];
        }

        // Leap year
        if (month > 2 &&
            (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0))) {
            total++;
        }

        return total;
    }
}