package user11681.jsont;

import java.lang.annotation.Repeatable;
import user11681.plugin.processing.annotation.Alias;
import user11681.plugin.processing.annotation.Key;
import user11681.plugin.processing.annotation.Merge;

@Repeatable(JAR.Repeatable.class)
public @interface JAR {
    @Key("file")
    @Merge
    @Alias("jars")
    String value();

    @interface Repeatable {
        JAR[] value();
    }
}
