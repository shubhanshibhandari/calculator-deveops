#!/bin/bash

echo "********************"
echo "** Pushing image ***"
echo "********************"

#IMAGE="spe-mini-project"

echo "** Logging in ***"
echo $PASS | docker login -u $USER --password-stdin
echo "*** Tagging image ***"
docker tag $IMAGE:$BUILD_NUMBER $USER/$IMAGE:$BUILD_NUMBER
echo "*** Pushing image ***"
docker push $USER/$IMAGE:$BUILD_NUMBER
docker rmi  $USER/$IMAGE:$BUILD_NUMBER
