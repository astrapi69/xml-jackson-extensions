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

import java.io.File;
import java.io.IOException;
import java.util.HashSet;

import org.junit.jupiter.api.Test;
import org.meanbean.test.BeanTester;

import io.github.astrapi69.file.delete.DeleteFileExtensions;
import io.github.astrapi69.file.search.PathFinder;
import io.github.astrapi69.test.object.Employee;
import io.github.astrapi69.test.object.Person;
import io.github.astrapi69.test.object.enumtype.Gender;
import io.github.astrapi69.throwable.RuntimeExceptionDecorator;

/**
 * The unit test class for the class {@link ObjectToXmlFileConverter}
 */
public class ObjectToXmlFileConverterTest
{

	/**
	 * Test method for {@link ObjectToXmlFileConverter#toXml(Object, File)}
	 *
	 * @throws IOException
	 *             Signals that an I/O exception has occurred
	 */
	@Test
	public void testToXml() throws IOException
	{
		Employee actual;
		Employee expected;
		File xmlFile;
		Person person;
		Employee employee;

		person = Person.builder().gender(Gender.FEMALE).name("Anna").nickname("").married(null)
			.about("").build();

		employee = Employee.builder().id("23").person(person).subOrdinates(new HashSet<>()).build();
		ObjectToXmlFileConverter converter = new ObjectToXmlFileConverter();

		xmlFile = PathFinder.getRelativePath(PathFinder.getSrcTestResourcesDir(), "employee.xml");
		converter.toXml(employee, xmlFile);

		actual = XmlFileToObjectExtensions.toObject(xmlFile, Employee.class);
		assertNotNull(actual);
		expected = employee;
		assertEquals(actual, expected);
		RuntimeExceptionDecorator.decorate(() -> DeleteFileExtensions.delete(xmlFile));
	}

	/**
	 * Test method for {@link ObjectToXmlFileConverter}
	 */
	@Test
	public void testWithBeanTester()
	{
		final BeanTester beanTester = new BeanTester();
		beanTester.testBean(ObjectToXmlFileConverter.class);
	}
}
