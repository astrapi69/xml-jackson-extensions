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
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.meanbean.test.BeanTester;

import io.github.astrapi69.test.object.Employee;
import io.github.astrapi69.test.object.Person;
import io.github.astrapi69.test.object.enumtype.Gender;

/**
 * The unit test class for the class {@link ObjectToXmlConverter}
 */
public class ObjectToXmlConverterTest
{

	/**
	 * Test method for {@link ObjectToXmlConverter#toXml(Object)}
	 */
	@Test
	public void testToXml()
	{
		String actual;
		String expected;
		Person person;
		Employee employee;

		person = Person.builder().gender(Gender.FEMALE).name("Anna").nickname(null).married(null)
			.about(null).build();

		employee = Employee.builder().id("23").person(person).build();

		ObjectToXmlConverter objectToXmlConverter = new ObjectToXmlConverter();
		actual = objectToXmlConverter.toXml(employee);
		expected = "<Employee>\n" + "  <id>23</id>\n" + "  <person>\n" + "    <about/>\n"
			+ "    <gender>FEMALE</gender>\n" + "    <married/>\n" + "    <name>Anna</name>\n"
			+ "    <nickname/>\n" + "  </person>\n" + "  <subOrdinates/>\n" + "</Employee>\n";
		assertNotNull(actual);
		assertEquals(actual, expected);

		NullPointerException nullPointerException = Assertions
			.assertThrows(NullPointerException.class, () -> objectToXmlConverter.toXml(null));

		Assertions.assertEquals("object is marked non-null but is null",
			nullPointerException.getMessage());
	}

	/**
	 * Test method for {@link ObjectToXmlConverter#toXml(Object)}
	 */
	@Test
	public void testToXmlWithNullValue()
	{
		String actual;
		String expected;
		ObjectToXmlConverter objectToXmlConverter = new ObjectToXmlConverter();
		NullPointerException nullPointerException = Assertions
			.assertThrows(NullPointerException.class, () -> objectToXmlConverter.toXml(null));
		expected = "object is marked non-null but is null";
		actual = nullPointerException.getMessage();
		assertEquals(expected, actual);
	}

	/**
	 * Test method for {@link ObjectToXmlConverter}
	 */
	@Test
	public void testWithBeanTester()
	{
		final BeanTester beanTester = new BeanTester();
		beanTester.testBean(ObjectToXmlConverter.class);
	}
}
