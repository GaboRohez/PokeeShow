package xyz.gabrielrohez.pokeeshow.ui.menu.view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import xyz.gabrielrohez.pokeeshow.databinding.FragmentMenuBinding;
import xyz.gabrielrohez.pokeeshow.network.model.ResultsEntity;
import xyz.gabrielrohez.pokeeshow.ui.adapter.PokeAdapter;
import xyz.gabrielrohez.pokeeshow.ui.base.BaseFragment;
import xyz.gabrielrohez.pokeeshow.ui.menu.presenter.MenuContract;
import xyz.gabrielrohez.pokeeshow.ui.menu.presenter.MenuPresenter;

public class MenuFragment extends BaseFragment<MenuContract.Presenter, FragmentMenuBinding> implements MenuContract.View, PokeAdapter.PokeIn {

    private int offset;
    private PokeAdapter adapter;
    private boolean suitableForLoading = false;

    private static final String TAG = "MenuFragment";

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
        setUpRecycler();
    }

    private void setUpRecycler() {
        adapter = new PokeAdapter(requireContext(), this);
        GridLayoutManager layoutManager = new GridLayoutManager(requireContext(), 3);
        binding.recycler.setLayoutManager(layoutManager);
        binding.recycler.setHasFixedSize(true);
        binding.recycler.setAdapter(adapter);
        binding.recycler.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                if (dy > 0) {
                    int visibleItemCount = layoutManager.getChildCount();
                    int totalItemCount = layoutManager.getItemCount();
                    int pastVisibleItems = layoutManager.findFirstVisibleItemPosition();

                    if (suitableForLoading) {
                        if ((visibleItemCount + pastVisibleItems) >= totalItemCount) {
                            Log.i(TAG, "Te end of recycler.");

                            suitableForLoading = false;
                            offset += 20;
                            presenter.getPokemonList(offset);
                        }
                    }
                }
            }
        });

        offset = 0;
        suitableForLoading = true;
        presenter.getPokemonList(offset);

    }

    @Override
    public void setPokeList(List<ResultsEntity> result) {
        suitableForLoading = true;
        adapter.addPokeList((ArrayList<ResultsEntity>) result);
    }

    @Override
    public void onPokemonClick(ResultsEntity pokemon) {
        Toast.makeText(requireContext(), pokemon.getName(), Toast.LENGTH_SHORT).show();
    }
}