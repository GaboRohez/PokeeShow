package xyz.gabrielrohez.pokeeshow.ui.menu.presenter;

import xyz.gabrielrohez.pokeeshow.ui.base.BasePresenter;
import xyz.gabrielrohez.pokeeshow.ui.menu.interactor.MenuInteractor;

public class MenuPresenter extends BasePresenter<MenuContract.View> implements MenuContract.Presenter{

    private MenuContract.Interactor interactor;

    public MenuPresenter(MenuContract.View view) {
        super(view);
        interactor = new MenuInteractor();
    }
}
