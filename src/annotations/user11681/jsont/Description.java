package user11681.jsont;

import user11681.plugin.processing.annotation.Key;

@Key(Description.KEY)
public @interface Description {
    String KEY = "description";

    String value();
}
