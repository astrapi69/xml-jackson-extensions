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

import org.junit.jupiter.api.Test;
import org.meanbean.test.BeanTester;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.github.astrapi69.file.search.PathFinder;
import io.github.astrapi69.test.object.Employee;
import io.github.astrapi69.test.object.Person;
import io.github.astrapi69.test.object.enumtype.Gender;
import io.github.astrapi69.xml.jackson.factory.XmlMapperFactory;

/**
 * The unit test class for the class {@link XmlFileToObjectExtensions}
 */
public class XmlFileToObjectExtensionsTest
{

	/**
	 * Test method for {@link XmlFileToObjectExtensions#toObject(File, Class)}
	 */
	@Test
	void toObjectFileClass() throws JsonProcessingException
	{
		Employee actual;
		Employee expected;
		File xmlFile;
		Person person;
		Employee employee;

		person = Person.builder().gender(Gender.FEMALE).name("Anna").nickname("").about("").build();

		employee = Employee.builder().id("23").person(person).build();

		xmlFile = PathFinder.getRelativePath(PathFinder.getSrcTestResourcesDir(), "newtest.xml");
		actual = XmlFileToObjectExtensions.toObject(xmlFile, Employee.class);
		assertNotNull(actual);
		expected = employee;
		assertEquals(actual, expected);
	}

	/**
	 * Test method for {@link XmlFileToObjectExtensions#toObject(File, TypeReference)}
	 */
	@Test
	void toObjectFileTypeReference() throws JsonProcessingException
	{
		Employee actual;
		Employee expected;
		File xmlFile;
		Person person;
		Employee employee;

		person = Person.builder().gender(Gender.FEMALE).name("Anna").nickname("").about("").build();

		employee = Employee.builder().id("23").person(person).build();

		xmlFile = PathFinder.getRelativePath(PathFinder.getSrcTestResourcesDir(), "newtest.xml");
		TypeReference<Employee> typeReference = new TypeReference<>()
		{
		};
		actual = XmlFileToObjectExtensions.toObject(xmlFile, typeReference);
		assertNotNull(actual);
		expected = employee;
		assertEquals(actual, expected);
	}

	/**
	 * Test method for {@link XmlFileToObjectExtensions#toObject(File, TypeReference, ObjectMapper)}
	 */
	@Test
	void toObjectFileTypeReferenceObjectMapper() throws JsonProcessingException
	{
		Employee actual;
		Employee expected;
		File xmlFile;
		Person person;
		Employee employee;

		person = Person.builder().gender(Gender.FEMALE).name("Anna").nickname("").about("").build();

		employee = Employee.builder().id("23").person(person).build();

		xmlFile = PathFinder.getRelativePath(PathFinder.getSrcTestResourcesDir(), "newtest.xml");
		TypeReference<Employee> typeReference = new TypeReference<>()
		{
		};
		actual = XmlFileToObjectExtensions.toObject(xmlFile, typeReference,
			XmlMapperFactory.newXmlMapper());
		assertNotNull(actual);
		expected = employee;
		assertEquals(actual, expected);
	}

	/**
	 * Test method for {@link XmlFileToObjectExtensions}
	 */
	@Test
	public void testWithBeanTester()
	{
		final BeanTester beanTester = new BeanTester();
		beanTester.testBean(XmlFileToObjectExtensions.class);
	}

}
