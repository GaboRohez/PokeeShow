package xyz.gabrielrohez.pokeeshow.network.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PokeResponse {

    @SerializedName("results")
    private List<ResultsEntity> results;

    public List<ResultsEntity> getResults() {
        return results;
    }

    public void setResults(List<ResultsEntity> results) {
        this.results = results;
    }

    @Override
    public String toString() {
        return "PokeResponse{" +
                "results=" + results +
                '}';
    }
}
