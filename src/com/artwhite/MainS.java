package com.artwhite;

import java.io.DataOutputStream;
import java.io.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.Buffer;
import java.util.Random;

/**
 * Created by g15oit18 on 28.04.2017.
 */
public class MainS {

    /**
     * Метод записывает рандомные числа в файл intdata.dat
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {

        DataOutputStream output = new DataOutputStream(new FileOutputStream("intdata.dat"));
        DataInputStream dataInputStream = new DataInputStream(new FileInputStream("intdata.dat"));

        for (int i = 0; i < 100; i++) {
            int rndNum = (int) (Math.random() * 1000000);
            output.writeBytes(rndNum + "\n");
            System.out.println(rndNum);
        }

        output.close();


    }


}
