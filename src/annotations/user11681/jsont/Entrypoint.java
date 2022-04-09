package user11681.jsont;

import java.lang.annotation.Repeatable;
import user11681.plugin.processing.annotation.Key;

@Key(Entrypoint.KEY)
@Repeatable(Entrypoint.Repeatable.class)
public @interface Entrypoint {
    String KEY = "entrypoint";

    String[] value();

    @interface Repeatable {
        Entrypoint[] value();
    }
}
