package com.example.demo;

import java.util.Map;
import org.springframework.core.serializer.support.DeserializingConverter;
import org.springframework.core.serializer.support.SerializingConverter;
import org.springframework.integration.support.MutableMessageHeaders;

public class DemoApplication {

	public static void main(String[] args) {
		// If you remove the second header value, this code will work as expected
		MutableMessageHeaders headers =
				new MutableMessageHeaders(Map.of("header1", "value1", "header2", new DemoApplication()));

		headers.put("header3", "value3"); // This Works

		SerializingConverter serializingConverter = new SerializingConverter();
		byte[] serialized = serializingConverter.convert(headers);

		DeserializingConverter deserializingConverter = new DeserializingConverter();
		MutableMessageHeaders deserializedHeaders =
				(MutableMessageHeaders) deserializingConverter.convert(serialized);

		deserializedHeaders.put("header4", "value4"); // This does not work (but should)
	}

}
