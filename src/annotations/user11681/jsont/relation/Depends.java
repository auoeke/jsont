package user11681.jsont.relation;

import java.lang.annotation.Repeatable;
import user11681.plugin.processing.annotation.Expandable;
import user11681.plugin.processing.annotation.Key;
import user11681.plugin.processing.annotation.LazyArray;
import user11681.plugin.processing.annotation.Pair;

@Key(Depends.KEY)
@Pair(key = "value", value = "version")
@Repeatable(Depends.Repeatable.class)
public @interface Depends {
    String KEY = "depends";

    String value();

    @LazyArray
    @Expandable
    String[] version() default "*";

    @interface Repeatable {
        Depends[] value();
    }
}
