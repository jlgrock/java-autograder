#!/bin/sh

gradle build

docker build --no-cache=true -t=jlgrock/java-autograder-server .
