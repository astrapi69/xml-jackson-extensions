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

import java.io.File;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import io.github.astrapi69.throwable.RuntimeExceptionDecorator;
import io.github.astrapi69.xml.jackson.factory.XmlMapperFactory;
import lombok.NonNull;

/**
 * The class {@link ObjectToXmlExtensions} provides methods for convert java objects to xml string
 * objects
 */
public final class ObjectToXmlExtensions
{

	private ObjectToXmlExtensions()
	{
	}

	/**
	 * Creates from the given Object an xml string.
	 *
	 * @param <T>
	 *            the generic type of the return type
	 * @param objectToXML
	 *            the object to xml
	 * @return the xml string
	 * @throws JsonProcessingException
	 *             is thrown when processing json content that are not pure I/O problems
	 */
	public static <T> String toXml(final @NonNull T objectToXML) throws JsonProcessingException
	{
		XmlMapper xmlMapper = XmlMapperFactory.newXmlMapper();
		return xmlMapper.writeValueAsString(objectToXML);
	}

	/**
	 * Converts the given object to a xml string and write it to the given file object
	 *
	 * @param <T>
	 *            the generic type of the return type
	 * @param object
	 *            the object to convert to xml
	 * @param file
	 *            the file object
	 */
	public static <T> void toXml(final @NonNull T object, final @NonNull File file)
	{
		XmlMapper xmlMapper = XmlMapperFactory.newXmlMapper();
		RuntimeExceptionDecorator.decorate(() -> xmlMapper.writeValue(file, object));
	}

}
