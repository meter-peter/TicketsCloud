#!/bin/bash

# Stop and remove the containers
docker stop dvddatabase dvdservice
docker rm dvddatabase dvdservice

# Remove the network
docker network rm dvdnetwork

# Remove the volumes
docker volume rm servicevolume dbvolume
