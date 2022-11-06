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

import java.util.List;

import org.junit.jupiter.api.Test;
import org.meanbean.test.BeanTester;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;

import io.github.astrapi69.collection.list.ListFactory;
import io.github.astrapi69.test.object.Employee;
import io.github.astrapi69.test.object.Person;
import io.github.astrapi69.test.object.enumtype.Gender;
import io.github.astrapi69.xml.jackson.factory.JavaTypeFactory;

/**
 * The unit test class for the class {@link ObjectToXmlExtensions}
 */
public class ObjectToXmlExtensionsTest
{

	/**
	 * Test method for {@link ObjectToXmlExtensions#toXml(Object)}
	 */
	@Test
	public void testToXml() throws JsonProcessingException
	{
		String actual;
		String expected;
		Person person;
		Employee employee;

		person = Person.builder().gender(Gender.FEMALE).name("Anna").nickname(null).married(null)
			.about(null).build();

		employee = Employee.builder().id("23").person(person).build();

		actual = ObjectToXmlExtensions.toXml(employee);
		assertNotNull(actual);
		expected = "<Employee>\n" + "  <id>23</id>\n" + "  <person>\n" + "    <about/>\n"
			+ "    <gender>FEMALE</gender>\n" + "    <married/>\n" + "    <name>Anna</name>\n"
			+ "    <nickname/>\n" + "  </person>\n" + "  <subOrdinates/>\n" + "</Employee>\n";
		assertEquals(actual, expected);
	}

	/**
	 * Test method for {@link ObjectToXmlExtensions#toXml(Object)} with a {@link List}
	 */
	@Test
	public void testToXmlWithXStreamXStreamObjectWithList() throws JsonProcessingException
	{
		String actual;
		String expected;
		Person person;
		Person person2;
		List<Person> personList;

		person = Person.builder().gender(Gender.FEMALE).name("Anna").nickname("").married(false)
			.about("").build();
		person2 = Person.builder().gender(Gender.MALE).name("Anton").nickname("").married(false)
			.about("").build();

		personList = ListFactory.newArrayList(person, person2);
		actual = ObjectToXmlExtensions.toXml(personList);
		expected = "<ArrayList>\n" + "  <item>\n" + "    <about></about>\n"
			+ "    <gender>FEMALE</gender>\n" + "    <married>false</married>\n"
			+ "    <name>Anna</name>\n" + "    <nickname></nickname>\n" + "  </item>\n"
			+ "  <item>\n" + "    <about></about>\n" + "    <gender>MALE</gender>\n"
			+ "    <married>false</married>\n" + "    <name>Anton</name>\n"
			+ "    <nickname></nickname>\n" + "  </item>\n" + "</ArrayList>\n";
		assertNotNull(actual);
		assertEquals(expected, actual);
		JavaType type = JavaTypeFactory.newCollectionType(List.class, Person.class);
		List<Person> personList2 = XmlToObjectExtensions.toObject(actual, type);
		assertEquals(personList2, personList);
	}


	/**
	 * Test method for {@link ObjectToXmlExtensions}
	 */
	@Test
	public void testWithBeanTester()
	{
		final BeanTester beanTester = new BeanTester();
		beanTester.testBean(ObjectToXmlExtensions.class);
	}

}
