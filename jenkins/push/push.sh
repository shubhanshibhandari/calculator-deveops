#!/bin/bash

echo "********************"
echo "** Pushing image ***"
echo "********************"

IMAGE="spe-mini-project"

echo "** Logging in ***"
docker login -u shubhanshi -p $PASS
echo "*** Tagging image ***"
docker tag $IMAGE:$BUILD_TAG shubhanshi/$IMAGE:$BUILD_TAG
echo "*** Pushing image ***"
docker push shubhanshi/$IMAGE:$BUILD_TAG
