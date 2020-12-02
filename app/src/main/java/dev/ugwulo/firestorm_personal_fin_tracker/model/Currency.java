package dev.ugwulo.firestorm_personal_fin_tracker.model;
import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties
public class Currency {
    public String symbol;
    public boolean left;
    public boolean space;

    public Currency() {

    }

    public Currency(String symbol, boolean left, boolean space) {
        this.symbol = symbol;
        this.left=left;
        this.space=space;
    }
}
