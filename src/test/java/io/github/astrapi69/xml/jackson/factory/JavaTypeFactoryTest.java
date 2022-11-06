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
