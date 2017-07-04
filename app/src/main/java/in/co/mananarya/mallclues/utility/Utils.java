package in.co.mananarya.mallclues.utility;

import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by Manan Arya on 7/4/2017.
 */

public class Utils {
    private static FirebaseDatabase mDatabase;

    public static FirebaseDatabase getDatabase() {
        if (mDatabase == null) {
            mDatabase = FirebaseDatabase.getInstance();
            mDatabase.setPersistenceEnabled(true);
        }
        return mDatabase;
    }

}