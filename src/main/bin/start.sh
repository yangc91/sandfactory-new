#!/bin/sh

BASE_DIR=$(dirname $0)/..

JAVA_OPT_1="-XX:+UseConcMarkSweepGC -XX:+UseCMSCompactAtFullCollection -XX:CMSInitiatingOccupancyFraction=70 -XX:+CMSParallelRemarkEnabled -XX:SoftRefLRUPolicyMSPerMB=0 -XX:+CMSClassUnloadingEnabled -XX:SurvivorRatio=8 -XX:+DisableExplicitGC"
JAVA_OPT_2="-XX:-OmitStackTraceInFastThrow"
JAVA_OPT_3="-Djava.ext.dirs=${BASE_DIR}/lib"
JAVA_OPT_4="-classpath ${BASE_DIR}/conf"

JAVA="java"

JAVA_OPTS="${JAVA_OPT_1} ${JAVA_OPT_2} ${JAVA_OPT_3} ${JAVA_OPT_4}"

$JAVA $JAVA_OPTS com.yc.sandfactory.Starter &