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

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.io.IOException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.meanbean.test.BeanTester;

import io.github.astrapi69.file.read.ReadFileExtensions;
import io.github.astrapi69.file.search.PathFinder;
import io.github.astrapi69.test.object.Employee;
import io.github.astrapi69.test.object.Person;

/**
 * The unit test class for the class {@link XmlToJsonExtensions}
 */
public class XmlToJsonExtensionsTest
{

	File xmlDir;
	File xmlFile;

	@BeforeEach
	protected void setUp()
	{
		xmlFile = new File(PathFinder.getSrcTestResourcesDir(), "new-employee.xml");
	}

	/**
	 * Test method for {@link XmlToJsonExtensions}
	 */
	@Test
	public void testWithBeanTester()
	{
		final BeanTester beanTester = new BeanTester();
		beanTester.testBean(XmlToJsonExtensions.class);
	}

	/**
	 * Test method for {@link XmlToJsonExtensions#toJson(String, Class)}
	 *
	 * @throws IOException
	 *             Signals that an I/O exception has occurred
	 */
	@Test
	public void testToJson() throws IOException
	{
		String expected;
		String actual;
		String xmlString;

		xmlString = ReadFileExtensions.fromFile(xmlFile);

		actual = XmlToJsonExtensions.toJson(xmlString, Employee.class);
		expected = // language=json
			"{\"id\":\"23\",\"person\":{\"about\":\"\",\"gender\":\"FEMALE\",\"married\":null,\"name\":\"Anna\",\"nickname\":\"\"},\"subOrdinates\":[]}";
		assertEquals(expected, actual);

		xmlString = "<person><gender>FEMALE</gender><name>Anna</name><nickname>beast</nickname><about>Ha ha ha...</about><married>true</married></person><id>23</id>";

		actual = XmlToJsonExtensions.toJson(xmlString, Person.class);
		expected = // language=json
			"{\"about\":\"Ha ha ha...\",\"gender\":\"FEMALE\",\"married\":true,\"name\":\"Anna\",\"nickname\":\"beast\"}";
		assertEquals(expected, actual);

		actual = JsonToXmlExtensions.toXml(actual);
		expected = "<?xml version='1.1' encoding='UTF-8'?>\n" + "<ObjectNode>\n"
			+ "  <about>Ha ha ha...</about>\n" + "  <gender>FEMALE</gender>\n"
			+ "  <married>true</married>\n" + "  <name>Anna</name>\n"
			+ "  <nickname>beast</nickname>\n" + "</ObjectNode>\n";
		assertEquals(expected, actual);

	}
}