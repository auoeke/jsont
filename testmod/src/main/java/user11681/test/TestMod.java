package user11681.test;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.LanguageAdapter;
import user11681.jsont.Adapter;
import user11681.jsont.Author;
import user11681.jsont.Contact;
import user11681.jsont.Contributor;
import user11681.jsont.Custom;
import user11681.jsont.Description;
import user11681.jsont.Entrypoint;
import user11681.jsont.Environment;
import user11681.jsont.ID;
import user11681.jsont.Icon;
import user11681.jsont.JAR;
import user11681.jsont.License;
import user11681.jsont.Mixins;
import user11681.jsont.Name;
import user11681.jsont.PrettyPrinting;
import user11681.jsont.Version;
import user11681.jsont.relation.Breaks;
import user11681.jsont.relation.Conflicts;
import user11681.jsont.relation.Depends;
import user11681.jsont.relation.Recommends;
import user11681.jsont.relation.Suggests;

@ID("test")
@Version("1.2.3")
@Name("test mod")
@Description("This is a test.")
@Icon("assets/test/icon.png")
@Icon(value = "assets/test/icon.png", length = 32)
@Contact(key = "issues", value = "https://github.com/user11681/???")
@Author(value = "user11681", contact = @Contact(key = "discord", value = "auoeke tjmnkrajyej#4096"))
@Contributor(value = "user18611", contact = @Contact(key = "homepage", value = "https://example.com"))
@Depends(value = "optifine", version = {"HD_U_G68"})
@Depends("thallium")
@Recommends(value = "fabriczero", version = "0.0.0")
@Suggests(value = "sodium", version = "0.3.0")
@Breaks("canvas")
@License({"ARR", "Unlicense"})
@Mixins("mixins.json")
@Conflicts("fabric")
@Custom(key = "modmenu:api", value = "false")
@JAR("META-INF/jars/some.jar")
@Adapter("gfh")
@Adapter("clojure")
@Entrypoint("relaunch")
@Entrypoint("main")
@PrettyPrinting(true)
public abstract class TestMod implements ModInitializer, LanguageAdapter {}

@Entrypoint("client")
// user11681.jsont.Environment: an alternative to net.fabricmc.api.Environment that accepts a String and is verified during compilation
@Environment("client")
abstract class ClientMod implements ClientModInitializer {}
