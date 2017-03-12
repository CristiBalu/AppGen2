package fbhack.martaungureanu.appgen.utils;

import java.util.HashMap;

/**
 * Created by crist on 12/03/2017.
 */

public class SingletonHashmap {
    private static SingletonHashmap instance;
    private static HashMap<String, Model> hashMap;

    private SingletonHashmap() {
        hashMap = new HashMap<>();
    }

    public static SingletonHashmap getInstance() {
        if(instance == null) {
            instance = new SingletonHashmap();
        }

        return instance;
    }

    public static HashMap<String, Model> getHashMap() {
        return hashMap;
    }
}
