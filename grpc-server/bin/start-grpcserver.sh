#!/bin/bash

server_dir=$(dirname $0)/..

for file in $server_dir/lib/*.jar;
do
  CLASSPATH=$CLASSPATH:$file
done

echo $server_dir;

cd ../
serverpath=`pwd`
cd bin

if [ -z $SERVER_OPTS ]; then
  SERVER_OPTS=-Xmx1G
fi


java  $SERVER_OPTS -DLOG_PATH=$serverpath -DSYS_PROP=file:$serverpath -cp $CLASSPATH grpc.search.oauth.server.s.ServerApp $@&

echo $! > $server_dir/grpc_currentpid

