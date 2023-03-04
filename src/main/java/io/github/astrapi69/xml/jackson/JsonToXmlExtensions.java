/**
 * The MIT License
 *
 * Copyright (C) 2022 Asterios Raptis
 *
 * Permission is hereby granted, free of charge, to any person obtaining
 * a copy of this software and associated documentation files (the
 * "Software"), to deal in the Software without restriction, including
 * without limitation the rights to use, copy, modify, merge, publish,
 * distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject to
 * the following conditions:
 *
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 * LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
 * OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
 * WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package io.github.astrapi69.xml.jackson;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;
import io.github.astrapi69.xml.jackson.factory.ObjectMapperFactory;
import io.github.astrapi69.xml.jackson.factory.XmlMapperFactory;

import java.io.IOException;
import java.io.StringWriter;

/**
 * The class {@link JsonToXmlExtensions} helps to transform a given json string to an xml string.
 */
public class JsonToXmlExtensions
{
	private JsonToXmlExtensions()
	{
	}

	/**
	 * Transform the given json as {@link String} object to a xml as {@link String} object
	 *
	 * @param jsonString
	 *            the json as {@link String} object
	 * @return the transformed xml as {@link String} object
	 * @throws IOException
	 *             Signals that an I/O exception has occurred
	 */
	public static String toXml(final String jsonString) throws IOException
	{
		return toXml(jsonString, null);
	}

	/**
	 * Transform the given json as {@link String} object to a xml as {@link String} object
	 *
	 * @param jsonString
	 *            the json as {@link String} object
	 * @param rootName
	 *            The root name to use
	 * @return the transformed xml as {@link String} object
	 * @throws IOException
	 *             Signals that an I/O exception has occurred
	 */
	public static String toXml(final String jsonString, String rootName) throws IOException
	{
		ObjectMapper jsonMapper = ObjectMapperFactory.newObjectMapper();
		XmlMapper xmlMapper = XmlMapperFactory.newXmlMapper();
		JsonNode node = jsonMapper.readValue(jsonString, JsonNode.class);
		xmlMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
		xmlMapper.configure(ToXmlGenerator.Feature.WRITE_XML_DECLARATION, true);
		xmlMapper.configure(ToXmlGenerator.Feature.WRITE_XML_1_1, true);
		ObjectWriter objectWriter;
		if (rootName != null)
		{
			objectWriter = xmlMapper.writer().withRootName(rootName);
		}
		else
		{
			objectWriter = xmlMapper.writer();
		}
		StringWriter stringWriter = new StringWriter();
		objectWriter.writeValue(stringWriter, node);
		return stringWriter.toString();
	}
}
