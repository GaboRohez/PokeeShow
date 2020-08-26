package xyz.gabrielrohez.pokeeshow.ui.menu.presenter;

import android.util.Log;

import xyz.gabrielrohez.pokeeshow.R;
import xyz.gabrielrohez.pokeeshow.ui.base.BasePresenter;
import xyz.gabrielrohez.pokeeshow.ui.menu.interactor.MenuInteractor;

public class MenuPresenter extends BasePresenter<MenuContract.View> implements MenuContract.Presenter{

    private static final String TAG = "MenuPresenter";

    private MenuContract.Interactor interactor;

    public MenuPresenter(MenuContract.View view) {
        super(view);
        interactor = new MenuInteractor();
    }

    @Override
    public void getPokemonList() {
        int offset = 0;
        int limit = 20;
        addSubscription(interactor.getPokemonList(offset, limit)
                .doOnSubscribe(disposable -> view.showLoader(true))
                .doAfterTerminate(() -> view.showLoader(false))
                .subscribe(response -> {
                    Log.d(TAG, "getPokemonList: "+response.getResults().toString());
                    Log.d(TAG, "getPokemonList: "+response.getResults().get(5).getNumber());
                }, throwable -> view.showDialog(R.color.colorPrimary, processError(throwable))));
    }
}
