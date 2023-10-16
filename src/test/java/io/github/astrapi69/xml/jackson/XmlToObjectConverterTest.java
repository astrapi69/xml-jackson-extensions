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
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.meanbean.test.BeanTester;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JavaType;

import io.github.astrapi69.collection.list.ListFactory;
import io.github.astrapi69.file.delete.DeleteFileExtensions;
import io.github.astrapi69.file.read.ReadFileExtensions;
import io.github.astrapi69.file.search.PathFinder;
import io.github.astrapi69.test.object.Employee;
import io.github.astrapi69.test.object.Person;
import io.github.astrapi69.test.object.enumtype.Gender;
import io.github.astrapi69.throwable.RuntimeExceptionDecorator;
import io.github.astrapi69.xml.jackson.factory.JavaTypeFactory;

/**
 * The unit test class for the class {@link XmlToObjectConverter}
 */
class XmlToObjectConverterTest
{

	/**
	 * Test method for {@link XmlToObjectConverter#toObject(String, Class)}
	 */
	@Test
	void toObject()
	{
		Employee actual;
		Employee expected;
		Person person;
		String xmlString;

		person = Person.builder().gender(Gender.FEMALE).name("Anna").nickname("").married(null)
			.about("").build();

		expected = Employee.builder().id("23").person(person).build();

		xmlString = "<Employee>\n" + "  <id>23</id>\n" + "  <person>\n" + "    <about/>\n"
			+ "    <gender>FEMALE</gender>\n" + "    <married/>\n" + "    <name>Anna</name>\n"
			+ "    <nickname/>\n" + "  </person>\n" + "  <subOrdinates/>\n" + "</Employee>\n";

		XmlToObjectConverter xmlToObjectConverter = new XmlToObjectConverter();
		actual = xmlToObjectConverter.toObject(xmlString, Employee.class);
		assertNotNull(actual);
		assertEquals(expected, actual);
	}

	/**
	 * Test method for {@link XmlToObjectConverter#toObject(String, Class)}
	 */
	@Test
	public void testToObjectWithNullValue()
	{
		String actual;
		String expected;
		String xmlString;

		xmlString = "<Employee>\n" + "  <id>23</id>\n" + "  <person>\n" + "    <about/>\n"
			+ "    <gender>FEMALE</gender>\n" + "    <married/>\n" + "    <name>Anna</name>\n"
			+ "    <nickname/>\n" + "  </person>\n" + "</Employee>\n";
		XmlToObjectConverter xmlToObjectConverter = new XmlToObjectConverter();
		NullPointerException nullPointerException = Assertions.assertThrows(
			NullPointerException.class, () -> xmlToObjectConverter.toObject(null, Employee.class));
		expected = "xmlString is marked non-null but is null";
		actual = nullPointerException.getMessage();
		assertEquals(expected, actual);

		nullPointerException = Assertions.assertThrows(NullPointerException.class,
			() -> xmlToObjectConverter.toObject(xmlString, (Class<Object>)null));
		expected = "clazz is marked non-null but is null";
		actual = nullPointerException.getMessage();
		assertEquals(expected, actual);
	}

	/**
	 * Test method for {@link XmlToObjectConverter#toObject(String, TypeReference)}
	 */
	@Test
	void toObjectXmlStringTypeReference()
	{
		Employee actual;
		Employee expected;
		File xmlFile;
		Person person;
		Employee employee;
		String xmlString;
		TypeReference<Employee> typeReference;

		person = Person.builder().gender(Gender.FEMALE).name("Anna").nickname("").about("").build();

		employee = Employee.builder().id("23").person(person).build();

		xmlFile = PathFinder.getRelativePath(PathFinder.getSrcTestResourcesDir(), "newtest.xml");

		typeReference = JavaTypeFactory.newTypeReference(Employee.class);
		xmlString = RuntimeExceptionDecorator.decorate(() -> ReadFileExtensions.fromFile(xmlFile));
		XmlToObjectConverter xmlToObjectConverter = new XmlToObjectConverter();
		actual = xmlToObjectConverter.toObject(xmlString, typeReference);
		assertNotNull(actual);
		expected = employee;
		assertEquals(actual, expected);
	}

	/**
	 * Test method for {@link XmlToObjectConverter#toObject(String, JavaType)} with a {@link List}
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

		xmlString = RuntimeExceptionDecorator.decorate(() -> ReadFileExtensions.fromFile(xmlFile));

		JavaType type = JavaTypeFactory.newCollectionType(List.class, Person.class);
		XmlToObjectConverter xmlToObjectConverter = new XmlToObjectConverter();
		actual = xmlToObjectConverter.toObject(xmlString, type);
		assertEquals(actual, expected);
		DeleteFileExtensions.delete(xmlFile);
	}

	/**
	 * Test method for {@link XmlToObjectConverter}
	 */
	@Test
	public void testWithBeanTester()
	{
		final BeanTester beanTester = new BeanTester();
		beanTester.testBean(XmlToObjectConverter.class);
	}

}
