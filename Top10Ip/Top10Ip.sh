 
 #�Ե����ļ��Ĳ���
 cat localhost_access_log.2017-03-14.txt | awk '{print $1}' | sort | uniq -c | sort -nr | head -10 | awk '{printf("Ip��ַ:%s\t\t���ʴ���:%s\n", $2, $1)}'
 
 
 #��һ��Ŀ¼�Ĳ���
 find /usr/tomcat/logs -name "*access_log*" -exec cat {} \; | awk '{print $1}' | sort | uniq -c | sort -nr | head -10 | awk '{printf("Ip��ַ:%s\t\t���ʴ���:%s\n", $2, $1)}' 