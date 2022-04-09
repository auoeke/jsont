package user11681.jsont;

import java.lang.annotation.Repeatable;
import user11681.plugin.processing.annotation.Alias;

@Repeatable(License.Repeatable.class)
public @interface License {
    @Alias("license")
    String[] value();

    @interface Repeatable {
        License[] value();
    }
}
