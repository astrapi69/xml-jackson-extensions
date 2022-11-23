/**
 * Description of this module
 */
module xml.jackson.extensions {
    requires lombok;
    requires com.fasterxml.jackson.core;
    requires com.fasterxml.jackson.databind;
    requires com.fasterxml.jackson.dataformat.xml;
    requires throwable;
    requires xml.api.main;
    exports io.github.astrapi69.xml.jackson;
    exports io.github.astrapi69.xml.jackson.api;
    exports io.github.astrapi69.xml.jackson.factory;
}
