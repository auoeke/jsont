package user11681.jsont;

import java.lang.annotation.Repeatable;
import user11681.plugin.processing.annotation.Alias;

@Repeatable(Mixins.Repeatable.class)
public @interface Mixins {
    @Alias("mixins")
    String[] value();

    @interface Repeatable {
        Mixins[] value();
    }
}
