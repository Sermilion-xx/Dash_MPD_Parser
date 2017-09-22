package reddit.com.mdpparser.core.mapper

import com.google.android.exoplayer2.source.dash.manifest.DashManifest


interface Mapper {
    fun map(dashManifest: DashManifest): MutableMap<String, String>
}