package io.github.astrapi69.xml.jackson.factory;

import java.util.Collection;

import lombok.NonNull;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class JavaTypeFactory
{

	public static JavaType newCollectionType(final @NonNull XmlMapper xmlMapper,
		final @NonNull Class<? extends Collection> collectionClass,
		final @NonNull Class<?> elementClass)
	{
		return xmlMapper.getTypeFactory().constructCollectionType(collectionClass, elementClass);
	}
}
