#!/bin/bash

mvn -B -DskipTests clean package

docker build -t backendreal .

docker run --rm -it --network="host" --name backendreal backendreal

