package reddit.com.mdpparser.data.model;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "Representation")
public class SimpleRepresentation implements Representation {

    @Attribute()
    private final long bandwidth;

    @Attribute()
    private final String codecs;

    @Attribute()
    private final int frameRate;

    @Attribute()
    private final int height;

    @Attribute()
    private final String id;

    @Attribute()
    private final String mimeType;

    @Attribute()
    private final int startWithSAP;

    @Attribute()
    private final int width;

    @Attribute()
    private final Format format;

    @Element(name = "BaseURL")
    private final String baseURL;

    @Element(name = "SegmentBase")
    private final SegmentBase segmentBase;

    @Element(name = "SegmentTemplate")
    private final SegmentTemplate segmentTemplate;

    public SimpleRepresentation(long bandwidth,
                                String codecs,
                                int frameRate,
                                int height,
                                String id,
                                String mimeType,
                                int startWithSAP,
                                int width,
                                Format format,
                                String baseURL,
                                SegmentBase segmentBase,
                                SegmentTemplate segmentTemplate) {
        this.bandwidth = bandwidth;
        this.codecs = codecs;
        this.frameRate = frameRate;
        this.height = height;
        this.id = id;
        this.mimeType = mimeType;
        this.startWithSAP = startWithSAP;
        this.width = width;
        this.format = format;
        this.baseURL = baseURL;
        this.segmentBase = segmentBase;
        this.segmentTemplate = segmentTemplate;
    }

    public SimpleRepresentation() {
        this.bandwidth = -1;
        this.codecs = null;
        this.frameRate = -1;
        this.height = -1;
        this.id = null;
        this.mimeType = null;
        this.startWithSAP = -1;
        this.width = -1;
        this.format = null;
        this.baseURL = null;
        this.segmentBase = null;
        this.segmentTemplate = null;
    }

    @NotNull
    @Override
    public Format getFormat() {
        return format;
    }

    @NotNull
    @Override
    public String getBaseUrl() {
        return baseURL;
    }

    @NotNull
    @Override
    public String getId() {
        return id;
    }

    @Override
    public long getBandwidth() {
        return bandwidth;
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    public String getCodecs() {
        return codecs;
    }

    public int getFrameRate() {
        return frameRate;
    }

    public String getMimeType() {
        return mimeType;
    }

    public int getStartWithSAP() {
        return startWithSAP;
    }

    public String getBaseURL() {
        return baseURL;
    }

    public SegmentBase getSegmentBase() {
        return segmentBase;
    }

    @Nullable
    @Override
    public SegmentTemplate getSegmentTemplate() {
        return segmentTemplate;
    }
}
