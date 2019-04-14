package tools.apiClient.helper;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * General Date utilities.
 * This class provides static utility methods for date operations.
 *
 */
public class DateUtils
{

  /**
   * Get current time as "HH:mm:ss".
   * @return format time.
   */
  public static String getCurrentTime()
  {

    Date today = new Date();
    SimpleDateFormat f = new SimpleDateFormat("HH:mm:ss");
    String time = f.format(today);
    return time;
  }

 /**
  * Get current date as "yyyy-MM-dd".
  * @return format date.
  */
  public static String getDate()
  {

    Date date = new Date();
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    return dateFormat.format(date);
  }

}
