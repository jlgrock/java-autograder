FROM ubuntu:15.04
MAINTAINER Justin Grant <jlgrock@gmail.com> "http://www.justinleegrant.com"

# Install Java.
RUN \
  echo oracle-java8-installer shared/accepted-oracle-license-v1-1 select true | debconf-set-selections && \
  add-apt-repository -y ppa:webupd8team/java && \
  apt-get update && \
  apt-get install -y oracle-java8-installer && \
  rm -rf /var/lib/apt/lists/* && \
  rm -rf /var/cache/oracle-jdk8-installer

# Define working directory.
WORKDIR /data

# Define commonly used JAVA_HOME variable
ENV JAVA_HOME /usr/lib/jvm/java-8-oracle

# docker run -privileged=true -p 127.0.0.1:8080:8080 -lxc-conf="lxc.aa_profile=unconfined" -name=sandbox-master -t=true -i=true sandbox