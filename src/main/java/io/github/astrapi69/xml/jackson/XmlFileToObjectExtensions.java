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

import java.io.File;
import java.util.Objects;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import io.github.astrapi69.throwable.RuntimeExceptionDecorator;
import io.github.astrapi69.xml.jackson.factory.XmlMapperFactory;
import lombok.NonNull;

/**
 * The class {@link XmlFileToObjectExtensions} provides methods for convert xml string objects to
 * java objects
 */
public final class XmlFileToObjectExtensions
{

	private XmlFileToObjectExtensions()
	{
	}

	/**
	 * Creates from the given xml string an java object.
	 *
	 * @param <T>
	 *            the generic type of the return type
	 * @param file
	 *            the file object
	 * @param clazz
	 *            the class of the generic type
	 * @return the object
	 */
	public static <T> T toObject(final @NonNull File file, final @NonNull Class<T> clazz)
	{
		return RuntimeExceptionDecorator
			.decorate(() -> XmlMapperFactory.newXmlMapper().readValue(file, clazz));
	}

	/**
	 * Creates from the given xml string an java object.
	 *
	 * @param <T>
	 *            the generic type of the return type
	 * @param file
	 *            the file object
	 * @param typeReference
	 *            the type reference
	 * @return the object
	 */
	public static <T> T toObject(final @NonNull File file,
		final @NonNull TypeReference<T> typeReference)
	{
		return toObject(file, typeReference, XmlMapperFactory.newXmlMapper());
	}

	/**
	 * Creates from the given xml string an java object.
	 *
	 * @param <T>
	 *            the generic type of the return type
	 * @param file
	 *            the file object
	 * @param javaType
	 *            the java type
	 * @return the object
	 */
	public static <T> T toObject(final @NonNull File file, final @NonNull JavaType javaType)
	{
		return toObject(file, javaType, XmlMapperFactory.newXmlMapper());
	}

	/**
	 * Creates from the given xml string an java object.
	 *
	 * @param <T>
	 *            the generic type of the return type
	 * @param file
	 *            the file object
	 * @param typeReference
	 *            the type reference
	 * @param xmlMapper
	 *            the xml mapper
	 * @return the object
	 */
	public static <T> T toObject(final @NonNull File file,
		final @NonNull TypeReference<T> typeReference, final @NonNull XmlMapper xmlMapper)
	{
		return RuntimeExceptionDecorator.decorate(() -> xmlMapper.readValue(file, typeReference));
	}

	/**
	 * Creates from the given xml string an java object.
	 *
	 * @param <T>
	 *            the generic type of the return type
	 * @param file
	 *            the file object
	 * @param javaType
	 *            the java type
	 * @param xmlMapper
	 *            the xml mapper
	 * @return the object
	 */
	public static <T> T toObject(final @NonNull File file, final @NonNull JavaType javaType,
		final @NonNull XmlMapper xmlMapper)
	{
		Objects.requireNonNull(javaType);
		Objects.requireNonNull(xmlMapper);
		return RuntimeExceptionDecorator.decorate(() -> xmlMapper.readValue(file, javaType));
	}

}
