package reddit.com.mdpparser.data.model


interface DashManifest {

    var periodCount: Int

    fun getPeriod(index: Int): Period
}

interface Period {
    var adaptationSets: List<AdaptationSet>?
}

interface AdaptationSet {
    var representations: List<Representation>?
}

interface Representation {
    var format: Format
    var baseUrl: String
}

interface Format {
    var containerMimeType: String
}