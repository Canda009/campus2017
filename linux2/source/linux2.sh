#!/usr/bin/expect -f
#˼·����̨ϵͳ֮����ļ����ݣ����ǿ������Ϊc/sϵͳ����һ̨����������������һ̨������һ���ͻ��ˣ��������ǾͿ��Ը���ʵ����������ļ��Ĵ���

#1.ssh����
#eg: ssh -l GuoChongyuan -p 8080 198.0.0.1
#ssh -l username   -p port   hostname or IP
ssh -l GuoChongyuan -p 8080 198.0.0.1

#�����ļ�
#eg:scp -P 8080 a.txt GuoChongyuan@198.0.0.1 :/tmp
#scp -P port local_file_path user_name@host_name or ip : remot_file_path
scp _P 8989 dir1 remote@-test.dev.cn1 :/tmp #����Ǵ��Լ��Ļ������͵Ļ�

#�����ļ�
#scp -P 22 username@hostname or ip:remotefilepath or ip:remotefilepath localfilepath
#eg:scp -P 22 kevin_u@192.168.1.1:/tmp/aa.txt ./
scp -P 8080 remote@-test.dev.cn1:/dir1 ./tmp #�����Ҫ����˸��Լ����ļ��Ļ�
