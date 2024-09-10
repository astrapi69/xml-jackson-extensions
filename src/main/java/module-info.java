/**
 * Description of this module
 */
module io.github.astrapisixtynine.xml.jackson.extensions
{
	requires lombok;
	requires com.fasterxml.jackson.core;
	requires com.fasterxml.jackson.databind;
	requires com.fasterxml.jackson.dataformat.xml;
	requires io.github.astrapisixtynine.throwable;
	requires xml.api.main;

	exports io.github.astrapi69.xml.jackson;
	exports io.github.astrapi69.xml.jackson.api;
	exports io.github.astrapi69.xml.jackson.factory;
}
