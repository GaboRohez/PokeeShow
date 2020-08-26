package xyz.gabrielrohez.pokeeshow.ui.custom;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;

import androidx.appcompat.app.AppCompatDialog;

import xyz.gabrielrohez.pokeeshow.databinding.PokeLoaderLayoutBinding;

public class PokeLoader extends AppCompatDialog {

    public PokeLoader(Context context) {
        super(context);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (super.getWindow() != null)
            super.getWindow().setBackgroundDrawable(new ColorDrawable(0));

        if (savedInstanceState == null) {
            setCancelable(false);
            PokeLoaderLayoutBinding binding = PokeLoaderLayoutBinding.inflate(LayoutInflater.from(getContext()), null, false);
            this.setContentView(binding.getRoot());
        }
    }

    public void show() {
        if (!this.isShowing()) {
            super.show();
        }
    }

    public void dismiss() {
        if (this.isShowing()) {
            super.dismiss();
        }
    }
}
