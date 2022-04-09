package user11681.jsont;

import user11681.plugin.processing.annotation.Alias;

public @interface PrettyPrinting {
    String KEY = "pretty";

    @Alias(KEY)
    boolean value();
}
