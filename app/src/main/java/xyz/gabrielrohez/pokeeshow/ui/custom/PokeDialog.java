package xyz.gabrielrohez.pokeeshow.ui.custom;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;

import androidx.appcompat.app.AppCompatDialog;
import androidx.core.content.ContextCompat;

import com.bumptech.glide.Glide;

import xyz.gabrielrohez.pokeeshow.databinding.PokeDialogLayoutBinding;
import xyz.gabrielrohez.pokeeshow.utils.AppConstants;

public class PokeDialog extends AppCompatDialog {

    private int color;
    private String message;

    public PokeDialog(Context context, String message, int color) {
        super(context);
        this.message = message;
        this.color = color;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (super.getWindow() != null)
            super.getWindow().setBackgroundDrawable(new ColorDrawable(0));

        if (savedInstanceState == null) {
            setCancelable(false);
            PokeDialogLayoutBinding binding = PokeDialogLayoutBinding.inflate(LayoutInflater.from(getContext()), null, false);
            this.setContentView(binding.getRoot());

            binding.tvMessage.setText(message);
            binding.btnAccept.getBackground().setColorFilter(ContextCompat.getColor(getContext(), color), PorterDuff.Mode.MULTIPLY);

            binding.btnAccept.setOnClickListener(v -> dismiss());
        }

    }

    public void show() {
        if (!this.isShowing()) {
            super.show();
        }
    }
}
