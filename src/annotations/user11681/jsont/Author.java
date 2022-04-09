package user11681.jsont;

import java.lang.annotation.Repeatable;
import user11681.plugin.processing.annotation.Key;
import user11681.plugin.processing.annotation.Pair;

@Key("authors")
@Pair(key = "value", value = "contact")
@Repeatable(Author.Repeatable.class)
public @interface Author {
    String value();

    Contact[] contact() default {};

    @interface Repeatable {
        Author[] value();
    }
}
