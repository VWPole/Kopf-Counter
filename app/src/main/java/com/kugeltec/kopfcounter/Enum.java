package com.kugeltec.kopfcounter;

/**
 * Created by Karol on 14.08.2016.
 */
public class Enum {
    public enum Places {
        HOME(1),
        FRIENDS(2),
        BAR(3),
        OTHER(4);

        int id;

        Places(int id) {
            this.id = id;
        }

        int getId() {
            return id;
        }
    }
}
