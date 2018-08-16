#!/bin/bash

WORD=$(ps aufx | grep "python" | awk {'print  $10'} > time.txt &&  rev time.txt | cut -c 4- | rev)
VARIABLE=${WORD:0:1};
NVARIABLE=${WORD:0:5};
echo $VARIABLE;
echo $NVARIABLE;
echo $WORD;
