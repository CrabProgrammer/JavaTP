package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    public static String result = "";
    public static ArrayList<String> URLSTREAM(ArrayList<String> urlList, int depth){
        for(int i=1;i<depth;i++){
            for(int j=0;j<urlList.size();j++){
                String[] y = urlList.get(j).split(" ");
                int currentDepth = Integer.parseInt(y[1]);
                if(currentDepth==i)
                    URLdepth(y[0],currentDepth,urlList);
            }
        }
        return urlList;
    }
    public static ArrayList<String> FirstUrlList(String url, int depth){
        ArrayList<String> Null = new ArrayList<>();
        URLdepth(url,depth,Null);
        return Null;
    }
    public static void URLdepth(String url, int depth,ArrayList<String> URLdepthArr) {
        ArrayList<Integer> D = new ArrayList<>();
        ArrayList<String> URLdepthhash = new ArrayList<>();
        try {
            URL http = new URL(url);
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(
                            http.openStream()));
            String inputLine;

            while ((inputLine = in.readLine()) != null)
                result += inputLine;
            in.close();
        } catch (IOException e) {
            System.out.println("java Crawler " + url + " " + depth);
        }
        String str1 = "";
        String aPattern = "<(a)\\b[^>]*>";
        Pattern REGEX = Pattern.compile(aPattern);
        Matcher matcher = REGEX.matcher(result);
        while (matcher.find()) {
            str1 += " " + matcher.group();
        }
        String httpPattern = "href=\\\"(.*?)\\\"";
        Pattern REGEX1 = Pattern.compile(httpPattern);
        Matcher matcher1 = REGEX1.matcher(str1);
        result = "";
        while (matcher1.find()) {
            if (matcher1.group().length() > 6) {
                if (matcher1.group().charAt(6) == '/' && matcher1.group().charAt(7) == '/') {
                    URLdepthhash.add("http:" + matcher1.group().substring(6, matcher1.group().length() - 1));
                    D.add(depth + 1);
                } else if (matcher1.group().charAt(6) == 'h')
                    URLdepthhash.add(matcher1.group().substring(6, matcher1.group().length() - 1));
                D.add(depth + 1);
            }
        }

        for(int i=0;i<URLdepthhash.size();i++){
            URLdepthArr.add(URLdepthhash.get(i)+" " + D.get(i));
        }
        URLdepthhash.clear();
        D.clear();
    }


}
