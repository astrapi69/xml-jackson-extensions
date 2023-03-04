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

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The unit test class for the class {@link JsonToXmlExtensions}
 */
class JsonToXmlExtensionsTest
{

	/**
	 * Test method for {@link JsonToXmlExtensions#toXml(String, String)}
	 *
	 * @throws IOException
	 *             Signals that an I/O exception has occurred
	 */
	@Test
	void toXml() throws IOException
	{
		String expected;
		String actual;
		String jsonString;

		jsonString = "{\"person\":{\"name\":\"Anna\",\"nickname\":\"beast\",\"gender\":\"FEMALE\",\"about\":\"Ha ha ha...\",\"married\":true},\"id\":\"23\"}";
		actual = JsonToXmlExtensions.toXml(jsonString, null);
		expected = // language=xml
			"<?xml version='1.1' encoding='UTF-8'?>\n" + "<ObjectNode>\n" + "  <person>\n"
				+ "    <name>Anna</name>\n" + "    <nickname>beast</nickname>\n"
				+ "    <gender>FEMALE</gender>\n" + "    <about>Ha ha ha...</about>\n"
				+ "    <married>true</married>\n" + "  </person>\n" + "  <id>23</id>\n"
				+ "</ObjectNode>\n";
		assertEquals(actual, expected);

		jsonString = "{\"person\":{\"name\":\"Anna\",\"nickname\":\"beast\",\"gender\":\"FEMALE\",\"about\":\"Ha ha ha...\",\"married\":true},\"id\":\"23\"}";
		actual = JsonToXmlExtensions.toXml(jsonString);
		expected = // language=xml
			"<?xml version='1.1' encoding='UTF-8'?>\n" + "<ObjectNode>\n" + "  <person>\n"
				+ "    <name>Anna</name>\n" + "    <nickname>beast</nickname>\n"
				+ "    <gender>FEMALE</gender>\n" + "    <about>Ha ha ha...</about>\n"
				+ "    <married>true</married>\n" + "  </person>\n" + "  <id>23</id>\n"
				+ "</ObjectNode>\n";
		assertEquals(actual, expected);

		actual = JsonToXmlExtensions.toXml(jsonString, "root");
		expected = // language=xml
			"<?xml version='1.1' encoding='UTF-8'?>\n" + "<root>\n" + "  <person>\n"
				+ "    <name>Anna</name>\n" + "    <nickname>beast</nickname>\n"
				+ "    <gender>FEMALE</gender>\n" + "    <about>Ha ha ha...</about>\n"
				+ "    <married>true</married>\n" + "  </person>\n" + "  <id>23</id>\n"
				+ "</root>\n";
		assertEquals(actual, expected);
	}
}