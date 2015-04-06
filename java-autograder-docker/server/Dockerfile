FROM ubuntu:15.04
MAINTAINER Justin Grant <jlgrock@gmail.com> "http://www.justinleegrant.com"

# Update apt-get and install add-apt-repository
RUN apt-get update -qqy && \
	apt-get install -qqy software-properties-common

# Install Java.
RUN \
  echo oracle-java8-installer shared/accepted-oracle-license-v1-1 select true | debconf-set-selections && \
  add-apt-repository -y ppa:webupd8team/java && \
  apt-get update -qqy && \
  apt-get install -y oracle-java8-installer && \
  rm -rf /var/lib/apt/lists/* && \
  rm -rf /var/cache/oracle-jdk8-installer

# Define working directory.
WORKDIR /data

# Define commonly used JAVA_HOME variable
ENV JAVA_HOME /usr/lib/jvm/java-8-oracle

## install everything required for Docker
RUN apt-get update -qq && apt-get install -qqy \
	wget \
	curl \
	zip \
	unzip \
	apt-transport-https \
    ca-certificates \
    curl \
    lxc \
    iptables

# Download the latest version of docker
RUN curl -sSL https://get.docker.com/ubuntu/ | sh

# Install the magic wrapper.
ADD ./wrapdocker.sh /usr/local/bin/wrapdocker.sh
RUN chmod +x /usr/local/bin/wrapdocker.sh

# Define additional metadata for our image.
# TODO do I need this volume?
VOLUME /var/lib/docker
CMD ["wrapdocker.sh"]

# To run this container, use the following command:
# docker run --privileged=true -p 127.0.0.1:8080:8080 --lxc-conf="lxc.aa_profile=unconfined" --name=sandbox-master -t=true -i=true sandbox