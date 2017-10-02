package reddit.com.mdpparser.data.model;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

@Root(name = "Period")
public class SimplePeriod implements Period {

    @Attribute()
    private final String duration;

    @ElementList(name = "AdaptationSet", inline = true, required = false)
    private List<AdaptationSet> adaptationSet;

    public SimplePeriod(String duration, List<AdaptationSet> adaptationSet) {
        this.duration = duration;
        this.adaptationSet = adaptationSet;
    }

    public SimplePeriod() {
        this.duration = null;
        this.adaptationSet = null;
    }

    @Nullable
    @Override
    public List<AdaptationSet> getAdaptationSets() {
        return adaptationSet;
    }

    @Override
    public void setAdaptationSets(List<? extends AdaptationSet> list) {
        this.adaptationSet = (List<AdaptationSet>) list;
    }

    @NotNull
    @Override
    public String getDuration() {
        return duration;
    }
}
