package com.eliseche.drinkingtime;

public class DrinkingTimeConstant {
    public static final String url = "https://addb.absolutdrinks.com";
    public static final String assets = "https://assets.absolutdrinks.com";
    public static final String apiKey = "a60d149381584495adc1e00991a9729e";
    public static final String videosAssets = assets + "/videos/{video}";
    public static final String videosYoutube = "http://www.youtube.com/watch?v={video}";
    public static final String drinks = url + "/drinks?apiKey=" + apiKey + "&start={start}&pageSize={pageSize}";
    public static final String quickSearch = url + "/quickSearch/drinks/{textToSearch}?apiKey=" + apiKey + "&start={start}&pageSize={pageSize}";
    public static final String tool = url + "/tools/{toolId}?apiKey=" + apiKey;
}
