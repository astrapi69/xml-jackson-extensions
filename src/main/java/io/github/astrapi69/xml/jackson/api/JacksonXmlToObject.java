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
package io.github.astrapi69.xml.jackson.api;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JavaType;

import io.github.astrapi69.xml.api.XmlFileToObject;
import io.github.astrapi69.xml.api.XmlToObject;
import lombok.NonNull;

/**
 * If a class implements the interface {@link JacksonXmlToObject} extends the interface
 * {@link XmlFileToObject} and will provide algorithms for transform a xml string to an object
 */
public interface JacksonXmlToObject extends XmlToObject
{

	/**
	 * Transforms the given xml {@link String} object to an object of the given type reference
	 *
	 * @param <T>
	 *            the generic type of the argument object class type
	 * @param xmlString
	 *            the xml as {@link String} object
	 * @param typeReference
	 *            the type reference
	 * @return the object
	 */
	<T> T toObject(final @NonNull String xmlString, final @NonNull TypeReference<T> typeReference);

	/**
	 * Creates from the given xml string an java object.
	 *
	 * @param <T>
	 *            the generic type of the return type
	 * @param xmlString
	 *            the xml
	 * @param javaType
	 *            the java type
	 * @return the object
	 */
	<T> T toObject(final @NonNull String xmlString, final @NonNull JavaType javaType);
}
