#!/usr/bin/env bash
echo "Send jars to server"
scp -r ./staging admintrv@trv_back:/home/admintrv/backend-app-prod
