package io.joergi.product.repositories

import io.joergi.product.models.Band
import io.joergi.product.models.Link
import io.joergi.product.utils.datacreation.BandUtils
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ActiveProfiles("test")
class LinkRepositoryTest {
    @Autowired
    private val bandRepository: BandRepository? = null

    @Autowired
    private val linkRepository: LinkRepository? = null

    @Test
    fun `creating band with link should have cross reference`() {
        bandRepository!!.save(BandUtils.createBandWithLinks())
        val linksFromDb: List<Link> = (linkRepository!!.findAll() as List<Link>)
        linksFromDb.size shouldBe 2
        val bandsFromDB = bandRepository!!.findAll() as List<Band>
        bandsFromDB.first().links.size shouldBe 2

    }

    @BeforeEach
    fun start() {
        cleanUp()
    }

    @AfterEach
    fun end() {
        cleanUp()
    }

    private fun cleanUp() {
        bandRepository!!.deleteAll()
        linkRepository!!.deleteAll()
        Assertions.assertEquals(emptyList<Any>(), bandRepository.findAll())
        Assertions.assertEquals(emptyList<Any>(), linkRepository.findAll())
    }
}
