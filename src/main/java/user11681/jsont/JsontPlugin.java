package user11681.jsont;

import com.google.gson.GsonBuilder;
import com.sun.source.util.JavacTask;
import java.io.OutputStream;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import javax.lang.model.element.Element;
import user11681.jsont.relation.Breaks;
import user11681.jsont.relation.Conflicts;
import user11681.jsont.relation.Depends;
import user11681.jsont.relation.Recommends;
import user11681.jsont.relation.Suggests;
import user11681.plugin.AbstractCompilerPlugin;
import user11681.plugin.processing.AnnotationContainer;
import user11681.plugin.processing.ExpansionOptions;

@SuppressWarnings("unchecked")
public class JsontPlugin extends AbstractCompilerPlugin {
    protected static final ExpansionOptions options = new ExpansionOptions().serialize();

    protected final Map<String, Object> elements = new LinkedHashMap<>(Map.of("schemaVersion", 1));

    public JsontPlugin() {
        super("jsont");
    }

    @Override
    public void init(JavacTask task, String... args) {
        super.init(task, args);

        this.note("JSON't javac plugin initialized");
    }

    @Override
    protected List<Class<?>> getAnnotationTypes() {
        return List.of(
            Adapter.class,
            Author.class,
            Breaks.class,
            Conflicts.class,
            Contact.class,
            Contributor.class,
            Custom.class,
            Depends.class,
            Description.class,
            Entrypoint.class,
            Side.class,
            Icon.class,
            ID.class,
            JAR.class,
            License.class,
            Mixins.class,
            Name.class,
            PrettyPrinting.class,
            Recommends.class,
            Suggests.class,
            Version.class
        );
    }

    @Override
    protected void processAnnotation(Element annotatedElement, AnnotationContainer annotation) throws Throwable {
        Map<String, Object> elements = annotation.elements(options);

        if (annotation.isType(Side.class)) {
            this.elements.put("environment", ((Map<String, String>) annotation.elements(options)).get("value").toLowerCase(Locale.ROOT));
        } else {
            if (annotation.isType(Custom.class)) {
                Map<String, Object> custom = (Map<String, Object>) elements.get(Custom.KEY);

                if (Boolean.FALSE.equals(custom.remove("array"))) {
                    Map.Entry<String, Object> entry = custom.entrySet().iterator().next();

                    if (((List<?>) entry.getValue()).size() == 1) {
                        entry.setValue(((List<?>) entry.getValue()).get(0));
                    }
                }
            }

            this.elements.putAll(elements);
        }
    }

    @Override
    protected void done() throws Throwable {
        GsonBuilder gsonBuilder = new GsonBuilder();

        if (!this.elements.containsKey(PrettyPrinting.KEY) || Boolean.TRUE.equals(this.elements.remove(PrettyPrinting.KEY))) {
            gsonBuilder.setPrettyPrinting();
        }

        try (OutputStream metadata = this.getOutputResource("fabric.mod.json").openOutputStream()) {
            metadata.write(gsonBuilder.create().toJson(this.elements).getBytes());
        }
    }
}
