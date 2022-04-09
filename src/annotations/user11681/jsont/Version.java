package user11681.jsont;

import user11681.plugin.processing.annotation.Alias;

public @interface Version {
    @Alias("version")
    String value();
}
