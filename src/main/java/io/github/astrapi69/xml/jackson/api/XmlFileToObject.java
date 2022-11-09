package io.github.astrapi69.xml.jackson.api;

import java.io.File;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JavaType;

public interface XmlFileToObject extends io.github.astrapi69.xml.api.XmlFileToObject
{
	<T> T toObject(final File xmlFile, final TypeReference<T> typeReference);

	<T> T toObject(final File xmlFile, final JavaType javaType);
}
