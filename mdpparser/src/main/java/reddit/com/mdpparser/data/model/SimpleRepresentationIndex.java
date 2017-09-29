package reddit.com.mdpparser.data.model;

import org.jetbrains.annotations.NotNull;
import org.simpleframework.xml.Attribute;

public class SimpleRepresentationIndex implements RepresentationIndex {

    @Attribute()
    private final String sourceURL;

    public SimpleRepresentationIndex() {
        this.sourceURL = null;
    }

    public SimpleRepresentationIndex(String sourceURL) {
        this.sourceURL = sourceURL;
    }

    @NotNull
    @Override
    public String getSourceURL() {
        return sourceURL;
    }
}
