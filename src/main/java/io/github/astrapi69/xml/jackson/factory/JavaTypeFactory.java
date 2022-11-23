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

import java.lang.reflect.Type;
import java.util.Collection;

import com.fasterxml.jackson.core.type.TypeReference;
import lombok.NonNull;

import com.fasterxml.jackson.databind.JavaType;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;

/**
 * The factory class {@link JavaTypeFactory} for creating {@link JavaType} objects for serializing
 * java collection beans to xml string and deserialize xml string to java collection beans
 */
public class JavaTypeFactory
{
	private JavaTypeFactory()
	{
	}


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
	 * @return the new {@link JavaType}
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
	 * @return the new {@link JavaType}
	 */
	public static JavaType newCollectionType(
		final @NonNull Class<? extends Collection> collectionClass,
		final @NonNull Class<?> elementClass)
	{
		return newCollectionType(XmlMapperFactory.newXmlMapper(), collectionClass, elementClass);
	}

	/**
	 * Factory method for create a new {@link JavaType} from the given xml mapper, the map class and
	 * the key java type and value java type
	 *
	 * @param xmlMapper
	 *            the xml mapper
	 * @param mapClass
	 *            the map class
	 * @param keyType
	 *            the key type
	 * @param valueType
	 *            the value type
	 * @return the new {@link JavaType}
	 */
	public static JavaType newMapType(final @NonNull XmlMapper xmlMapper,
		final @NonNull Class<?> mapClass, final @NonNull JavaType keyType,
		final @NonNull JavaType valueType)
	{
		return xmlMapper.getTypeFactory().constructMapLikeType(mapClass, keyType, valueType);
	}

	/**
	 * Factory method for create a new {@link JavaType} from the given xml mapper, the map class and
	 * the key java type and value java type
	 *
	 * @param xmlMapper
	 *            the xml mapper
	 * @param mapClass
	 *            the map class
	 * @param keyClass
	 *            the key class
	 * @param valueClass
	 *            the value class
	 * @return the new {@link JavaType}
	 */
	public static JavaType newMapType(final @NonNull XmlMapper xmlMapper,
		final @NonNull Class<?> mapClass, final @NonNull Class<?> keyClass,
		final @NonNull Class<?> valueClass)
	{
		return xmlMapper.getTypeFactory().constructMapLikeType(mapClass, keyClass, valueClass);
	}

	/**
	 * Factory method for create a new {@link JavaType} from the given xml mapper with the given
	 * type
	 *
	 * @param xmlMapper
	 *            the xml mapper
	 * @param type
	 *            the type
	 * @return the new {@link JavaType}
	 */
	public static JavaType newJavaType(final @NonNull XmlMapper xmlMapper, final @NonNull Type type)
	{
		return xmlMapper.getTypeFactory().constructType(type);
	}

	/**
	 * Factory method for create a new {@link TypeReference} from the given type class
	 *
	 * @param typeClass
	 *            the type class
	 * @return the new {@link TypeReference}
	 */
	public static <T> TypeReference<T> newTypeReference(final @NonNull Class<T> typeClass)
	{
		return new TypeReference<T>()
		{
			@Override
			public Type getType()
			{
				return typeClass;
			}
		};
	}

	/**
	 * Factory method for create a new {@link JavaType} from the given xml mapper with the given
	 * type reference
	 *
	 * @param xmlMapper
	 *            the xml mapper
	 * @param typeReference
	 *            the type reference
	 * @return the new {@link JavaType}
	 */
	public static <T> JavaType newJavaType(final @NonNull XmlMapper xmlMapper,
		final @NonNull TypeReference<T> typeReference)
	{
		return xmlMapper.getTypeFactory().constructType(typeReference);
	}

}
