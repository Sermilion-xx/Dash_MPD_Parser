package reddit.com.mdpparser.data.model;

import org.jetbrains.annotations.NotNull;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;

import java.util.List;

public class SimpleSegmentList implements SegmentList {

    @Attribute()
    private final long timescale;
    @Attribute()
    private final long duration;

    @Element(name = "RepresentationIndex")
    private final RepresentationIndex representationIndex;

    @ElementList(name = "SegmentURL", inline = true, required = false)
    private final List<SegmentURL> segmentURLs;

    public SimpleSegmentList(long timescale,
                             long duration,
                             RepresentationIndex representationIndex,
                             List<SegmentURL> segmentURLs) {
        this.timescale = timescale;
        this.duration = duration;
        this.representationIndex = representationIndex;
        this.segmentURLs = segmentURLs;
    }

    public SimpleSegmentList() {
        this.timescale = -1;
        this.duration = -1;
        this.representationIndex = null;
        this.segmentURLs = null;
    }

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
