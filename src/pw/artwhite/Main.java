package pw.artwhite;

import java.io.DataOutputStream;
import java.io.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.Buffer;
import java.util.Random;

/**
 * Created by g15oit18 on 28.04.2017.
 */
public class Main {
    public static void main(String[] args) throws IOException {

        Random randnum = new Random();

        File file = new File("intdata.dat");
        BufferedWriter writeNums = new BufferedWriter(new FileWriter(file));

        for (int i = 0; i < 100; i++){
            writeNums.write(String.valueOf(randnum.nextInt(1000000))+"\r\n");
        }
        writeNums.close();

        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
    }


}
