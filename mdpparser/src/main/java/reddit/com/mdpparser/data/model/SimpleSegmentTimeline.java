package reddit.com.mdpparser.data.model;

import org.jetbrains.annotations.NotNull;
import org.simpleframework.xml.ElementList;

import java.util.List;

public class SimpleSegmentTimeline implements SegmentTimeline {

    @ElementList(name = "S", inline = true, required = false)
    private final List<S> s;

    public SimpleSegmentTimeline(List<S> s) {
        this.s = s;
    }

    public SimpleSegmentTimeline() {
        this.s = null;
    }

    @NotNull
    @Override
    public List<S> getS() {
        return s;
    }
}
