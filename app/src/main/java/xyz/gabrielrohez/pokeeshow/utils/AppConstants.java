package xyz.gabrielrohez.pokeeshow.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import xyz.gabrielrohez.pokeeshow.R;

public class AppConstants {

    public static final String IMAGE_EXTENSION = ".png";
    public static final String BASE_URL = "https://pokeapi.co/api/v2/";
    public static final String BASE_URL_IMAGE_FRONT = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/";
    public static final String BASE_URL_IMAGE_BACK = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/back/1.png";

    public enum POKE_ICON {

        POKEB(R.drawable.poke_b),
        POKEC(R.drawable.poke_c),
        POKED(R.drawable.poke_d),
        POKEE(R.drawable.poke_e),
        POKEF(R.drawable.poke_f),
        POKEG(R.drawable.poke_g),
        POKEH(R.drawable.poke_h),
        POKEI(R.drawable.poke_i);

        POKE_ICON(int image) {
            this.image = image;
        }

        int image;

        public int getImage() {
            return image;
        }

        private static final List<POKE_ICON> VALUES =
                Collections.unmodifiableList(Arrays.asList(values()));
        private static final int SIZE = VALUES.size();
        private static final Random RANDOM = new Random();

        public static POKE_ICON randomImage()  {
            return VALUES.get(RANDOM.nextInt(SIZE));
        }
    }
}
