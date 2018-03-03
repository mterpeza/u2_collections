package unit2collections;

import java.text.DateFormat;
import java.util.Date;
import java.util.Map;

public class Main {

    // List of IO methods (input/output)
    private final static fileInput dateDiff = new fileInput ("date_diff.csv");
    //private final static Map<String, dateDiffInfo> map = new HashMap();
    private final static file_Output output = new file_Output("output.txt");/// also create the object first

    public static void main(String[] args){

        //String line;
        //String[] words;
        //Object wordFound;

        // Today's date
        Date today = new Date();
        long diff = today.getTime() - dateDiff (= file_Output );
        System.out.println((diff / (1000 * 60 * 60 * 24)) + " days old.");
        DateFormat formatter = DateFormat.getDateTimeInstance(DateFormat.LONG);


        /*String (long timeDifferenceMilliseconds) {
            long diffSeconds = timeDifferenceMilliseconds / 1000;
            long diffMinutes = timeDifferenceMilliseconds / (60 * 1000);
            long diffHours = timeDifferenceMilliseconds / (60 * 60 * 1000);
            long diffDays = timeDifferenceMilliseconds / (60 * 60 * 1000 * 24);
            long diffWeeks = timeDifferenceMilliseconds / (60 * 60 * 1000 * 24 * 7);
            long diffMonths = (long) (timeDifferenceMilliseconds / (60 * 60 * 1000 * 24 * 30.41666666));
            long diffYears = timeDifferenceMilliseconds / ((long)60 * 60 * 1000 * 24 * 365);


        }*/

        System.out.println(formatter.format(dateDiff));


        System.out.println("Days                 Years                  Months                  Days");
        System.out.println("========            =======                 =======               ========\n");
        for (Map.Entry entry : dateDiff.entrySet()) { System.out.println(entry.getKey() + "" + entry.getValue());
            output.fileWrite(entry.getKey() + "" + entry.getValue()); } output.fileClose();
    }

}

