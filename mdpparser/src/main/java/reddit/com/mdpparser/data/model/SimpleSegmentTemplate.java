package reddit.com.mdpparser.data.model;

import org.jetbrains.annotations.NotNull;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;

public class SimpleSegmentTemplate implements SegmentTemplate {

    @Attribute()
    private final String media;

    @Attribute()
    private final long timescale;

    @Element(name = "SegmentTimeline", required = false)
    private final SegmentTimeline segmentTimeline;

    @Element(name = "RepresentationIndex")
    private final RepresentationIndex representationIndex;

    public SimpleSegmentTemplate(String media,
                                 long timescale,
                                 SegmentTimeline segmentTimeline,
                                 RepresentationIndex representationIndex) {
        this.media = media;
        this.timescale = timescale;
        this.segmentTimeline = segmentTimeline;
        this.representationIndex = representationIndex;
    }

    public SimpleSegmentTemplate() {
        this.media = "";
        this.timescale = -1;
        this.segmentTimeline = null;
        this.representationIndex = null;
    }

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
