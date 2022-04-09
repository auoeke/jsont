package user11681.jsont.relation;

import java.lang.annotation.Repeatable;
import user11681.plugin.processing.annotation.Expandable;
import user11681.plugin.processing.annotation.Key;
import user11681.plugin.processing.annotation.LazyArray;
import user11681.plugin.processing.annotation.Pair;

@Key(Suggests.KEY)
@Pair(key = "value", value = "version")
@Repeatable(Suggests.Repeatable.class)
public @interface Suggests {
    String KEY = "suggests";

    String value();

    @LazyArray
    @Expandable
    String[] version() default "*";

    @interface Repeatable {
        Suggests[] value();
    }
}
