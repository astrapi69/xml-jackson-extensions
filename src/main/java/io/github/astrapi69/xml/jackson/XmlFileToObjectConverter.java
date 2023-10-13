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

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JavaType;

import io.github.astrapi69.xml.jackson.api.JacksonXmlFileToObject;
import lombok.NonNull;

/**
 * The class {@link XmlFileToObjectConverter} can convert a given xml file to an object
 */
public class XmlFileToObjectConverter implements JacksonXmlFileToObject
{

	/**
	 * {@inheritDoc}
	 */
	@Override
	public <T> T toObject(File xmlFile, TypeReference<T> typeReference)
	{
		return XmlFileToObjectExtensions.toObject(xmlFile, typeReference);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public <T> T toObject(File xmlFile, JavaType javaType)
	{
		return XmlFileToObjectExtensions.toObject(xmlFile, javaType);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public <T> T toObject(@NonNull File file, @NonNull Class<T> aClass)
	{
		return XmlFileToObjectExtensions.toObject(file, aClass);
	}
}
