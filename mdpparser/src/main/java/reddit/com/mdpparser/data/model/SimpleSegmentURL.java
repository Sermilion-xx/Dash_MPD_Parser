package reddit.com.mdpparser.data.model;

import org.jetbrains.annotations.NotNull;
import org.simpleframework.xml.Attribute;

public class SimpleSegmentURL implements SegmentURL {

    @Attribute()
    private final String media;

    public SimpleSegmentURL(String media) {
        this.media = media;
    }

    public SimpleSegmentURL() {
        this.media = null;
    }

    @NotNull
    @Override
    public String getMedia() {
        return media;
    }
}
