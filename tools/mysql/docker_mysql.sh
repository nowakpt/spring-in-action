#!/bin/bash
# creates and launches docker container with MySQL database
# after the container is created, you can re-launch it with 'docker start spittr-mysql'


CONTAINER_NAME='spittr-mysql'
MYSQL_PORT=3306
MYSQL_ROOT_PASSWORD='change-me'

MYSQL_USER_NAME='spittr'
MYSQL_USER_PASSWORD='change-me'
MYSQL_DATABASE='spittr'


docker run \
	-d \
	--name ${CONTAINER_NAME} \
	-e MYSQL_ROOT_PASSWORD=${MYSQL_ROOT_PASSWORD} \
	-e MYSQL_DATABASE=${MYSQL_DATABASE} \
	-e MYSQL_USER=${MYSQL_USER_NAME} \
	-e MYSQL_PASSWORD=${MYSQL_USER_PASSWORD} \
	-p ${MYSQL_PORT}:3306 \
	mysql


