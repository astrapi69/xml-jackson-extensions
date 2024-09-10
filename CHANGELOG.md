## Change log
----------------------

Version 2.2-SNAPSHOT
-------------

ADDED:

- new libs.versions.toml file for new automatic catalog versions update
- new methods for transform object to xml with a given ObjectMapper in class ObjectToXmlExtensions

CHANGED:

- rename of module to new name 'io.github.astrapisixtynine.xml.jackson.extensions'
- update gradle to new version 8.10.1
- update of dependency lombok to new patch version 1.18.34
- update of gradle-plugin dependency with id 'com.github.ben-manes.versions' to new patch version 0.51.0
- update of gradle-plugin dependency with id 'org.ajoberstar.grgit' to new patch version 5.2.2
- update of gradle-plugin dependency with id 'io.freefair.lombok' to new patch version 8.10
- update of gradle-plugin dependency with id 'com.diffplug.spotless' to new beta version 7.0.0.BETA2
- update of dependency throwable to new major version 3
- update of dependency jackson to new minor version 2.18.0-rc1
- update of dependency file-worker to new minor version 17.4
- update of test dependency silly-collection to new major version 28
- update of test dependency test-object to new major version 9
- update of test dependency junit-jupiter to new minor version 5.11.0

Version 2.1
-------------

ADDED:

- new factory methods in class JavaTypeFactory for map
- new factory methods in class JavaTypeFactory generic type class

CHANGED:

- increased code coverage

Version 2
-------------

ADDED:

- new factory methods in class JavaTypeFactory for map
- new converter class for convert json to xml
- new factory class ObjectMapperFactory for create ObjectMapper objects

CHANGED:

- update of JDK to newer version 17
- update gradle to new version 8.4
- update of dependency lombok to new patch version 1.18.30
- update of gradle-plugin dependency io.freefair.gradle:lombok-plugin to new patch version 8.4
- update of gradle plugin dependency com.github.ben-manes.versions.gradle.plugin to new minor version 0.49.0
- update of gradle-plugin dependency 'org.ajoberstar.grgit:grgit-gradle' to new version 5.2.0
- update of gradle plugin dependency com.diffplug.spotless:spotless-plugin-gradle to new minor version 6.22.0
- update of dependency jackson to new minor version 2.15.3
- update of dependency file-worker to new major version 17
- update of test dependency silly-collection to new major version 27
- update of test dependency junit-jupiter-api to new minor version 5.10.0
- update of test dependency 'com.github.meanbeanlib:meanbean' to new version 3.0.0-M9

Version 1.1
-------------

ADDED:

- new module-info.java file for module description
- all required package-info.java files
- new interface JacksonXmlToObject that implements specific jackson conversion types
- new interface JacksonXmlFileToObject that implements specific jackson conversion types
- new class ObjectToXmlFileConverter for convert an object to and saves it to a xml file
- new class XmlFileToObjectConverter for convert a xml file to and saves it to an object
- new methods with argument JavaType in extension class XmlToObjectExtensions
- new test dependency silly-collection in version 20.1
- new test dependency silly-bean in version 2

CHANGED:

- update of gradle to new version 7.6-rc-2
- update of gradle plugin dependency com.github.ben-manes.versions.gradle.plugin to new minor version 0.43.0
- update of gradle-plugin dependency of 'io.freefair.gradle:lombok-plugin' in version 6.5.1
- update of gradle-plugin dependency of 'com.diffplug.spotless:spotless-plugin-gradle' in version 6.11.0
- update of dependency xml-api to new minor version 1.4
- update of dependency jackson to new minor version 2.14.0
- update of dependency throwable to new minor version 2.3
- update of dependency file-worker to new patch version 11.5.1
- update of test dependency test-object to new minor version 7.2
- update of test dependency junit-jupiter-api to new minor version 5.9.1

Version 1
-------------

ADDED:

- new CHANGELOG.md file created
- new converter classes for transform from xml string to object and back

Notable links:
[keep a changelog](http://keepachangelog.com/en/1.0.0/) Don’t let your friends dump git logs into changelogs
