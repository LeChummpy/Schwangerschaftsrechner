package com.example.schwangerschaftsrechnerentwurf;

public class DateCalculator {

    public static int[] addNdaystogivendate(int[] Date, int NDays) {
        int[] result = new int[3];
        result[0] = Date[0];
        result[1] = Date[1];
        result[2] = Date[2];

        for (int i = 0; i < NDays; i++) {


            if (result[0] >= getNumberOfDaysInAMonth(result[1], result[2])) { //If end of month is reached
                result[0] = 0; //set days to zero
                result[1] += 1; //increase month by one
            }
            result[0] += 1;

            if (result[1] == 12) { //If end of year is reached
                result[1] = 0; //set months to zero
                result[2] += 1; //increase year by one
            }
        }

        return result;
    }

    public static int getNumberOfDaysInAMonth(int month, int year) {
        int DaysOfCurrentMonth = 31;

        if ((year % 4) == 0) { //If the given year IS a leap year

            if (month == 0) { //Days in Jan
                DaysOfCurrentMonth = 31;

            } else if (month == 1) { //Days in Feb
                DaysOfCurrentMonth = 29;

            } else if (month == 2) { //Days in Mar
                DaysOfCurrentMonth = 31;

            } else if (month == 3) { //Days in Apr
                DaysOfCurrentMonth = 30;

            } else if (month == 4) { //Days in Mai
                DaysOfCurrentMonth = 31;

            } else if (month == 5) { //Days in Jun
                DaysOfCurrentMonth = 30;

            } else if (month == 6) { //Days in Jul
                DaysOfCurrentMonth = 31;

            } else if (month == 7) { //Days in Aug
                DaysOfCurrentMonth = 31;

            } else if (month == 8) { //Days in Sep
                DaysOfCurrentMonth = 30;

            } else if (month == 9) { //Days in Oct
                DaysOfCurrentMonth = 31;

            } else if (month == 10) { //Days in Nov
                DaysOfCurrentMonth = 30;

            } else if (month == 11) { //Days in Dec
                DaysOfCurrentMonth = 31;

            }
        } else { //If the given year IS NOT a leap year
            if (month == 0) { //Days in Jan
                DaysOfCurrentMonth = 31;

            } else if (month == 1) { //Days in Feb
                DaysOfCurrentMonth = 28;

            } else if (month == 2) { //Days in Mar
                DaysOfCurrentMonth = 31;

            } else if (month == 3) { //Days in Apr
                DaysOfCurrentMonth = 30;

            } else if (month == 4) { //Days in Mai
                DaysOfCurrentMonth = 31;

            } else if (month == 5) { //Days in Jun
                DaysOfCurrentMonth = 30;

            } else if (month == 6) { //Days in Jul
                DaysOfCurrentMonth = 31;

            } else if (month == 7) { //Days in Aug
                DaysOfCurrentMonth = 31;

            } else if (month == 8) { //Days in Sep
                DaysOfCurrentMonth = 30;

            } else if (month == 9) { //Days in Oct
                DaysOfCurrentMonth = 31;

            } else if (month == 10) { //Days in Nov
                DaysOfCurrentMonth = 30;

            } else if (month == 11) { //Days in Dec
                DaysOfCurrentMonth = 31;
            }
        }

        return DaysOfCurrentMonth;
    }
}
