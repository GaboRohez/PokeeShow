package xyz.gabrielrohez.pokeeshow.ui.menu.presenter;

import java.util.List;

import io.reactivex.Single;
import io.reactivex.disposables.Disposable;
import xyz.gabrielrohez.pokeeshow.network.model.PokeResponse;
import xyz.gabrielrohez.pokeeshow.network.model.ResultsEntity;
import xyz.gabrielrohez.pokeeshow.ui.base.BaseView;

public interface MenuContract {

    interface View extends BaseView {
        void setPokeList(List<ResultsEntity> result);
    }

    interface Presenter {
        void getPokemonList();
    }

    interface Interactor {
        Single<PokeResponse> getPokemonList(int offset, int limit);
    }

}
