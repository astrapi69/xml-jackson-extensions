package io.github.astrapi69.xml.jackson;

import io.github.astrapi69.throwable.RuntimeExceptionDecorator;
import io.github.astrapi69.xml.api.XmlToObject;
import lombok.NonNull;

/**
 * The class {@link XmlToObjectConverter} can convert a given xml string to an object
 */
public class XmlToObjectConverter implements XmlToObject
{

	/**
	 * {@inheritDoc}
	 */
	@Override public <T> T toObject(final @NonNull String xmlString, final @NonNull Class<T> clazz)
	{
		return RuntimeExceptionDecorator.decorate(
			() -> XmlToObjectExtensions.toObject(xmlString, clazz));
	}
}
