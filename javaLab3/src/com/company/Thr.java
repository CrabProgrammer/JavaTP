package com.company;

import java.util.ArrayList;


public class Thr {
    public static ArrayList<String> RESULT = new ArrayList<>();
    public static void Stream(String url,int countOfThreads,ArrayList<String> u1,int depth){
        Thread[] ThrArray = new Thread[countOfThreads];
        RESULT.add(url+ " 0");
        for(int i=0;i<ThrArray.length;i++){
            int k=i;
            ThrArray[i]=new Thread(new Runnable() {
                @Override
                public void run() {
                    ArrayList<String> UrlArr = new ArrayList<>();
                    ArrayList<String> response = new ArrayList<>();
                    String[] stringArray = u1.get(k).split("1split1");
                    for(int j=1;j<stringArray.length;j++){
                        UrlArr.add(stringArray[j]);
                        RESULT.add(stringArray[j]);
                    }
                    response = Parser.URLSTREAM(UrlArr,depth);
                    for(int i = 0;i<response.size();i++){
                        RESULT.add(response.get(i));
                    }
                    System.out.println(k+1 + " поток выполнен");
                }
            });
            ThrArray[i].setName("Stream"+i);
            ThrArray[i].start();
        }
        int endPoint=0;
        boolean check=true;
        while(check){
            for(int i=0;i<countOfThreads;i++) {
                if(!ThrArray[i].isAlive())
                    endPoint++;
            }
            if(endPoint==countOfThreads){
                System.out.println("Вывод: ");
                for(int i=0;i<RESULT.size();i++){
                    System.out.println(RESULT.get(i));
                }
                check=false;
            }
            endPoint=0;
        }
    }

}
