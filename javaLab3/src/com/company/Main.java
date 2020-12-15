package com.company;

import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        //вводим начальные параметры
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter URL: ");
        String URLString = scanner.nextLine();
        System.out.print("Enter depth: ");
        int depth=scanner.nextInt();
        System.out.print("Enter count of threads: ");
        int countOfThreads = scanner.nextInt();
        ArrayList<String> depthOneUrl = Parser.FirstUrlList(URLString,0); //добавляем нулевую ссылку в список
        ArrayList<String> depthOneNumber = new ArrayList<>();
        for(int j=0;j< countOfThreads;j++)
            depthOneNumber.add("1");
        int s = 0;
        int p =0;
        while(s!=depthOneUrl.size()-1){ //разбиваем на потоки
            String k = depthOneNumber.get(p)+"1split1"+ depthOneUrl.get(s);
            depthOneNumber.set(p,k);
            s++;
            p++;
            if(p==countOfThreads)
                p=0;
            k="";
        }
        //запускаем потоки
        Thr.Stream(URLString,countOfThreads,depthOneNumber,depth);
    }
}
