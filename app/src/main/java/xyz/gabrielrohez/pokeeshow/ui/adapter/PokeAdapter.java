package xyz.gabrielrohez.pokeeshow.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import xyz.gabrielrohez.pokeeshow.databinding.ItemPokemonBinding;
import xyz.gabrielrohez.pokeeshow.network.model.ResultsEntity;
import xyz.gabrielrohez.pokeeshow.utils.AppConstants;

public class PokeAdapter extends RecyclerView.Adapter<PokeAdapter.ViewHolder> {

    private static PokeIn listener;
    private Context context;
    private static List<ResultsEntity> list;

    public PokeAdapter(Context context, List<ResultsEntity> list, PokeIn listener) {
        this.list = list;
        this.context = context;
        this.listener = listener;
    }

    public interface PokeIn {
        void onPokemonClick(ResultsEntity pokemon);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(ItemPokemonBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.binding.tvName.setText(list.get(position).getName());
        Glide.with(context)
                .load(AppConstants.BASE_URL_IMAGE_FRONT+list.get(position).getNumber()+AppConstants.IMAGE_EXTENSION)
                .into(holder.binding.ivPokemon);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private ItemPokemonBinding binding;

        public ViewHolder(ItemPokemonBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
            binding.getRoot().setOnClickListener(v -> listener.onPokemonClick(list.get(getAdapterPosition())));
        }
    }
}
