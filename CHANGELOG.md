## Change log
----------------------

Version 1.2-SNAPSHOT
-------------

ADDED:

- new factory methods in class JavaTypeFactory for map

CHANGED:

- update gradle to new version 8.0.1
- update of dependency lombok to new patch version 1.18.26
- update of gradle-plugin dependency io.freefair.gradle:lombok-plugin to new patch version 6.6.3
- update of gradle plugin dependency com.github.ben-manes.versions.gradle.plugin to new minor version 0.46.0
- update of gradle plugin dependency com.diffplug.spotless:spotless-plugin-gradle to new minor version 6.16.0
- update of dependency jackson to new minor version 2.14.2
- update of dependency file-worker to new patch version 11.6
- update of test dependency silly-collection to new major version 21
- update of test dependency junit-jupiter-api to new minor version 5.9.2

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
