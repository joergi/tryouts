#!/bin/bash
set -euo pipefail
IFS=$'\n\t'

sudo rm -rf ./database-data
mkdir -p ./database-data
docker compose down -v
docker compose up -d db
mvn clean flyway:migrate flyway:validate
#spring-boot:run
#mvn spring-boot:run

