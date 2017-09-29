package reddit.com.mdpparser.data.model;

import org.jetbrains.annotations.NotNull;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "SegmentBase")
public class SimpleSegmentBase implements SegmentBase {

    @Attribute()
    private final String indexRange;

    @Attribute()
    private final boolean indexRangeExact;

    @Element(name = "Initialization")
    private final Initialization initialization;

    @Element(name = "RepresentationIndex")
    private final RepresentationIndex representationIndex;

    public SimpleSegmentBase(String indexRange,
                             boolean indexRangeExact,
                             Initialization initialization,
                             RepresentationIndex representationIndex) {
        this.indexRange = indexRange;
        this.indexRangeExact = indexRangeExact;
        this.initialization = initialization;
        this.representationIndex = representationIndex;
    }

    public SimpleSegmentBase() {
        this.indexRange = null;
        this.indexRangeExact = false;
        this.initialization = null;
        this.representationIndex = null;
    }

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
