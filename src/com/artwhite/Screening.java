package com.artwhite;

import java.io.*;

/**
 * Created by artwhite on 26/05/2017.
 */
public class Screening {


    /**
     * Метод считывет числа из intdata.dat
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        zeroingOut();
        BufferedReader br = new BufferedReader(new FileReader("intdata.dat"));
        try { // считываем intdata.dat
            String x;
            while ( (x = br.readLine()) != null ) {
                int xToInt = Integer.parseInt(x.replaceAll("[\\D]", ""));
                if ( xToInt > 1000 & xToInt < 1000000 ){
                    CheckLucky(xToInt); // проверяем счастлыивый ли билет
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Метод обнуляет файл int6data.dat
     *
     * @throws IOException
     */
    private static void zeroingOut() throws IOException {
        try {
            FileWriter fstream1 = new FileWriter("int6data.txt");// конструктор с одним параметром - для перезаписи
            BufferedWriter out1 = new BufferedWriter(fstream1); //  создаём буферезированный поток
            out1.write(""); // очищаем, перезаписав поверх пустую строку
            out1.close(); // закрываем
        } catch (Exception e)
        {System.err.println("Error in file cleaning: " + e.getMessage());}
    }

    /**
     * Метод проверяет счастливый ли билет
     *
     * @param number
     * @throws IOException
     */
    public static void CheckLucky(int number) throws IOException {
        String numToStr = Integer.toString(number); // преобразуем number в строку
        int countOfNumbers = numToStr.length(); // из скольки знаков состоит число

        if (countOfNumbers<6){ // если число меньше 6 значного - прибавляем нули в начало
            numToStr = addZero(numToStr);
            number = Integer.parseInt(numToStr);
        }

        /*
        * Делим билет на две стороны
        * */
        int rightSide = number%1000;
        int leftSide = number/1000;
        /*
        * сравниваем их стороны
        * */
        if(sum(rightSide) == sum(leftSide)){
            System.out.println("Счастливый билет - " + number);
            writeNumInFile(number);
        }
    }

    /**
     * Метод записывает счастливые билеты в int6data.dat
     *
     * @param number
     * @throws IOException
     */
    private static void writeNumInFile(int number) throws IOException {
        DataOutputStream output = new DataOutputStream(new FileOutputStream("int6data.txt", true));
        output.writeBytes(number + "\n");
        output.close();
    }

    /**
     * Метод считает сумму стороны
     *
     * @param num
     * @return
     */
    private static int sum(int num) {
        return num % 10 + num / 10 %10 + num / 100%10;
    }

    /**
     * Метод добавляет нули в начало строки
     *
     * @param number
     * @return
     */
    private static String addZero(String number) {
        do {
            number="0"+number;
        }while(number.length() < 6);

        return number;
    }

}
