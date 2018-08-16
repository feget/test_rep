#!/bin/bash
for res in $(cat users.txt | awk -F/ {'print $3'});
do for ver in 4.4 5.1 5.2 5.3 5.4 5.5 5.6 7.0 7.1;
        do /usr/bin/piniset --replace="log_errors:Off" --version=$ver --user=$res ;
        done;
echo "$res done...";
done
