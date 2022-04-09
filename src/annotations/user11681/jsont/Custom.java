package user11681.jsont;

import java.lang.annotation.Repeatable;
import user11681.plugin.processing.annotation.Expandable;
import user11681.plugin.processing.annotation.Key;
import user11681.plugin.processing.annotation.Pair;

@Key(Custom.KEY)
@Pair(key = "key", value = "value")
@Repeatable(Custom.Repeatable.class)
public @interface Custom {
    String KEY = "custom";

    String key();

    String[] value();

    @Expandable
    boolean array() default false;

    @interface Repeatable {
        Custom[] value();
    }
}
