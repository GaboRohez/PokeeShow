package xyz.gabrielrohez.pokeeshow.ui.base;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import xyz.gabrielrohez.pokeeshow.R;
import xyz.gabrielrohez.pokeeshow.ui.custom.PokeDialog;
import xyz.gabrielrohez.pokeeshow.ui.custom.PokeLoader;

/**
 * Helper class for Viewer based on MVP pattern and View Binding
 *
 * @param <T> - Presenter Class </T>
 * @param <B> - ViewBinding Class </B>
 */

public abstract class BaseFragment<T, B> extends Fragment implements BaseView{

    protected T presenter;
    protected B binding;

    private PokeLoader loader;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onDestroy() {

        if (binding != null) {
            binding = null;
        }

        if (presenter != null) {
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
        PokeDialog dialog = new PokeDialog(requireContext(), message, drawable);
        dialog.show();
    }

    @Override
    public void showDialog(int drawable, int resId) {
        PokeDialog dialog = new PokeDialog(requireContext(), getString(resId), drawable);
        dialog.show();
    }

    @Override
    public void addFragment(Fragment fragment) {
        getChildFragmentManager().beginTransaction()
                .add(R.id.contentFragment, fragment, fragment.toString())
                .addToBackStack(fragment.toString())
                .commitAllowingStateLoss();
    }

    @Override
    public void replaceFragment(Fragment fragment) {
        getChildFragmentManager().beginTransaction()
                .replace(R.id.contentFragment, fragment, fragment.toString())
                .commit();
    }

    private PokeLoader getLoader() {
        if (loader != null)
            return loader;
        else
            return loader = new PokeLoader(requireContext());
    }

}