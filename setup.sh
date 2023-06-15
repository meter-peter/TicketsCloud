#!/bin/bash

# Build the Docker image
docker build -t dvdservice .

# Clean up any intermediate containers or images (optional)
docker system prune -f
