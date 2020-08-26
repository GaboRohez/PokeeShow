package xyz.gabrielrohez.pokeeshow.ui.main;

import android.os.Bundle;

import xyz.gabrielrohez.pokeeshow.R;
import xyz.gabrielrohez.pokeeshow.ui.base.BaseActivity;
import xyz.gabrielrohez.pokeeshow.ui.menu.view.MenuFragment;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        replaceFragment(MenuFragment.newInstance());
    }
}