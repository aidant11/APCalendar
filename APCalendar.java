public class APCalendar {

    private static boolean isLeap(int y) {
        return (y % 4 == 0) && ((y % 100 != 0) || (y % 400 == 0));
    }

    public static int leapYearCount(int fromYear, int toYear) {
        int total = 0;
        for (int yr = fromYear; yr <= toYear; yr++) {
            if (isLeap(yr)) {
                total++;
            }
        }
        return total;
    }

    private static int yearStartDay(int yr) {
        int dayCode = 1;
        for (int i = 1; i < yr; i++) {
            dayCode += isLeap(i) ? 366 : 365;
        }
        return dayCode % 7;
    }

    private static int dayOfYear(int month, int day, int year) {
        int days = 0;
        if (month > 1) days += 31;
        if (month > 2) days += 28;
        if (isLeap(year)) days++;
        if (month > 3) days += 31;
        if (month > 4) days += 30;
        if (month > 5) days += 31;
        if (month > 6) days += 30;
        if (month > 7) days += 31;
        if (month > 8) days += 31;
        if (month > 9) days += 30;
        if (month > 10) days += 31;
        if (month > 11) days += 30;
        days += day;
        return days;
    }

    public static int dayOfWeek(int month, int day, int year) {
        int start = yearStartDay(year);
        int offset = dayOfYear(month, day, year) - 1;
        return (start + offset) % 7;
    }
}
