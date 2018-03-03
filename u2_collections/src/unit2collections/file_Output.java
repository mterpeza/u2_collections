package unit2collections;

import java.io.*;

//This class is used to write output to a file
public class file_Output {

    Writer out = null;
    private String fileName;

    public file_Output(String filename) {
        this.fileName = filename;
        try {
            //FileOutputStream class is used to direct output to a file
            out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName)));
        } catch (FileNotFoundException e) {
            System.out.println("Error, cannot open file: " + fileName + " " + e);
        }
    }

    public void fileWrite(String line) {
        //Writes output to a file line by line
        try {
            out.write(line + "\n");
        } catch (Exception e) {
            System.out.println("Error, cannot open file: " + fileName + " " + e);
        }
    }

    public void fileClose() {
        //To safely close the file
        if (out != null) {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
