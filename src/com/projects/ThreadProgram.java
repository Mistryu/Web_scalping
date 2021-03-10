package com.projects;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.*;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ThreadProgram implements Runnable{
    final private String[] web_list;
    final private String file_destination;

    public ThreadProgram(String[] web_list, String file_destination){
        this.web_list = web_list;
        this.file_destination = file_destination;
    }

    private static List<String> loader(String save_file) {
        List<String> list = new ArrayList<>();
        try(final var reader = new BufferedReader(new FileReader(save_file))){
            while (reader.ready())
                list.add(reader.readLine());

        }catch (IOException ex){
            ex.printStackTrace();
        }
        return list;
    }
    @Override
    public void run(){
        String css_class_name, css_class_cost;

        List<String> saves = loader(file_destination);

        try (final var writer = new BufferedWriter(new FileWriter(file_destination))) {
            int count = 0;
            for (String str : web_list) {
                switch (str.charAt(12)){
                    case 'x' -> {css_class_name = "div.sc-1bker4h-10.qvugG"; css_class_cost = "div.u7xnnm-4.jFbqvs";}
                    case 'k' -> {css_class_name = "title";
                        css_class_cost = "span.proper";}
                    case 'e' -> {css_class_name = "h1.product-name.selenium-KP-product-name"; css_class_cost = "euro";}
                    default -> {css_class_name = ""; css_class_cost = "";}
                }
                try {
                    Document doc = Jsoup.connect(str).get();
                    String name_str, cost_str = "";


                    if (!css_class_cost.equals("euro")) {
                        name_str = doc.select(css_class_name).first().wholeText();
                        cost_str = doc.select(css_class_cost).first().wholeText().trim();
                        if (name_str.contains("| cena, raty - sklep Komputronik.pl"))
                            name_str = name_str.replace("| cena, raty - sklep Komputronik.pl", "");
                    } else {
                        final String regex = "price : \"\\d*.\\d*\"";

                        final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
                        final Matcher matcher = pattern.matcher(doc.toString());

                        while (matcher.find()) {
                            cost_str = matcher.group(0).replace("price : ", "").replace("\"", "");
                        }
                        name_str = doc.select(css_class_name).first().wholeText().trim();
                    }

                    if (saves.size() <= count || saves.get(count).equals(name_str + "       " + cost_str))
                        writer.write(name_str + "       " + cost_str);
                    else
                        writer.write(saves.get(count) + "      " + cost_str);

                    writer.newLine();
                    count += 1;

                } catch (SocketTimeoutException ex ){
                    ex.printStackTrace();
                }
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
