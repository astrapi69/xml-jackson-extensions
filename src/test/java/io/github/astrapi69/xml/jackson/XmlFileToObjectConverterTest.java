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
import java.util.HashSet;

import org.junit.jupiter.api.Test;

import io.github.astrapi69.file.search.PathFinder;
import io.github.astrapi69.test.object.Employee;
import io.github.astrapi69.test.object.Person;
import io.github.astrapi69.test.object.enumtype.Gender;

/**
 * The unit test class for the class {@link XmlFileToObjectConverter}
 */
public class XmlFileToObjectConverterTest
{


	/**
	 * Test method for {@link XmlFileToObjectConverter#toObject(File, Class)}
	 */
	@Test
	void toObjectFileClass()
	{
		Employee actual;
		Employee expected;
		File xmlFile;
		Person person;
		Employee employee;

		person = Person.builder().gender(Gender.FEMALE).name("Anna").nickname("").married(null)
			.about("").build();

		employee = Employee.builder().id("23").person(person).subOrdinates(new HashSet<>()).build();

		xmlFile = PathFinder.getRelativePath(PathFinder.getSrcTestResourcesDir(),
			"new-employee.xml");
		XmlFileToObjectConverter converter = new XmlFileToObjectConverter();
		actual = converter.toObject(xmlFile, Employee.class);
		assertNotNull(actual);
		expected = employee;
		assertEquals(actual, expected);

	}
}
