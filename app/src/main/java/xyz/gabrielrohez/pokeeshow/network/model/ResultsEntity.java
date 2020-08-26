package xyz.gabrielrohez.pokeeshow.network.model;

import com.google.gson.annotations.SerializedName;

public class ResultsEntity {
    @SerializedName("url")
    private String url;
    @SerializedName("name")
    private String name;
    private int number;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        String[] urlParts = url.split("/");
        return Integer.parseInt(urlParts[urlParts.length - 1]);
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "ResultsEntity{" +
                "url='" + url + '\'' +
                ", name='" + name + '\'' +
                ", number=" + number +
                '}';
    }
}
