package com.company;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        LinkedList<Country> countriesList = new LinkedList<>();
        String buffer = "";
        //считываем файл с на диске
        try (FileReader in = new FileReader("C:\\Users\\Таня\\Desktop\\4 курс\\Жава\\javaLab2\\country.txt"))
        {
            int value;
            while ((value = in.read()) != -1) //когда читаем, пропускаем все запятые
            {
                if ((char)value == ',')
                {
                    continue;
                }
                buffer += (char)value;
            }
        }
        catch(IOException ex)
        {
            System.out.println(ex.getMessage());
        }

        //разделяем по строкам
        String[] textLine = buffer.split("\n");
        for (int i = 0; i < textLine.length; i++)
        {
            String[] record = textLine[i].split("\t");
            if (record.length != 4) //если неверная строка, то пропускаем
                continue;
            String name = record[0];
            int immigrants = Integer.parseInt(record[1]);
            float total = Float.parseFloat(record[2]);
            float national = Float.parseFloat(record[3]);
            //запоминаем каждую ячейку и добавляем в список стран
            Country country = new Country(name, immigrants, total, national);
            countriesList.add(country);
        }

        Collections.sort(countriesList); //сортируем

        int totalImmigrants = 0;
        float totalPercent = 0;
        ArrayList<Integer> listCount = new ArrayList<>(countriesList.size());

        System.out.printf("%-25s%-20s%-15s%-15s%n", "Country", "Immigrants", "% world total", "% population");
        for (Country country : countriesList) //перебираем все страны
        {
            String name = country.getName();
            int immigrants = country.getImmigrants();
            float total = country.getTotal();
            float national = country.getNational();
            System.out.printf("%-25s%-20s%-15s%-15s%n", name, immigrants, total, national);
            //подсчитываем общие значения
            totalImmigrants += immigrants;
            totalPercent += total;
            listCount.add((int)Math.round(immigrants * 100.0 / national));
        }

        //выводим результат
        System.out.println();
        System.out.println("Total immigrants: " + Integer.toString(totalImmigrants));
        System.out.println("Total percentage of world's immigrants: " + Float.toString(totalPercent));
        System.out.println("Country with greatest immigration: " + countriesList.get(0).getName());
        System.out.println("Country with least immigration: " + countriesList.get(countriesList.size()-1).getName());
        System.out.println("Total estimated population of all countries:");
        for (int i = 0; i < countriesList.size(); i++)
            System.out.println(countriesList.get(i).getName() + ": " + Integer.toString(listCount.get(i)));
    }
}


