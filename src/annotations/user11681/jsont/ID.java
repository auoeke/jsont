package user11681.jsont;

import user11681.plugin.processing.annotation.Alias;

public @interface ID {
    String KEY = "id";

    @Alias(KEY)
    String value();
}
