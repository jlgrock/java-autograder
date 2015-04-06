package com.github.jlgrock.autograder.server

import com.spotify.docker.client.DefaultDockerClient
import com.spotify.docker.client.DockerClient
import com.spotify.docker.client.messages.*

class MyApp {
    public static void main(String[] args) {
        // Create a client based on DOCKER_HOST and DOCKER_CERT_PATH env vars
        final DockerClient docker = DefaultDockerClient.fromEnv().build();

        // Pull image
        docker.pull("busybox");

        // Create container with exposed ports
        final String[] ports = ["80", "22" ] as String[];
        final ContainerConfig config = ContainerConfig.builder()
                .image("busybox").exposedPorts(ports)
                .cmd("sh", "-c", "while :; do sleep 1; done")
                .build();

        // bind container ports to host ports
        final Map<String, List<PortBinding>> portBindings = new HashMap<String, List<PortBinding>>();
        for (String port : ports) {
            List<PortBinding> hostPorts = new ArrayList<PortBinding>();
            hostPorts.add(PortBinding.of("0.0.0.0", port));
            portBindings.put(port, hostPorts);
        }
        final HostConfig hostConfig = HostConfig.builder().portBindings(portBindings).build();

        final ContainerCreation creation = docker.createContainer(config);
        final String id = creation.id();

        // Inspect container
        final ContainerInfo info = docker.inspectContainer(id);

        // Start container
        docker.startContainer(id, hostConfig);
    }
}