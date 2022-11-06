package io.github.astrapi69.xml.jackson.factory;

import java.util.Collection;

import lombok.NonNull;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

/**
 * The factory class {@link JavaTypeFactory} for creating {@link JavaType} objects for serializing
 * java collection beans to xml string and deserialize xml string to java collection beans
 */
public class JavaTypeFactory
{

	/**
	 * Factory method for create a new {@link JavaType} from the given xml mapper, the collection
	 * class and the element class
	 *
	 * @param xmlMapper
	 *            the xml mapper
	 * @param collectionClass
	 *            the collection class
	 * @param elementClass
	 *            the element class
	 * @return the new {@link ObjectMapper}
	 */
	public static JavaType newCollectionType(final @NonNull XmlMapper xmlMapper,
		final @NonNull Class<? extends Collection> collectionClass,
		final @NonNull Class<?> elementClass)
	{
		return xmlMapper.getTypeFactory().constructCollectionType(collectionClass, elementClass);
	}

	/**
	 * Factory method for create a new {@link JavaType} from the given collection class and the
	 * element class
	 *
	 * @param collectionClass
	 *            the collection class
	 * @param elementClass
	 *            the element class
	 * @return the new {@link ObjectMapper}
	 */
	public static JavaType newCollectionType(
		final @NonNull Class<? extends Collection> collectionClass,
		final @NonNull Class<?> elementClass)
	{
		return newCollectionType(XmlMapperFactory.newXmlMapper(), collectionClass, elementClass);
	}

}
