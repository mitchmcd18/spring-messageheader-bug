package com.example.demo;

import java.util.Map;
import org.springframework.core.serializer.support.DeserializingConverter;
import org.springframework.core.serializer.support.SerializingConverter;
import org.springframework.integration.support.MutableMessageHeaders;

public class DemoApplication {

	public static void main(String[] args) {
		MutableMessageHeaders headers =
				new MutableMessageHeaders(Map.of("myHeader", "myValue", "header2", new DemoApplication()));

		headers.put("newHeader", "thisworks");

		SerializingConverter serializingConverter = new SerializingConverter();
		byte[] serialized = serializingConverter.convert(headers);

		DeserializingConverter deserializingConverter = new DeserializingConverter();
		MutableMessageHeaders deserializedHeaders =
				(MutableMessageHeaders) deserializingConverter.convert(serialized);

		deserializedHeaders.put("newHeader", "thisDoesNotWork");
	}

}
