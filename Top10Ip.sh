#��linux�����½���tomcat logĿ¼
#ִ����������ɣ�
cat *_access_*.txt | awk '{print $1}' | sort | uniq -c | sort -r | head -n 10