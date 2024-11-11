#!/bin/sh

javac -Xlint:unchecked -d bin -cp /usr/share/java/junit-jupiter-api.jar --source-path src:test test/colaPrioridad/HeapColaPrioridadTest.java

java -jar /usr/share/java/junit-platform-console-standalone.jar --class-path bin --scan-class-path

