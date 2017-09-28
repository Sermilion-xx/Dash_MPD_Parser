package reddit.com.mdpparser.data.model;

import android.support.annotation.NonNull;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

/**
 * Collection of classes that represent elements of Media Presentation Descriptor XML elements
 */
@Root(name = "MPD")
class SimpleManifest implements DashManifest {

    @Attribute(required = false)
    private String mediaPresentationDuration;

    @Attribute(required = false)
    private String minBufferTime;

    @Attribute(required = false)
    private String profiles;

    @Attribute(required = false)
    private String type;

    @Attribute(required = false)
    private String xmlns;

    @ElementList(name = "Period", inline = true, required = false)
    private List<Period> periods;

    @Override
    public int getPeriodCount() {
        return periods.size();
    }

    @NotNull
    @Override
    public Period getPeriod(int index) {
        return periods.get(index);
    }

    @NonNull
    @Override
    public String getMinBufferTime() {
        return minBufferTime;
    }

    @NotNull
    @Override
    public String getProfiles() {
        return profiles;
    }

    @NotNull
    @Override
    public String getXmlns() {
        return xmlns;
    }
}

@Root(name = "Period")
class SimplePeriod implements Period {

    @Attribute()
    private String duration;

    @ElementList(name = "AdaptationSet", inline = true, required = false)
    private List<AdaptationSet> adaptationSet;

    @Nullable
    @Override
    public List<AdaptationSet> getAdaptationSets() {
        return adaptationSet;
    }

    @NotNull
    @Override
    public String getDuration() {
        return duration;
    }
}

@Root(name = "AdaptationSet")
class SimpleAdaptationSet implements AdaptationSet {

    @Attribute(required = false)
    private String mimeType;

    @Attribute(required = false)
    private boolean segmentAlignment;

    @Attribute()
    private boolean subsegmentAlignment;

    @Attribute()
    private int subsegmentStartsWithSAP;

    @ElementList(name = "Representation", inline = true, required = false)
    private List<Representation> representation;

    @Nullable
    @Override
    public List<Representation> getRepresentations() {
        return representation;
    }

    @NotNull
    @Override
    public String getMimeType() {
        return mimeType;
    }

    @Override
    public boolean getSegmentAlignment() {
        return segmentAlignment;
    }

    @Override
    public boolean getSubsegmentAlignment() {
        return subsegmentAlignment;
    }

    @Override
    public int getSubsegmentStartsWithSAP() {
        return subsegmentStartsWithSAP;
    }
}

@Root(name = "Representation")
class SimpleRepresentation implements Representation {

    @Attribute()
    private long bandwidth;

    @Attribute()
    private String codecs;

    @Attribute()
    private int frameRate;

    @Attribute()
    private int height;

    @Attribute()
    private String id;

    @Attribute()
    private String mimeType;

    @Attribute()
    private int startWithSAP;

    @Attribute()
    private int width;

    @Attribute()
    private Format format;

    @Element(name = "BaseURL")
    private String baseURL;

    @Element(name = "SegmentBase")
    private SegmentBase segmentBase;

    @Element(name = "SegmentTemplate")
    private SegmentTemplate segmentTemplate;

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

class SimpleSegmentList implements SegmentList {

    @Attribute()
    private long timescale;
    @Attribute()
    private long duration;

    @Element(name = "RepresentationIndex")
    private RepresentationIndex representationIndex;

    @ElementList(name = "SegmentURL", inline = true, required = false)
    private List<SegmentURL> segmentURLs;

    @Override
    public long getTimescale() {
        return timescale;
    }

    @Override
    public long getDuration() {
        return duration;
    }


    @NotNull
    @Override
    public RepresentationIndex getRepresentationIndex() {
        return representationIndex;
    }


    @NotNull
    public List<SegmentURL> getSegmentURLs() {
        return segmentURLs;
    }
}

class SimpleSegmentURL implements SegmentURL {

    @Attribute()
    private String media;


    @NotNull
    @Override
    public String getMedia() {
        return media;
    }
}

class SimpleSegmentTemplate implements SegmentTemplate {

    @Attribute()
    private String media;

    @Attribute()
    private long timescale;

    @Element(name = "SegmentTimeline")
    private SegmentTimeline segmentTimeline;

    @Element(name = "RepresentationIndex")
    private RepresentationIndex representationIndex;

    @NotNull
    @Override
    public String getMedia() {
        return media;
    }

    @Override
    public long getTimescale() {
        return timescale;
    }

    @NotNull
    @Override
    public SegmentTimeline getSegmentTimeline() {
        return segmentTimeline;
    }

    @NotNull
    @Override
    public RepresentationIndex getRepresentationIndex() {
        return representationIndex;
    }
}

@Root(name = "SegmentBase")
class SimpleSegmentBase implements SegmentBase {

    @Attribute()
    private String indexRange;

    @Attribute()
    private boolean indexRangeExact;

    @Element(name = "Initialization")
    private Initialization initialization;

    @Element(name = "RepresentationIndex")
    private RepresentationIndex representationIndex;

    @NotNull
    @Override
    public String getIndexRange() {
        return indexRange;
    }

    @Override
    public boolean getIndexRangeExact() {
        return indexRangeExact;
    }

    @NotNull
    @Override
    public Initialization getInitialization() {
        return initialization;
    }

    @Override
    public RepresentationIndex getRepresentationIndex() {
        return representationIndex;
    }
}

class SimpleSegmentTimeline implements SegmentTimeline {

    @ElementList(name = "S", inline = true, required = false)
    private List<S> s;

    @NotNull
    @Override
    public List<S> getS() {
        return s;
    }
}

class SimpleRepresentationIndex implements RepresentationIndex {

    @Attribute()
    private String sourceURL;


    @NotNull
    @Override
    public String getSourceURL() {
        return sourceURL;
    }
}

@Root(name = "Initialization")
class SimpleInitialization implements Initialization {

    @Attribute()
    private String range;

}
