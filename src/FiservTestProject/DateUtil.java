/*
package FiservTestProject;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {

    private static final String DATE_FORMAT_SERVICE = "yyyy-MM-dd"; // Define your date format

    // Method to convert string to Date
    public static Date convertStringToDate(String dateString, String format) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        return dateFormat.parse(dateString);
    }

    // Method to add months to a date
    public static Date addMonthsToDate(Date date, int months) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MONTH, months);
        return cal.getTime();
    }

    public static boolean isEndDateWithin12Months(Date startDate, Date endDate) {
        // Add 12 months to startDate to get the maximum allowed end date
        Date maxEndDate = addMonthsToDate(startDate, 12);

        return !endDate.before(startDate) && !endDate.after(maxEndDate);
    }

    public static void main(String[] args) {
        try {
            String beginDateStr = address.getBeginDate();
            String endDateStr = address.getEndDate();

            Date startDate = convertStringToDate(beginDateStr, DATE_FORMAT_SERVICE);
            Date endDate = convertStringToDate(endDateStr, DATE_FORMAT_SERVICE);

            if (!isEndDateWithin12Months(startDate, endDate)) {
                throw generateCommonValidationException(BusinessErrorCode.INVALID_TEMPORAL_END_DATE_RANGE.errorCode());
            }

            // Further processing with valid endDate

        } catch (ParseException e) {
            // Handle parsing exceptions
        } catch (Exception e) {
            // Handle other exceptions
        }
    }

    private static Exception generateCommonValidationException(String errorCode) {
        // Implement this method to throw validation exception
    }
}
*/
