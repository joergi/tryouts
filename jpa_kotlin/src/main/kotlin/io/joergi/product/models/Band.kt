package io.joergi.product.models

import com.fasterxml.jackson.annotation.JsonBackReference
import io.swagger.v3.oas.annotations.media.Schema
import lombok.AccessLevel
import lombok.Setter
import javax.persistence.*
import javax.validation.constraints.NotEmpty

@Entity
data class Band(

    @Id
    @Setter(AccessLevel.NONE)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(hidden = true)
    val id: Int? = null,

    var name: @NotEmpty(message = "name must not be empty") String? = null,

    var description: String? = null,
){


    @JsonBackReference(value = "links")
    @OneToMany(
        fetch = FetchType.EAGER,
        mappedBy = "band",
        cascade = [CascadeType.ALL]
    )
    var links: MutableSet<Link> = mutableSetOf()
}
