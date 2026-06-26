package org.nachhilfeplattform.util;

import org.nachhilfeplattform.model.Anbieter;

public class CurrentUser {

    private static Anbieter aktuellerAnbieter;

    public static void setAnbieter(Anbieter anbieter) {
        aktuellerAnbieter = anbieter;
    }

    public static Anbieter getAnbieter() {
        return aktuellerAnbieter;
    }

    public static boolean istEingeloggt() {
        return aktuellerAnbieter != null;
    }

    public static void logout() {
        aktuellerAnbieter = null;
    }
}