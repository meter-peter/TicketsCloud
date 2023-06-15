#!/bin/bash

# Create a user-defined network
docker network create dvdnetwork

# Start the database container
docker run -d --name  dvddatabase \
  --network dvdnetwork \
  -e MYSQL_ROOT_PASSWORD=pass1312 \
  -e MYSQL_DATABASE=dvds \
  -p 8080:8080 \
  -v dbvolume:/var/lib/mysql \
  mysql:latest

# Start the service container
docker run -d --name dvdservice \
  --network dvdnetwork \
  -p 8080:8080 \
  -v servicevolume:/app/logs \
  dvdservice

# Clean up any intermediate containers or images (optional)
docker system prune -f
