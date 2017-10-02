package reddit.com.mdpparser.data.model;

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
    private final long minBufferTime;

    @Attribute(required = false)
    private final String profiles;

    @Attribute(required = false)
    private final String type;

    @Attribute(required = false)
    private final String xmlns;

    @ElementList(name = "Period", inline = true, required = false)
    private final List<Period> periods;

    public SimpleManifest(String mediaPresentationDuration,
                          long minBufferTime,
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
        this.minBufferTime = 0L;
        this.profiles = null;
        this.type = null;
        this.xmlns = null;
        this.periods = null;
    }

    @Override
    public  int getPeriodCount() {
        return periods == null ? 0 : periods.size();
    }

    @Override
    public Period getPeriod(int index) {
        if (periods != null) {
            return periods.get(index);
        } else {
            return null;
        }
    }

    @Override
    public long getMinBufferTime() {
        return minBufferTime;
    }


    @Override
    public String getProfiles() {
        return profiles;
    }

    @Override
    public String getXmlns() {
        return xmlns;
    }
}
