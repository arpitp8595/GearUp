/*
package FiservTestProject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang3.ObjectUtils;

public class DateUtil {

    public static void main(String[] args) {
        Address address = new Address();
        address.setStartDate("2025-05-26");
        address.setEndDate("2026-05-22");
        try {
            System.out.println("Are dates same? :" );
            validateEndDate(address);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static final String DATE_FORMAT_SERVICE = "yyyy-MM-dd"; // Define your date format

    //e.g.:  Fri May 30 00:00:00 EDT 2025 ,  Sat May 30 00:00:00 EDT 2026


    // Method to convert string to Date
    public static Date convertStringToDate(String dateString, String format) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        return dateFormat.parse(dateString);
    }

    public static void validateEndDate(Address address) throws Exception {
        try {
            // Parse start and end dates from the address object
            Date startDate = convertStringToDate(address.getStartDate(), DATE_FORMAT_SERVICE);
            Date endDate = convertStringToDate(address.getEndDate(), DATE_FORMAT_SERVICE);

            // Validate whether the end date is within 12 months of the start date and other conditions
            if (!isEndDateWithin12Months(startDate, endDate) || !isStartDateValid(startDate) || startDate.equals(endDate)) {
                throw generateCommonValidationException("INVALID_TEMPORAL_END_DATE_RANGE");
            }
        } catch (ParseException e) {
            // Log and rethrow exception for invalid date parsing
            System.out.println("Error parsing date: "  + e);
            throw generateCommonValidationException("INVALID_DATE_FORMAT");
        } catch (Exception e) {
            // Log and rethrow any other exceptions
            System.out.println("Error validating end date: " + e);
            throw generateCommonValidationException("GENERAL_ERROR");
        }
    }

    public static boolean isEndDateWithin12Months(Date startDate, Date endDate) {
        if (isValidDateRange(startDate, endDate)) {
            // Add 12 months to the start date to get the maximum allowed end date
            Date maxEndDate = addMonthsToDate(startDate, 12); // Define NUMBER_12 as 12
            return !endDate.after(maxEndDate);
        }
        return false;
    }

    private static boolean isValidDateRange(Date startDate, Date endDate) {
        return ObjectUtils.isNotEmpty(startDate) && ObjectUtils.isNotEmpty(endDate) && !endDate.before(startDate) && !startDate.equals(endDate);
    }

    public static boolean isStartDateValid(Date startDate) {
        // Add 12 months to the current date to get the maximum allowed start date
        Date currentDate = new Date();
        Date maxAllowedStartDate = addMonthsToDate(currentDate, 12);
        return !startDate.after(maxAllowedStartDate);
    }

    public static Date addMonthsToDate(Date date, int months) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MONTH, months);
        return cal.getTime();
    }

    // Method to throw validation exception
    private static Exception generateCommonValidationException(String errorCode) {
        return new Exception("Validation Exception: " + errorCode);
    }

    private static Exception generateCommonValidationException(String errorCode, Throwable cause) {
        return new Exception("Validation Exception: " + errorCode, cause);
    }
}
*/
