package io.joergi.kotlinmockrestserver.controller

import io.kotest.matchers.shouldBe
import model.Profile
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.assertThrows
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.core.ParameterizedTypeReference
import org.springframework.http.HttpMethod
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.web.client.MockRestServiceServer
import org.springframework.test.web.client.match.MockRestRequestMatchers
import org.springframework.test.web.client.response.MockRestResponseCreators
import org.springframework.web.client.RestClientException
import org.springframework.web.client.RestTemplate
import java.net.URI


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class FunctionalControllerTest {

    @Autowired
    lateinit var testRestTemplate: TestRestTemplate

    @Autowired
    lateinit var restTemplate: RestTemplate

    var mockServer: MockRestServiceServer? = null

    @BeforeEach
    fun init() {
        mockServer = MockRestServiceServer.createServer(restTemplate)
    }


    @Test
    fun `when calling service, and client returns Accepted, status should be OK`() {

        val responseType: ParameterizedTypeReference<List<Profile>> =
            object : ParameterizedTypeReference<List<Profile>>() {}

        mockServer?.expect(MockRestRequestMatchers.requestTo(URI("http://localhost:8082/profiles/simple-get")))
            ?.andExpect(MockRestRequestMatchers.method(HttpMethod.GET))
            ?.andRespond(
                MockRestResponseCreators.withStatus(HttpStatus.ACCEPTED)
                    .contentType(MediaType.APPLICATION_JSON))

        val response = testRestTemplate.exchange(
            "/profiles/simple-get",
            HttpMethod.GET,
            null,
            responseType
        )
        response.statusCode shouldBe HttpStatus.OK
        response.body?.size shouldBe 2
    }

    // NOT WORKING -> problems with parsing
    @Test
    fun `when calling service, and client timeout, it should return 500 - not working, problems with parsing`() {

        val responseType: ParameterizedTypeReference<List<Profile>> =
            object : ParameterizedTypeReference<List<Profile>>() {}

        mockServer?.expect(MockRestRequestMatchers.requestTo(URI("http://localhost:8082/profiles/simple-get")))
            ?.andExpect(MockRestRequestMatchers.method(HttpMethod.GET))
            ?.andRespond(
                MockRestResponseCreators.withStatus(HttpStatus.REQUEST_TIMEOUT)
                    .contentType(MediaType.APPLICATION_JSON))

        val response = testRestTemplate.exchange(
            "/profiles/simple-get",
            HttpMethod.GET,
            null,
            responseType
        )

        response.statusCode shouldBe HttpStatus.OK

    }

    // this is working - but it's not returning my custom exception, it's a RestClientException
    @Test
    fun `when calling service, and client timeout, it should return 500 working `() {

        val responseType: ParameterizedTypeReference<List<Profile>> =
            object : ParameterizedTypeReference<List<Profile>>() {}

        mockServer?.expect(MockRestRequestMatchers.requestTo(URI("http://localhost:8082/profiles/simple-get")))
            ?.andExpect(MockRestRequestMatchers.method(HttpMethod.GET))
            ?.andRespond(
                MockRestResponseCreators.withStatus(HttpStatus.REQUEST_TIMEOUT)
                    .contentType(MediaType.APPLICATION_JSON))


        assertThrows<RestClientException> {
            testRestTemplate.exchange(
                "/profiles/simple-get",
                HttpMethod.GET,
                null,
                responseType
            )
        }

    }

}
