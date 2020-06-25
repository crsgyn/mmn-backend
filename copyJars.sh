#!/usr/bin/env bash

DEST="staging"
echo "Copy all target/*.jar => ${DEST} folder"
for folder in $(find . -type d -name "target") ; do
    for file in $(find $folder -name "*.jar" -exec basename {} ";") ; do
        destWithFile="${folder}/${file} ${DEST}/${file}"
        echo ${destWithFile}
        cp ${destWithFile}
    done
done
