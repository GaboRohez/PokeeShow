package xyz.gabrielrohez.pokeeshow.ui.base;

import androidx.fragment.app.Fragment;

public interface BaseView {
    void showLoader(boolean visible);
    void showDialog(int drawable, String message);
    void addFragment(Fragment fragment);
    void replaceFragment(Fragment fragment);
}
