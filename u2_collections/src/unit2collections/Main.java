package unit2collections;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.*;

public class Main {

    public static void main(String[] args) {
        try (Writer writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream("output.txt"), "utf-8"))) {
            try {
                String line;

                BufferedReader br = new BufferedReader(new FileReader("date_diff.csv"));

                while ((line = br.readLine()) != null) {
                    String  ans = lineprocessor(line),
                            day1 = "Day  ",
                            month1 = "Month  ",
                            year1 = "Year   ";

                    writer.write(day1 + " " + month1 + " " + year1 + " "  + "\n");
                    writer.write(ans + "\n");
                }

            } catch (FileNotFoundException e) {

                System.out.println("Error");
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch(Exception ed){
            System.out.println("Error");
            ed.printStackTrace();
        }


        // writer.close();
    }

    public static String lineprocessor(String data)
    {
        String pattern1 = "(\\d+)-(.{3})-(\\d{2})";
        String pattern2 = "\"(.{3}). (\\d+), (\\d{4})\"";
        String[] startDate = new String[3];
        String[] endDate = new String[3];
        System.out.println(data);
        Pattern pObj1 = Pattern.compile(pattern1);
        Pattern pObj2 = Pattern.compile(pattern2);

        int[] sDate = new int[3];
        int[] eDate = new int[3];

        if(data.charAt(0)!='\"')
        {
            Matcher m = pObj1.matcher(data);
            if(m.find())
            {
                String day = m.group(1);
                String month = m.group(2);
                String year = m.group(3);

                if(Integer.parseInt(year)>50)
                {
                    year = "19"+year;
                }
                else
                {
                    year = "20"+year;
                }

                startDate[0] = String.valueOf(day);
                startDate[1] = String.valueOf(month);
                startDate[2] = String.valueOf(year);
                System.out.println("Startdate: " + day + " " + month + " " + year);

                m = pObj1.matcher(data.substring(2));
                if(m.find()) {
                    day = m.group(1);
                    month = m.group(2);
                    year = m.group(3);

                    System.out.println("Enddate: " + day + " " + month + " " + year);

                    if (Integer.parseInt(year) > 50) {
                        year = "19" + year;
                    } else {
                        year = "20" + year;

                    }

                    endDate[0] = String.valueOf(day);
                    endDate[1] = String.valueOf(month);
                    endDate[2] = String.valueOf(year);
                }

                Matcher m2 = pObj2.matcher(data);
                if(m2.find())
                {
                    day = m2.group(2);
                    month = m2.group(1);
                    year = m2.group(3);
                    System.out.println("Enddate: " + day + " " + month + " " + year);
                    endDate[0] = String.valueOf(day);
                    endDate[1] = String.valueOf(month);
                    endDate[2] = String.valueOf(year);
                }
            }
        }

        else{
            Matcher m = pObj2.matcher(data);
            if(m.find())
            {
                String day = m.group(2);
                String month = m.group(1);
                String year = m.group(3);

                System.out.println("Startdate: " + day + " " + month + " " + year);

                startDate[0] = String.valueOf(day);
                startDate[1] = String.valueOf(month);
                startDate[2] = String.valueOf(year);
                m = pObj1.matcher(data);
                if(m.find()) {
                    day = m.group(1);
                    month = m.group(2);
                    year = m.group(3);

                    if (Integer.parseInt(year) > 50) {
                        year = "19" + year;
                    } else {
                        year = "20" + year;

                    }
                    System.out.println("Enddate: " + day + " " + month + " " + year);
                    endDate[0] = String.valueOf(day);
                    endDate[1] = String.valueOf(month);
                    endDate[2] = String.valueOf(year);
                }

                Matcher m2 = pObj2.matcher(data.substring(3));
                if(m2.find())
                {
                    day = m2.group(2);
                    month = m2.group(1);
                    year = m2.group(3);
                    endDate[0] = String.valueOf(day);
                    endDate[1] = String.valueOf(month);
                    endDate[2] = String.valueOf(year);
                    System.out.println("Enddate: " + day + " " + month + " " + year);
                }
            }
        }

        sDate[0] = Integer.parseInt(startDate[0]);
        sDate[1] = monthNumber(startDate[1]);
        sDate[2] = Integer.parseInt(startDate[2]);

        eDate[0] = Integer.parseInt(endDate[0]);
        eDate[1] = monthNumber(endDate[1]);
        eDate[2] = Integer.parseInt(endDate[2]);

        // difference between the dates
        int gDate = greaterDate(sDate, eDate);
        int[] diff;
        if(gDate == 2){
            // endDate is greater
            diff = calculateDiff(sDate, eDate);
        }
        else{
            // startDate is greater
            diff = calculateDiff(eDate, sDate);
        }
        // System.out.println("Days: " + diff[0] + " Months: " + diff[1] + " Years: " + diff[2]  + "\n");
        return String.valueOf(diff[2]     ) + "       " + String.valueOf(diff[1]) + "     " + String.valueOf(diff[0]);

    }

    public static int monthNumber(String monthName){
        if("Jan".equals(monthName)){
            return 1;
        }
        if("Feb".equals(monthName)){
            return 2;
        }
        if("Mar".equals(monthName)){
            return 3;
        }
        if("Apr".equals(monthName)){
            return 4;
        }
        if("May".equals(monthName)){
            return 5;
        }
        if("Jun".equals(monthName)){
            return 6;
        }
        if("Jul".equals(monthName)){
            return 7;
        }
        if("Aug".equals(monthName)){
            return 8;
        }
        if("Sep".equals(monthName)){
            return 9;
        }
        if("Oct".equals(monthName)){
            return 10;
        }
        if("Nov".equals(monthName)){
            return 11;
        }
        if("Dec".equals(monthName)){
            return 12;
        }
        return 1;
    }

    public static int greaterDate(int[] startDate, int[] endDate){
        if(endDate[2] > startDate[2]){
            return 2;
        }
        else if(endDate[2] < startDate[2]){
            return 1;
        }
        else{
            if(endDate[1] > startDate[1]){
                return 2;
            }
            else if(endDate[1] < startDate[1]){
                return 1;
            }
            else{
                if(endDate[0] > startDate[0]){
                    return 2;
                }
                else{
                    return 1;
                }
            }
        }
    }

    public static int[] calculateDiff(int[] startDate, int[] endDate){
        int[] diff = new int[3];
        diff[2] = endDate[2] - startDate[2];
        diff[1] = endDate[1] - startDate[1];
        diff[0] = endDate[0] - startDate[0];
        if(diff[0] < 0){
            diff[1]--;
            diff[0] += 31;
        }
        if(diff[1] < 0){
            diff[2]--;
            diff[1] += 12;
        }
        return diff;
    }
}
