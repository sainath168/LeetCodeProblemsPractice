package tutorial.coreJava.coreConcepts.datesAndTimes;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
public class HandleDateWrtClientTimeZone {
    /**
     * Goal of this is to convert current date to COMMON timezone (mostly UTC or GMT)
     * and display it back to user with respect to client timezone (take client tz as i/p from user)
     */

    public static void main(String[] args) throws Exception {

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd hh:mm a z");

        //create calendar instance and set the timezone
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeZone(TimeZone.getTimeZone("America/New_York"));
        dateFormat.setTimeZone(TimeZone.getTimeZone("America/New_York"));
        calendar.set(2020,Calendar.MAY,25,15,10,45);
        System.out.println("Initial time in EST: ");
        System.out.println(dateFormat.format(calendar.getTime()));
        System.out.println(calendar.get(Calendar.DATE) + " " + calendar.get(Calendar.HOUR_OF_DAY) + ":" + calendar.get(Calendar.MINUTE));

        //convert to UTC if you want to persist and while retrieving/displaying you can consider client's timezone
        calendar.setTimeZone(TimeZone.getTimeZone("UTC"));
        dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        System.out.println("Persist in UTC in DB: ");
        System.out.println(dateFormat.format(calendar.getTime()));
        System.out.println(calendar.get(Calendar.DATE) + " " + calendar.get(Calendar.HOUR_OF_DAY) + ":" + calendar.get(Calendar.MINUTE));

        /*System.out.println(calendar.get(Calendar.HOUR_OF_DAY) + ":" + calendar.get(Calendar.MINUTE));*/

        Scanner scanner = new Scanner(System.in);
        System.out.println("Select client's country. 1. USA 2. India 3. Other");
        int country;
        while (!scanner.hasNextInt()) {
            System.out.println("Please enter valid number: ");
            scanner.next();
        }
        //decide the timezone based on country selection
        String tz = "";
        country = scanner.nextInt();
        switch (country) {
            case 1:
                tz = "EST";
                break;
            case 2:
                tz = "Asia/Calcutta";
                break;
            default:
                tz = "UTC";
        }

        System.out.println("Timezone " + country + " : " +tz);
        calendar.setTimeZone(TimeZone.getTimeZone(tz));
        dateFormat.setTimeZone(TimeZone.getTimeZone(tz));

        System.out.println(dateFormat.format(calendar.getTime()));
        System.out.println(calendar.get(Calendar.DATE) + " " + calendar.get(Calendar.HOUR_OF_DAY) + ":" + calendar.get(Calendar.MINUTE));

    }

}
