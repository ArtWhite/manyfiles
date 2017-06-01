package com.artwhite;

import java.io.*;

/**
 * Created by artwhite on 26/05/2017.
 */
public class Screening {




    public static void main(String[] args) throws IOException {
        zeroingOut();
        BufferedReader br = new BufferedReader(new FileReader("intdata.dat"));
        try {
            String x;
            while ( (x = br.readLine()) != null ) {
                int xToInt = Integer.parseInt(x.replaceAll("[\\D]", ""));
                if ( xToInt > 1000 & xToInt < 1000000 ){
                    CheckLucky(xToInt);
                }
                //System.out.println(x);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void zeroingOut() throws IOException {
        try {
            FileWriter fstream1 = new FileWriter("int6data.dat");// конструктор с одним параметром - для перезаписи
            BufferedWriter out1 = new BufferedWriter(fstream1); //  создаём буферезированный поток
            out1.write(""); // очищаем, перезаписав поверх пустую строку
            out1.close(); // закрываем
        } catch (Exception e)
        {System.err.println("Error in file cleaning: " + e.getMessage());}
    }

    public static void CheckLucky(int number) throws IOException {
        String numToStr = Integer.toString(number);
        int countOfNumbers = numToStr.length();

        if (countOfNumbers<6){
            numToStr = addZero(numToStr);
            number = Integer.parseInt(numToStr);
        }

        int rightSide = number%1000;
        int leftSide = number/1000;

        if(sum(rightSide) == sum(leftSide)){
            System.out.println("Счастливый билет - " + number);
            writeNumInFile(number);
        }

//        char[] splitted = Integer.toString(number).toCharArray();
//        for (int i = 0; i < splitted.length; i++){
//            System.out.println(splitted[i]);
//        }


    }

    private static void writeNumInFile(int number) throws IOException {
        DataOutputStream output = new DataOutputStream(new FileOutputStream("int6data.dat", true));
        output.writeBytes(number + "\n");
        output.close();
    }

    private static int sum(int num) {
        return num % 10 + num / 10 %10 + num / 100%10;
    }


    private static String addZero(String number) {
        do {
            number="0"+number;
        }while(number.length() < 6);

        return number;
    }

}
