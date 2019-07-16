#!/bin/bash

server_dir=$(dirname $0)/..

for file in $server_dir/lib/*.jar;
do
  CLASSPATH=$CLASSPATH:$file
done

echo $server_dir;
echo $CLASSPATH;

serverpath=`pwd`

if [ -z $SERVER_OPTS ]; then
  SERVER_OPTS=-Xmx1G
fi

java $SERVER_OPTS -cp $CLASSPATH grpc.search.oauth.server.s.ServerApp -conf $server_dir/conf $@ &

echo $! > $server_dir/grpc_currentpid
