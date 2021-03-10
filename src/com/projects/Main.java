package com.projects;

public class Main {

    public static void main(String[] args) {
        String[] urls =  {"https://www.x-kom.pl/p/575294-smartfon-telefon-xiaomi-redmi-9-3-32gb-carbon-grey-nfc.html",
        "https://www.x-kom.pl/p/575297-smartfon-telefon-xiaomi-redmi-9-3-32gb-sunset-purple-nfc.html",
        "https://www.x-kom.pl/p/591861-smartfon-telefon-motorola-moto-e7-plus-4-64gb-twilight-orange.html",
        "https://www.x-kom.pl/p/575296-smartfon-telefon-xiaomi-redmi-9-3-32gb-ocean-green-nfc.html",
        "https://www.x-kom.pl/p/590362-smartfon-telefon-motorola-moto-e7-plus-4-64gb-misty-blue.html",
        "https://www.x-kom.pl/p/566039-smartfon-telefon-oppo-a12-3-32gb-dual-sim-niebieski.html",
        "https://www.x-kom.pl/p/554545-smartfon-telefon-alcatel-1s-2020-nfc-zielony.html#Opinie",
        "https://www.x-kom.pl/p/571809-smartfon-telefon-ulefone-armor-x7-pro-4-32gb-dual-sim-lte-czarny.html",
        "https://www.x-kom.pl/p/554543-smartfon-telefon-alcatel-1s-2020-nfc-szary.html#Opinie",
        "https://www.x-kom.pl/p/533617-smartfon-telefon-krugermatz-flow-7s-3-32gb-niebieski.html"};

        String[] urls2 = {"https://www.euro.com.pl/telefony-komorkowe/oppo-smartfon-a12-4-64gb-niebieski-oppo.bhtml",
        "https://www.euro.com.pl/telefony-komorkowe/samsung-smartfon-galaxy-m11-niebieski-samsung.bhtml",
        "https://www.euro.com.pl/telefony-komorkowe/motorola-smartfon-moto-e7-plus-4-64gb-ds-m-blue.bhtml",
        "https://www.euro.com.pl/telefony-komorkowe/xiaomi-smartfon-redmi-9-3-32-suns-purp-xiaomi.bhtml",
        "https://www.euro.com.pl/telefony-komorkowe/samsung-smartfon-galaxy-m11-czarny-samsung.bhtml",
        "https://www.euro.com.pl/telefony-komorkowe/xiaomi-smartfon-redmi-9c-3-64-m-gray-xiaomi.bhtml",
        "https://www.euro.com.pl/telefony-komorkowe/xiaomi-smartfon-redmi-9-3-32-carb-grey-xiaomi.bhtml",
        "https://www.euro.com.pl/telefony-komorkowe/samsung-smartfon-galaxy-a20e-black-samsung.bhtml",
        "https://www.euro.com.pl/telefony-komorkowe/oppo-smartfon-a12-3-32gb-czarny-oppo.bhtml",
        "https://www.euro.com.pl/telefony-komorkowe/xiaomi-smartfon-redmi-9-3-32-ocean-green-xiaomi.bhtml",
        "https://www.euro.com.pl/telefony-komorkowe/motorola-smartfon-moto-e7-plus-4-64gb-ds-t-oran.bhtml",
        "https://www.euro.com.pl/telefony-komorkowe/oppo-smartfon-a12-4-64gb-czarny-oppo.bhtml",
        "https://www.euro.com.pl/telefony-komorkowe/xiaomi-smartfon-redmi-9c-3-64-blue-xiaomi.bhtml",
        "https://www.euro.com.pl/telefony-komorkowe/alcatel-smartfon-alcatel-1s-2020-zielony.bhtml",
        "https://www.euro.com.pl/telefony-komorkowe/-smartfon-vivo-y11s-glacier-blue.bhtml",
        "https://www.euro.com.pl/telefony-komorkowe/alcatel-smartfon-alcatel-3l-2020-czarno-niebies.bhtml",
        "https://www.euro.com.pl/telefony-komorkowe/oppo-smartfon-a12-3-32gb-niebieski-oppo.bhtml"};

        String[] xiaomi = {"https://www.x-kom.pl/p/575294-smartfon-telefon-xiaomi-redmi-9-3-32gb-carbon-grey-nfc.html",
                "https://www.x-kom.pl/p/575297-smartfon-telefon-xiaomi-redmi-9-3-32gb-sunset-purple-nfc.html",
                "https://www.x-kom.pl/p/575296-smartfon-telefon-xiaomi-redmi-9-3-32gb-ocean-green-nfc.html",
                "https://www.euro.com.pl/telefony-komorkowe/xiaomi-smartfon-redmi-9-3-32-suns-purp-xiaomi.bhtml",
                "https://www.euro.com.pl/telefony-komorkowe/xiaomi-smartfon-redmi-9c-3-64-m-gray-xiaomi.bhtml",
                "https://www.euro.com.pl/telefony-komorkowe/xiaomi-smartfon-redmi-9-3-32-carb-grey-xiaomi.bhtml",
                "https://www.euro.com.pl/telefony-komorkowe/xiaomi-smartfon-redmi-9-3-32-ocean-green-xiaomi.bhtml",
                "https://www.euro.com.pl/telefony-komorkowe/xiaomi-smartfon-redmi-9c-3-64-blue-xiaomi.bhtml"};

        //Here you can put multiple files
        Thread t1 = new Thread(new ThreadProgram(urls, "src/com/projects/test.txt"));
        Thread t2 = new Thread(new ThreadProgram(urls2, "src/com/projects/test2.txt"));
        Thread t3 = new Thread(new ThreadProgram(xiaomi, "src/com/projects/xiaomi.txt"));


        t1.start();
        t2.start();
        t3.start();
        try{
            t1.join();
            t2.join();
            t3.join();
        } catch (Exception ex){
            System.out.println("Exception");
        }

    }
}
