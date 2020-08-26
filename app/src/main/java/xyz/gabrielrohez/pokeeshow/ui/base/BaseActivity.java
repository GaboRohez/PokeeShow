package xyz.gabrielrohez.pokeeshow.ui.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import xyz.gabrielrohez.pokeeshow.R;
import xyz.gabrielrohez.pokeeshow.ui.custom.PokeDialog;
import xyz.gabrielrohez.pokeeshow.ui.custom.PokeLoader;

public abstract class BaseActivity<P> extends AppCompatActivity implements BaseView {

    protected P presenter;
    private PokeLoader loader;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onDestroy() {
        if (presenter != null){
            ((BasePresenter) presenter).detachView();
        }
        super.onDestroy();
    }

    @Override
    public void showLoader(boolean visible) {
        if (visible)
            getLoader().show();
        else
            getLoader().dismiss();
    }

    @Override
    public void showDialog(int drawable, String message) {
        PokeDialog dialog = new PokeDialog(getApplicationContext(), message, drawable);
        dialog.show();
    }

    @Override
    public void addFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .add(R.id.contentFragment, fragment, fragment.toString())
                .addToBackStack(fragment.toString())
                .commitAllowingStateLoss();
    }

    @Override
    public void replaceFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.contentFragment, fragment, fragment.toString())
                .commit();
    }

    private PokeLoader getLoader() {
        if (loader != null)
            return loader;
        else
            return loader = new PokeLoader(this);
    }
}
