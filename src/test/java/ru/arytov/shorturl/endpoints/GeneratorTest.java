package ru.arytov.shorturl.endpoints;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import ru.arytov.shorturl.endpoings.Generator;

class GeneratorTest {

	@Test
	void testGenerate() {
		System.out.println(new Generator().generate("http://yandex.ru/testUrl"));
	}

}
