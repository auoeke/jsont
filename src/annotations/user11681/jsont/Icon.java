package user11681.jsont;

import java.lang.annotation.Repeatable;
import user11681.plugin.processing.annotation.Key;

@Key(Icon.KEY)
@Repeatable(Icon.Repeatable.class)
public @interface Icon {
    String KEY = "icon";

    String value();

    int length() default -1;

    @interface Repeatable {
        Icon[] value();
    }
}
