#!/bin/bash
server_dir=$(dirname $0)/..

proc=`cat $server_dir/grpc_currentpid`
echo "killing GrpcServer"
kill -9 $proc

cat /dev/null > $server_dir/grpc_currentpid