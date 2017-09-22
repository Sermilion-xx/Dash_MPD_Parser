package reddit.com.mdpparser.data.model;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

/**
 * Collection of classes that represent elements of Media Presentation Descriptor XML elements
 */
@Root(name = "MPD")
public class MPD {

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
    private List<Period> period;

}

@Root(name = "Period")
class Period {

    @Attribute()
    private String duration;

    @ElementList(name = "AdaptationSet", inline = true, required = false)
    private List<AdaptationSet> adaptationSet;

}

@Root(name = "AdaptationSet")
class AdaptationSet {

    @Attribute(required = false)
    private boolean segmentAlignment;

    @Attribute()
    private boolean subsegmentAlignment;

    @Attribute()
    private int subsegmentStartsWithSAP;

    @ElementList(name = "Representation", inline = true, required = false)
    private List<Representation> representation;

}

@Root(name = "Representation")
class Representation {

    @Attribute()
    private int bandwidth;

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

    @Element(name = "BaseURL")
    private String BaseURL;

    @Element(name = "SegmentBase")
    private SegmentBase segmentBase;

}

@Root(name = "SegmentBase")
class SegmentBase {

    @Attribute()
    private String indexRange;

    @Attribute()
    private boolean indexRangeExact;

    @Element(name = "Initialization")
    private Initialization initialization;

}

@Root(name = "Initialization")
class Initialization {

    @Attribute()
    private String range;

}


