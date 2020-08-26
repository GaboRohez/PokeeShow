package xyz.gabrielrohez.pokeeshow.ui.base;

public interface BaseUIListener {
    void showLoader(boolean visible);
    void showDialog(int drawable, String message);
    void showDialog(int drawable, int resId);
}
