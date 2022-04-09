package user11681.jsont;

import java.lang.annotation.Repeatable;
import user11681.plugin.processing.annotation.Key;
import user11681.plugin.processing.annotation.Pair;

@Key("contact")
@Pair(key = "key", value = "value")
@Repeatable(Contact.Repeatable.class)
public @interface Contact {
    String key();

    String value();

    @interface Repeatable {
        Contact[] value();
    }
}
