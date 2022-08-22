package io.joergi.product.repositories

import io.joergi.product.models.Link
import org.springframework.data.repository.CrudRepository

interface LinkRepository : CrudRepository<Link?, Int?>
