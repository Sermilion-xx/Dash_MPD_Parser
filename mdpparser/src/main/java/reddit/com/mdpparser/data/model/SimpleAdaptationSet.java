package reddit.com.mdpparser.data.model;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

@Root(name = "AdaptationSet")
public class SimpleAdaptationSet implements AdaptationSet {

    @Attribute(required = false)
    private final String mimeType;

    @Attribute(required = false)
    private final boolean segmentAlignment;

    @Attribute()
    private final boolean subsegmentAlignment;

    @Attribute()
    private final int subsegmentStartsWithSAP;

    @ElementList(name = "Representation", inline = true, required = false)
    private final List<Representation> representation;

    public SimpleAdaptationSet(String mimeType,
                               boolean segmentAlignment,
                               boolean subsegmentAlignment,
                               int subsegmentStartsWithSAP,
                               List<Representation> representation) {
        this.mimeType = mimeType;
        this.segmentAlignment = segmentAlignment;
        this.subsegmentAlignment = subsegmentAlignment;
        this.subsegmentStartsWithSAP = subsegmentStartsWithSAP;
        this.representation = representation;
    }

    public SimpleAdaptationSet() {
        this.mimeType = null;
        this.segmentAlignment = false;
        this.subsegmentAlignment = false;
        this.subsegmentStartsWithSAP = -1;
        this.representation = null;
    }

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
