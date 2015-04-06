FROM ubuntu:14.10
MAINTAINER Justin Grant <jlgrock@gmail.com> "http://www.justinleegrant.com"

ENV $JAVA_AUTOGRADER_VERSION=0.1

## TODO check the docker version
RUN apt-get update && apt-get install -y openjdk-8-jdk git \
	git-core wget curl zip unzip docker.io 

# TODO add the code
ADD target/java-autograder-server-$JAVA_AUTOGRADER_VERSION.war /vol/java-autograder.war
