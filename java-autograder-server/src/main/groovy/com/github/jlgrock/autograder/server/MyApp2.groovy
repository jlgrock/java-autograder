package com.github.jlgrock.autograder.server

import com.spotify.docker.client.DefaultDockerClient
import com.spotify.docker.client.DockerCertificates
import com.spotify.docker.client.DockerClient
import com.spotify.docker.client.messages.ContainerConfig
import com.spotify.docker.client.messages.ContainerCreation
import com.spotify.docker.client.messages.ContainerInfo

import java.nio.file.Paths

class MyApp2 {
    public static void main(String[] args) {
        // Create a client based on DOCKER_HOST and DOCKER_CERT_PATH env vars
        final DockerClient docker = DefaultDockerClient
                .builder()
                .uri(URI.create("https://192.168.59.103:2376"))
                .dockerCertificates(new DockerCertificates(Paths.get("/Users/jlgrock/.boot2docker/certs/boot2docker-vm")))
                .build();

        // Pull image
        docker.pull("jlgrock/snp-prototype-mongodb");

        // Create container with exposed ports
        final String[] ports = ["27017"] as String[];
        final ContainerConfig config = ContainerConfig
                .builder()
                .image("jlgrock/snp-prototype-mongodb")
                .exposedPorts(ports)
                .build();

        final String name = "snp-mongodb";
        final ContainerCreation creation = docker.createContainer(config, name);
        final String id = creation.id();

        // Inspect container
        final ContainerInfo info = docker.inspectContainer(id);

        // Start container
        docker.startContainer(id);
    }
}