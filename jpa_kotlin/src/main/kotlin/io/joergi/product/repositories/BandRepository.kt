package io.joergi.product.repositories

import io.joergi.product.models.Band
import org.springframework.data.repository.CrudRepository
import java.util.*

interface BandRepository : CrudRepository<Band?, Int?> {
    // TODO needs to be a list of Bands
    fun findBandsByName(name: String): List<Band>?
}
