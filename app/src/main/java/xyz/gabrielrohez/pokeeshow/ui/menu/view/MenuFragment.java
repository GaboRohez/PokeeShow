package xyz.gabrielrohez.pokeeshow.ui.menu.view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import xyz.gabrielrohez.pokeeshow.R;
import xyz.gabrielrohez.pokeeshow.databinding.FragmentMenuBinding;
import xyz.gabrielrohez.pokeeshow.ui.base.BaseFragment;
import xyz.gabrielrohez.pokeeshow.ui.menu.presenter.MenuContract;
import xyz.gabrielrohez.pokeeshow.ui.menu.presenter.MenuPresenter;

public class MenuFragment extends BaseFragment<MenuContract.Presenter, FragmentMenuBinding> implements MenuContract.View {

    public static MenuFragment newInstance() {
        MenuFragment fragment = new MenuFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new MenuPresenter(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentMenuBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        presenter.getPokemonList();
    }
}