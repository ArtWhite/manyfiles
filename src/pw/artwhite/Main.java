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
        DataOutputStream writeNums = new DataOutputStream(new FileOutputStream(file));

        for (int i = 0; i < 2; i++){
            writeNums.write(randnum.nextInt(1000000));
       }
        writeNums.close();


    }


}
