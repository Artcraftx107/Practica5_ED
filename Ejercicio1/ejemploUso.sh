#!/bin/sh

javac -Xlint:unchecked -d bin --source-path src:test src/EjemploUso.java
java -cp bin EjemploUso

