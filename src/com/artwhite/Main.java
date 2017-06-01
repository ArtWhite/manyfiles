package com.artwhite;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by g15oit18 on 28.04.2017
 */
public class Main {

    /**
     * Метод создает файл intdata.dat
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        File file = new File("intdata.dat");
        DataInputStream dataInputStream = new DataInputStream(new FileInputStream(file));

        System.out.println(dataInputStream.readInt());
        dataInputStream.close();

    }
}
