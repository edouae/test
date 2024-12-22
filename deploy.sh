/bin/bash

# Variables (Customize these)
DOCKER_USERNAME="douae196"
DOCKER_PASSWORD="dckr_pat_4y5SoYZHAWjGvSgUUOFjJSgPKU"
DOCKER_IMAGE_NAME="douaeimage"
DOCKER_IMAGE_TAG="latest"
REMOTE_SERVER="192.168.19.131"
REMOTE_SSH_USER="douae"

# Build the Docker image
echo "Building Docker image..."
docker build -t ${DOCKER_USERNAME}/${DOCKER_IMAGE_NAME}:${DOCKER_IMAGE_TAG} .

# Login to DockerHub
echo "Logging in to DockerHub..."
echo "$DOCKER_PASSWORD" | docker login -u "$DOCKER_USERNAME" --password-stdin

# Push the image to DockerHub
echo "Pushing image to DockerHub..."
docker push ${DOCKER_USERNAME}/${DOCKER_IMAGE_NAME}:${DOCKER_IMAGE_TAG}

# Pull and run the image on the remote server via SSH
echo "Pulling and running the Docker image on the remote server..."
ssh ${REMOTE_SSH_USER}@${REMOTE_SERVER} << EOF
    docker pull ${DOCKER_USERNAME}/${DOCKER_IMAGE_NAME}:${DOCKER_IMAGE_TAG}
    docker stop ${DOCKER_IMAGE_NAME} || true
    docker rm ${DOCKER_IMAGE_NAME} || true
    docker run -d --name ${DOCKER_IMAGE_NAME} ${DOCKER_USERNAME}/${DOCKER_IMAGE_NAME}:${DOCKER_IMAGE_TAG}
EOF

# Confirmation message
echo "Deployment completed successfully."
