package unit2collections;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class fileInput {
    private BufferedReader in = null; //BufferedReader to read from file
    private String fileName;

    //constructor for fileInput class
    public fileInput(String fileName) {
        this.fileName = fileName;

        //FileInputReader used to read from file
        try {
            in = new BufferedReader(new FileReader(fileName));
        } catch (FileNotFoundException e){
            System.out.println("Error, cannot open file: " + fileName + " " + e);
        }
    }

    public void fileRead() {
    //This method reads input from file and prints on to the console
        String line;
        try {
            while ((line = in.readLine()) != null){
                System.out.println(line);
            }
        }catch (Exception e){
            System.out.println("Error, cannot open file: " + fileName + " " + e);
        }
    }

    public String fileReadLine() {
    //This method reads input line by line and returns as a string
        try{
            String line = in.readLine();
            return line;
        } catch (Exception e) {
            System.out.println("Error, cannot open file: " + fileName + " " + e);
            return null;
        }
    }

    public void fileClose(){
    //This method is used to safely close the opened file for reading
        if(in != null) {
            try{
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
