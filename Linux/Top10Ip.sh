#���ͳ��������־�ļ���tomcat��access log���У��г����ʴ�������10��IP���Լ���Ӧ�Ĵ���
cat access_log | awk ��{print $1}�� | uniq -c | sort -rn | head -10