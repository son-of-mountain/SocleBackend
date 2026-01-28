#!/bin/bash

DUMP_FILE="/container-entrypoint-initdb.d/data.dmp"

if [ -f "$DUMP_FILE" ]; then
    echo "Found $DUMP_FILE, starting import as SYSTEM..."
    
    imp system/oracle file=$DUMP_FILE full=y ignore=y buffer=10000000 feedback=1000
    
    echo "Import finished."
else
    echo "No data.dmp file found. Skipping import."
fi
