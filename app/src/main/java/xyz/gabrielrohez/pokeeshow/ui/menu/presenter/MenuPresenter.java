package xyz.gabrielrohez.pokeeshow.ui.menu.presenter;

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
    public void getPokemonList(int offset) {
        int limit = 20;
        addSubscription(interactor.getPokemonList(offset, limit)
                .doOnSubscribe(disposable -> view.showLoader(true))
                .doAfterTerminate(() -> view.showLoader(false))
                .subscribe(response -> {
                    if (response.getResults() != null && !response.getResults().isEmpty()){
                        view.setPokeList(response.getResults());
                    }else {
                        view.showDialog(R.color.colorPrimary, "No more pokemon");
                    }
                }, throwable -> view.showDialog(R.color.colorPrimary, processError(throwable))));
    }
}
