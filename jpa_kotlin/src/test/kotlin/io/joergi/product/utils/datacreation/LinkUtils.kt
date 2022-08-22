package io.joergi.product.utils.datacreation

import io.joergi.product.models.Band
import io.joergi.product.models.Link
import io.joergi.product.models.enums.LinkType

object LinkUtils {

    fun createListOfLinks(): MutableSet<Link> {
        val link1 = Link()
        link1.url = "https://fb.com/joergi"

        val link2 = Link()
        link2.url = "https://twitter.com/joergi"

        var linkSets = mutableSetOf<Link>()
        linkSets.add(link1)
        linkSets.add(link2)
        return linkSets
    }


}
