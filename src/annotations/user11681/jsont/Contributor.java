package user11681.jsont;

import java.lang.annotation.Repeatable;
import user11681.plugin.processing.annotation.Key;
import user11681.plugin.processing.annotation.Pair;

@Key(Contributor.KEY)
@Pair(key = "value", value = "contact")
@Repeatable(Contributor.Repeatable.class)
public @interface Contributor {
    String KEY = "contributors";

    String value();

    @Pair(value = "value", key = "key")
    Contact[] contact() default {};

    @interface Repeatable {
        Contributor[] value();
    }
}
