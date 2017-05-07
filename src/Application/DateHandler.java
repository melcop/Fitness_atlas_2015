package Application;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author Pelle & Mikkel
 */
public class DateHandler {
    
    
        Calendar date = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
    /**
     * This method will return todays date
     * @return the current date in format (dd/mm/yyyy)
     */
    public String getCurrentDate() {
        
            return sdf.format(date.getTime());
        }
        
    /**
     * Return a future date where the parameter is the days you wanna plus to todays date
     * @param  days 
     * @return a date in string format (dd/mm/yyyy)
     */
    public String getFutureDate(int days) {
            
            date = Calendar.getInstance();
            date.add(Calendar.DAY_OF_MONTH, days);
            return sdf.format(date.getTime());
        }
        
    /**
     * This method takes a fromDate and a toDate and return the number of days between
     * @param fromDate
     * @param toDate
     * @return the number of days between two dates. 
     */
    public int getDaysBetweenDates(String fromDate, String toDate) {
        
            Calendar dateFrom = Calendar.getInstance();
            Calendar dateTo = Calendar.getInstance();
            
            int fromDays = Integer.parseInt(fromDate.substring(0, fromDate.indexOf('/')));
            int fromMonth = Integer.parseInt(fromDate.substring(fromDate.indexOf('/')+1, 5));
            int fromYear = Integer.parseInt(fromDate.substring(6 , 10));
            
            dateFrom.set(Calendar.YEAR, fromYear);
            dateFrom.set(Calendar.MONTH, fromMonth);
            dateFrom.set(Calendar.DAY_OF_MONTH, fromDays);
            
            int toDays = Integer.parseInt(toDate.substring(0, toDate.indexOf('/')));
            int toMonth = Integer.parseInt(toDate.substring(toDate.indexOf('/')+1, 5));
            int toYear = Integer.parseInt(toDate.substring(6 , 10));
            
            dateTo.set(Calendar.YEAR, toYear);
            dateTo.set(Calendar.MONTH, toMonth);
            dateTo.set(Calendar.DAY_OF_MONTH, toDays);
            
            long days = (dateTo.getTimeInMillis()-dateFrom.getTimeInMillis()) / 86400000;
            
            return (int)days;
        }

    /**
     * This method will take a European date format (dd/mm/yyyy)
     * and convert it into an computer date format
     * @param dateInput
     * @return a date in American format (yyyy-mm-dd)
     */
    public String convertDateFormatToAmerican(String dateInput) {
        
            date = Calendar.getInstance();
            
            
            int fromDays = Integer.parseInt(dateInput.substring(0, dateInput.indexOf('/')));
            int fromMonth = Integer.parseInt(dateInput.substring(dateInput.indexOf('/')+1, 5));
            int fromYear = Integer.parseInt(dateInput.substring(6 , 10));
            
            date.set(Calendar.YEAR, fromYear);
            date.set(Calendar.MONTH, fromMonth-1);
            date.set(Calendar.DAY_OF_MONTH, fromDays);
            
            sdf = new SimpleDateFormat("yyyy-MM-dd");
            
            return sdf.format(date.getTime());
            
        }
        
    /**
     * This method will take an American date format (yyyy-MM-dd)
     * and convert it into an European date format
     * @param dateInput
     * @return a date in European format (dd/MM/yyyy)
     */
    public String convertDateFormatToEuropean(String dateInput)
        {
            date = Calendar.getInstance();
            
            int fromDays = Integer.parseInt(dateInput.substring(8, 10));
            int fromMonth = Integer.parseInt(dateInput.substring(5, 7));
            int fromYear = Integer.parseInt(dateInput.substring(0 , dateInput.indexOf('-')));
            
            date.set(Calendar.DAY_OF_MONTH, fromDays);
            date.set(Calendar.MONTH, fromMonth-1);
            date.set(Calendar.YEAR, fromYear);
            
            sdf = new SimpleDateFormat("dd/MM/yyyy");
            
            return sdf.format(date.getTime());
        }

    /**
     * This method will take two parameters a String date input in format (yyyy-MM-dd)
     * and an int days and then plus the days to the date
     * @param dateInput
     * @param days
     * @return a String date (yyyy-MM-dd) + number of days
     */
    public String setFromDatePlusX(String dateInput, int days)
        {
            date = Calendar.getInstance();
            
            int fromDays = Integer.parseInt(dateInput.substring(8, 10));
            int fromMonth = Integer.parseInt(dateInput.substring(5, 7));
            int fromYear = Integer.parseInt(dateInput.substring(0 , dateInput.indexOf('-')));
            
            date.set(Calendar.DAY_OF_MONTH, fromDays);
            date.set(Calendar.MONTH, fromMonth-1);
            date.set(Calendar.YEAR, fromYear);
            date.add(Calendar.DAY_OF_MONTH, days);
            
            
            return sdf.format(date.getTime());
        }
  
        
}
