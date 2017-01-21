#!/usr/bin/env bash
mvn install:install-file -Dfile=ojdbc7.jar -DgroupId=com.oracle -DartifactId=ojdbc7 -Dversion=12.1.0.1 -Dpackaging=jar
mvn install:install-file -Dfile=ucp.jar -DgroupId=com.oracle.jdbc -DartifactId=ucp -Dversion=12.1.0.1 -Dpackaging=jar