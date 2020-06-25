#!/usr/bin/env bash
ps -eaf | grep -i java | grep -v grep | awk '{print $10,$2}'
