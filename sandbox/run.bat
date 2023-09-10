docker network create elastic

docker compose -f elk/docker-compose.yml up -d
docker compose -f app/docker-compose.yml up -d

echo "Initializing..."
