package reddit.com.mdpparser.data.model

import com.google.android.exoplayer2.source.dash.manifest.DashManifest as ExoManifest1
import com.google.android.exoplayer2.source.dash.manifest.Period as ExoPeriod1
import com.google.android.exoplayer2.source.dash.manifest.AdaptationSet as ExoAdaptationSet1
import com.google.android.exoplayer2.source.dash.manifest.Representation as ExoRepresentation1
import com.google.android.exoplayer2.Format as ExoFormat1

class ExoDashManifest(private val exoDashManifest: ExoManifest1) : DashManifest {

    override var periodCount: Int = 0
        get() = exoDashManifest.periodCount
        set(value) {
            field = value
        }

    override fun getPeriod(index: Int): Period =
            ExoPeriod(exoDashManifest.getPeriod(index))

}

class ExoPeriod(private val period: ExoPeriod1): Period {

    override var adaptationSets: List<AdaptationSet>? = null
        get() = period.adaptationSets.map { ExoAdaptationSet(it) }
        set(value) {
            field = value
        }

}

class ExoAdaptationSet(private val adaptationSet: ExoAdaptationSet1): AdaptationSet {

    override var representations: List<Representation>? = null
        get() = adaptationSet.representations.map { ExoRepresentation(it)}
        set(value) {
            field = value
        }
}

class ExoRepresentation(private val representation: ExoRepresentation1): Representation {
    override var format: Format
        get() = ExoFormat(representation.format)
        set(value) {}
    override var baseUrl: String = ""
        get() = representation.baseUrl
        set(value) {
            field = value
        }
}

class ExoFormat(private val format: ExoFormat1): Format {
    override var containerMimeType: String = ""
        get() = format.containerMimeType
        set(value) {
            field = value
        }
}