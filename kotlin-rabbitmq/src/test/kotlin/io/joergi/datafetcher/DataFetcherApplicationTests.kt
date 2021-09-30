package io.joergi.datafetcher

import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.context.properties.EnableConfigurationProperties
import io.joergi.datafetcher.config.RabbitMqConfigProperties

@EnableConfigurationProperties(RabbitMqConfigProperties::class)
@SpringBootTest
class DataFetcherApplicationTests {

	@Test
	fun contextLoads() {
	}

}
