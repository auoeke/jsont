package user11681.jsont;

import java.lang.annotation.Repeatable;
import user11681.plugin.processing.annotation.Key;

@Key("languageAdapters")
@Repeatable(Adapter.Repeatable.class)
public @interface Adapter {
    String value();

    @interface Repeatable {
        Adapter[] value();
    }
}
