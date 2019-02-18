package com.example.demo;

import com.example.demo.foo.ImmutableDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LombokJacksonTest {
	
	@Autowired
	ObjectMapper objectMapper;

	String FULL = "{\n" +
			"    \"bar\": \"foo\",\n" +
			"    \"fizz\" : \"buzz\"\n" +
			"}";

	String FIZZ_NULL = "{\n" +
			"    \"bar\": \"foo\",\n" +
			"    \"fizz\" : null\n" +
			"}";

	String MISSING_FIZZ = "{\n" +
			"    \"bar\": \"foo\"\n" +
			"}";

	@Test
	public void testFullObject() throws IOException {
		ImmutableDto immutableDtoObject1 = objectMapper.readValue(FULL, ImmutableDto.class);
	}

	@Test
	public void testNullProperty() throws IOException {
		ImmutableDto immutableDtoObject2 = objectMapper.readValue(FIZZ_NULL, ImmutableDto.class);
	}

	@Test(expected = MismatchedInputException.class)
	public void testMissingProperty() throws IOException {
		ImmutableDto immutableDtoObject3 = objectMapper.readValue(MISSING_FIZZ, ImmutableDto.class);
	}
}
