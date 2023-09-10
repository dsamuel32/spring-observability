docker network create elastic

sudo chown root app/filebeat/filebeat.docker.yml

mkdir -m 777 .docker
mkdir -m 777 .docker/es01
mkdir -m 777 .docker/filebeat


docker compose -f elk/docker-compose.yml up

echo "Initializing..."
