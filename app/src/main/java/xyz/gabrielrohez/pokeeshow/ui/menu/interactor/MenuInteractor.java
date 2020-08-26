package xyz.gabrielrohez.pokeeshow.ui.menu.interactor;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import xyz.gabrielrohez.pokeeshow.network.PokeEndpoint;
import xyz.gabrielrohez.pokeeshow.network.RetrofitClient;
import xyz.gabrielrohez.pokeeshow.network.model.PokeResponse;
import xyz.gabrielrohez.pokeeshow.ui.menu.presenter.MenuContract;

public class MenuInteractor implements MenuContract.Interactor {

    @Override
    public Single<PokeResponse> getPokemonList(int offset, int limit) {
        return RetrofitClient.getInstance().retrofit
                .create(PokeEndpoint.class)
                .getPokemons(offset, limit)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
