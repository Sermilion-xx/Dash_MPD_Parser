package reddit.com.mdpparser.data.model;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Root;

@Root(name = "Initialization")
public class SimpleDashManifestContract implements Initialization {

    @Attribute()
    private final String range;

    public SimpleDashManifestContract(String range) {
        this.range = range;
    }

    public SimpleDashManifestContract() {
        this.range = null;
    }
}
