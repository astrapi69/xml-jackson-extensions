/**
 * The MIT License
 * <p>
 * Copyright (C) 2022 Asterios Raptis
 * <p>
 * Permission is hereby granted, free of charge, to any person obtaining
 * a copy of this software and associated documentation files (the
 * "Software"), to deal in the Software without restriction, including
 * without limitation the rights to use, copy, modify, merge, publish,
 * distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject to
 * the following conditions:
 * <p>
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 * <p>
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
import java.nio.charset.Charset;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.meanbean.test.BeanTester;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import io.github.astrapi69.collection.list.ListFactory;
import io.github.astrapi69.collection.map.MapFactory;
import io.github.astrapi69.file.delete.DeleteFileExtensions;
import io.github.astrapi69.file.read.ReadFileExtensions;
import io.github.astrapi69.file.search.PathFinder;
import io.github.astrapi69.test.object.Employee;
import io.github.astrapi69.test.object.Person;
import io.github.astrapi69.test.object.enumtype.Gender;
import io.github.astrapi69.throwable.RuntimeExceptionDecorator;
import io.github.astrapi69.xml.jackson.factory.JavaTypeFactory;
import io.github.astrapi69.xml.jackson.factory.XmlMapperFactory;

/**
 * The unit test class for the class {@link XmlToObjectExtensions}
 */
public class XmlToObjectExtensionsTest
{


	/**
	 * Test method for {@link XmlToObjectExtensions#toObject(String, Class)}
	 *
	 * @throws JsonProcessingException
	 *             is thrown when processing json content that are not pure I/O problems
	 */
	@Test
	void toObjectXmlStringClass() throws JsonProcessingException
	{
		Employee actual;
		Employee expected;
		File xmlFile;
		Person person;
		Employee employee;
		String xmlString;

		person = Person.builder().gender(Gender.FEMALE).name("Anna").nickname("").about("").build();

		employee = Employee.builder().id("23").person(person).build();

		xmlFile = PathFinder.getRelativePath(PathFinder.getSrcTestResourcesDir(), "newtest.xml");
		xmlString = RuntimeExceptionDecorator.decorate(() -> ReadFileExtensions.fromFile(xmlFile));
		actual = XmlToObjectExtensions.toObject(xmlString, Employee.class);
		assertNotNull(actual);
		expected = employee;
		assertEquals(actual, expected);
	}

	/**
	 * Test method for {@link XmlToObjectExtensions#toObject(String, TypeReference)}
	 *
	 * @throws JsonProcessingException
	 *             is thrown when processing json content that are not pure I/O problems
	 */
	@Test
	void toObjectXmlStringTypeReference() throws JsonProcessingException
	{
		Employee actual;
		Employee expected;
		File xmlFile;
		Person person;
		Employee employee;
		String xmlString;

		person = Person.builder().gender(Gender.FEMALE).name("Anna").nickname("").about("").build();

		employee = Employee.builder().id("23").person(person).build();

		xmlFile = PathFinder.getRelativePath(PathFinder.getSrcTestResourcesDir(), "newtest.xml");
		TypeReference<Employee> typeReference = new TypeReference<>()
		{
		};
		xmlString = RuntimeExceptionDecorator.decorate(() -> ReadFileExtensions.fromFile(xmlFile));
		actual = XmlToObjectExtensions.toObject(xmlString, typeReference);
		assertNotNull(actual);
		expected = employee;
		assertEquals(actual, expected);
	}

	/**
	 * Test method for {@link XmlToObjectExtensions#toObject(String, TypeReference, XmlMapper)}
	 *
	 * @throws JsonProcessingException
	 *             is thrown when processing json content that are not pure I/O problems
	 */
	@Test
	void toObjectXmlStringTypeReferenceWithXmlMapper() throws JsonProcessingException
	{
		Employee actual;
		Employee expected;
		File xmlFile;
		Person person;
		Employee employee;
		String xmlString;

		person = Person.builder().gender(Gender.FEMALE).name("Anna").nickname("").about("").build();

		employee = Employee.builder().id("23").person(person).build();

		xmlFile = PathFinder.getRelativePath(PathFinder.getSrcTestResourcesDir(), "newtest.xml");
		TypeReference<Employee> typeReference = new TypeReference<>()
		{
		};
		xmlString = RuntimeExceptionDecorator.decorate(() -> ReadFileExtensions.fromFile(xmlFile));
		actual = XmlToObjectExtensions.toObject(xmlString, typeReference,
			XmlMapperFactory.newXmlMapper());
		assertNotNull(actual);
		expected = employee;
		assertEquals(actual, expected);
	}

	/**
	 * Test method for {@link XmlToObjectExtensions#toObject(String, JavaType)} with a {@link List}
	 */
	@Test
	public void toObjectXmlStringJavaType() throws IOException
	{
		List<Person> actual;
		List<Person> expected;
		Person person;
		Person person2;
		File xmlFile;
		String xmlString;

		person = Person.builder().gender(Gender.FEMALE).name("Anna").nickname("").married(false)
			.about("").build();
		person2 = Person.builder().gender(Gender.MALE).name("Anton").nickname("").married(false)
			.about("").build();

		xmlFile = PathFinder.getRelativePath(PathFinder.getSrcTestResourcesDir(), "employees.xml");
		expected = ListFactory.newArrayList(person, person2);
		ObjectToXmlExtensions.toXml(expected, xmlFile);

		xmlString = RuntimeExceptionDecorator
			.decorate(() -> ReadFileExtensions.fromFile(xmlFile, Charset.forName("UTF-8")));

		JavaType type = JavaTypeFactory.newCollectionType(List.class, Person.class);
		actual = XmlToObjectExtensions.toObject(xmlString, type);
		assertEquals(actual, expected);
		DeleteFileExtensions.delete(xmlFile);
	}

	/**
	 * Test method for {@link XmlToObjectExtensions#toObject(String, JavaType)} with a {@link List}
	 */
	@Test
	public void toObjectXmlStringJavaTypeMap() throws IOException
	{
		Map<String, Person> actual;
		Map<String, Person> expected;
		Person person;
		Person person2;
		File xmlFile;
		String xmlString;

		person = Person.builder().gender(Gender.FEMALE).name("Anna").nickname("").married(false)
			.about("").build();
		person2 = Person.builder().gender(Gender.MALE).name("Anton").nickname("").married(false)
			.about("").build();

		xmlFile = PathFinder.getRelativePath(PathFinder.getSrcTestResourcesDir(), "employees.xml");

		expected = MapFactory.newLinkedHashMap();
		expected.put("foo", person);
		expected.put("bar", person2);
		ObjectToXmlExtensions.toXml(expected, xmlFile);

		xmlString = RuntimeExceptionDecorator
			.decorate(() -> ReadFileExtensions.fromFile(xmlFile, Charset.forName("UTF-8")));

		JavaType type = JavaTypeFactory.newMapType(Map.class, String.class, Person.class);
		actual = XmlToObjectExtensions.toObject(xmlString, type);
		assertEquals(actual, expected);
		DeleteFileExtensions.delete(xmlFile);
	}

	/**
	 * Test method for {@link XmlToObjectExtensions#toObject(String, JavaType, XmlMapper)} with a
	 * {@link List}
	 */
	@Test
	public void toObjectXmlStringJavaTypeWithXmlMapper() throws IOException
	{
		List<Person> actual;
		List<Person> expected;
		Person person;
		Person person2;
		File xmlFile;
		String xmlString;

		person = Person.builder().gender(Gender.FEMALE).name("Anna").nickname("").married(false)
			.about("").build();
		person2 = Person.builder().gender(Gender.MALE).name("Anton").nickname("").married(false)
			.about("").build();

		xmlFile = PathFinder.getRelativePath(PathFinder.getSrcTestResourcesDir(), "employees.xml");
		expected = ListFactory.newArrayList(person, person2);
		ObjectToXmlExtensions.toXml(expected, xmlFile);
		xmlString = RuntimeExceptionDecorator
			.decorate(() -> ReadFileExtensions.fromFile(xmlFile, Charset.forName("UTF-8")));

		JavaType type = JavaTypeFactory.newCollectionType(List.class, Person.class);
		actual = XmlToObjectExtensions.toObject(xmlString, type, XmlMapperFactory.newXmlMapper());
		assertEquals(actual, expected);
		DeleteFileExtensions.delete(xmlFile);
	}

	/**
	 * Test method for {@link XmlToObjectExtensions}
	 */
	@Test
	public void testWithBeanTester()
	{
		final BeanTester beanTester = new BeanTester();
		beanTester.testBean(XmlToObjectExtensions.class);
	}
}
