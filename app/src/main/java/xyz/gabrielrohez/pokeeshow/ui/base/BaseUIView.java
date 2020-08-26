package xyz.gabrielrohez.pokeeshow.ui.base;

public interface BaseUIView {
    void showLoader(boolean visible);
    void showDialog(int drawable, String message);
    void showDialog(int drawable, int resId);

}
