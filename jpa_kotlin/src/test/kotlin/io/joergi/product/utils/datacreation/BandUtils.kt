package io.joergi.product.utils.datacreation

import io.joergi.product.models.Band

object BandUtils {

    const val BAND_NAME_WITHOUT_LINK: String = "MEA without link"

    fun createBandWithoutLinks(name: String = BAND_NAME_WITHOUT_LINK): Band {
        val band = Band()
        band.name = name
        band.description = "merch em all"
        return band
    }

    fun createBandWithLinks(): Band {
         return Band(
            name = "MEA with links",
            description = "merch em all",
            links = LinkUtils.createListOfLinks()
            )
    }



}
