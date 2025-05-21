/*
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import org.apache.commons.lang3.ObjectUtils;

public class DateUtil {

    private static final String DATE_FORMAT_SERVICE = "yyyy-MM-dd"; // Define your date format

    // Method to convert string to Date
    public static Date convertStringToDate(String dateString, String format) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        return dateFormat.parse(dateString);
    }

    public static void validateEndDate(Address address) {
        try {
            // Parse start and end dates from the address object
            Date startDate = convertStringToDate(address.getBeginDate(), DATE_FORMAT_SERVICE);
            Date endDate = convertStringToDate(address.getEndDate(), DATE_FORMAT_SERVICE);

            // Validate whether the end date is within 12 months of the start date and other conditions
            if (!isEndDateWithin12Months(startDate, endDate) || !isStartDateValid(startDate) || startDate.equals(endDate)) {
                throw generateCommonValidationException(BusinessErrorCode.INVALID_TEMPORAL_END_DATE_RANGE.errorCode());
            }
        } catch (ParseException e) {
            // Log and rethrow exception for invalid date parsing
            log.error("Error parsing date: ", e);
            throw generateCommonValidationException(BusinessErrorCode.INVALID_DATE_FORMAT.errorCode(), e);
        } catch (Exception e) {
            // Log and rethrow any other exceptions
            log.error("Error validating end date: ", e);
            throw generateCommonValidationException(BusinessErrorCode.GENERAL_ERROR.errorCode(), e);
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
