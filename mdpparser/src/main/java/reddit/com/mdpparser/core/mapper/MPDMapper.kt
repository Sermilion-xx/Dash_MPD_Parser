package reddit.com.mdpparser.core.mapper

import reddit.com.mdpparser.data.model.DashManifest


interface MPDMapper {
    fun map(dashManifest: DashManifest): MutableMap<String, String>
}