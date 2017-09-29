package reddit.com.mdpparser.data.model;

import android.support.annotation.NonNull;

import org.jetbrains.annotations.NotNull;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

/**
 * Collection of classes that represent elements of Media Presentation Descriptor XML elements
 */
@Root(name = "MPD")
public class SimpleManifest implements DashManifest {

    @Attribute(required = false)
    private final String mediaPresentationDuration;

    @Attribute(required = false)
    private final String minBufferTime;

    @Attribute(required = false)
    private final String profiles;

    @Attribute(required = false)
    private final String type;

    @Attribute(required = false)
    private final String xmlns;

    @ElementList(name = "Period", inline = true, required = false)
    private final List<Period> periods;

    public SimpleManifest(String mediaPresentationDuration,
                          String minBufferTime,
                          String profiles,
                          String type,
                          String xmlns,
                          List<Period> periods) {
        this.mediaPresentationDuration = mediaPresentationDuration;
        this.minBufferTime = minBufferTime;
        this.profiles = profiles;
        this.type = type;
        this.xmlns = xmlns;
        this.periods = periods;
    }

    public SimpleManifest() {
        this.mediaPresentationDuration = null;
        this.minBufferTime = null;
        this.profiles = null;
        this.type = null;
        this.xmlns = null;
        this.periods = null;
    }

    @Override
    public  int getPeriodCount() {
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
