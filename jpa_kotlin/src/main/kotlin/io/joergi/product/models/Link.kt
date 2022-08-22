package io.joergi.product.models

import io.joergi.product.models.enums.LinkType
import io.swagger.v3.oas.annotations.media.Schema
import lombok.AccessLevel
import lombok.Setter
import javax.persistence.*

@Entity
data class Link(

    @Id
    @Setter(AccessLevel.NONE)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(hidden = true)
    val id: Int? = null,


    var url: String? = null,

    @ManyToOne(fetch = FetchType.EAGER, cascade = [CascadeType.ALL])
    @JoinColumn(name = "band_id", nullable = true)
    var band: Band? = null



)
