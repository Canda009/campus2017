#!/bin/bash
# ȡip,ȥ�ؼ�������������ȡǰ10
cat access.log |awk '{print $1}' |sort | uniq -c |sort -k1,1rn|head -10