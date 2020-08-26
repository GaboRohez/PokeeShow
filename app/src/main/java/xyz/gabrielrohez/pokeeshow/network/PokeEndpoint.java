package xyz.gabrielrohez.pokeeshow.network;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;
import xyz.gabrielrohez.pokeeshow.network.model.PokeResponse;

public interface PokeEndpoint {

    @GET("pokemon")
    Single<PokeResponse> getPokemons(@Query("offset") int offset, @Query("limit") int limit);
}
