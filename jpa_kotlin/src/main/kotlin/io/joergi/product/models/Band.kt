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

    @JsonBackReference(value = "links")
    @OneToMany(
        fetch = FetchType.EAGER,
        mappedBy = "band",
        cascade = [CascadeType.ALL]
    )
    var links: MutableSet<Link> = mutableSetOf()


//
//    @JsonBackReference(value = "bands")
//    @ManyToMany(cascade = [CascadeType.ALL])
//    @JoinTable(
//        name = "band_has_product",
//        joinColumns = [JoinColumn(name = "band_id", nullable = true, updatable = true)],
//        inverseJoinColumns = [JoinColumn(name = "product_id", nullable = true, updatable = true)]
//    )
//    private val products: List<Product>? = null



) {

}
//{
//    override fun equals(other: Any?): Boolean {
//        if (this === other) return true
//        if (javaClass != other?.javaClass) return false
//
//        other as Band
//
//        if (id != other.id) return false
//        if (name != other.name) return false
//        if (description != other.description) return false
//        if (links != other.links) return false
//
//        return true
//    }
//
//    override fun hashCode(): Int {
//        var result = id ?: 0
//        result = 31 * result + (name?.hashCode() ?: 0)
//        result = 31 * result + (description?.hashCode() ?: 0)
//        result = 31 * result + (links?.hashCode() ?: 0)
//        return result
//    }
//
//    override fun toString(): String {
//        return "Band(id=$id, name=$name, description=$description, links=$links)"
//    }


//}

