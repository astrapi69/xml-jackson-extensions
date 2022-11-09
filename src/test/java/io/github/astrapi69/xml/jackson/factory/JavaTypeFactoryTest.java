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
package io.github.astrapi69.xml.jackson.factory;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import io.github.astrapi69.test.object.Person;

/**
 * The unit test class for the class {@link JavaTypeFactory}
 */
public class JavaTypeFactoryTest
{

	/**
	 * Test method for {@link JavaTypeFactory#newCollectionType(XmlMapper, Class, Class)}
	 */
	@Test
	public void testNewCollectionTypeWithXmlMapper()
	{
		JavaType actual;
		actual = JavaTypeFactory.newCollectionType(XmlMapperFactory.newXmlMapper(), List.class,
			Person.class);
		assertNotNull(actual);
	}

	/**
	 * Test method for {@link JavaTypeFactory#newCollectionType(Class, Class)}
	 */
	@Test
	public void testNewCollectionType()
	{
		JavaType actual;
		actual = JavaTypeFactory.newCollectionType(List.class, Person.class);
		assertNotNull(actual);
	}
}
