import urllib
from bs4 import BeautifulSoup
import urllib2
import re
import xlwt

#post�����������󣬻�ȡ��Ԫ

page =1

filename='D:/BOC.txt'
f=open(filename,'w+')

cur_row = 0
cur_col = 0

workbook= xlwt.Workbook()

workSheet= workbook.add_sheet('sheet two')

money_corresponding={'1316':'��Ԫ','1315':'�۱�', '1326':'ŷԪ'}

money_type = ['1316' , '1315','1326']
money_type_len = 3

for money_type_index in range(money_type_len) :
    
    print money_type[money_type_index]
    
    
    # write head
    workSheet.write(cur_row,cur_col,money_corresponding[money_type[money_type_index]].decode('gb2312'))
    cur_row = cur_row +1
    
    
    for page in range(40):
        
        print page
    
        url = 'http://srh.bankofchina.com/search/whpj/search.jsp'   # ע���ύpost����
        header = {'User-Agent' : 'Mozilla/4.0 (compatible; MSIE 5.5; Windows NT)'}
    
        postdata = {'erectDate': '2017-03-12', 'nothing' : '2017-03-01' ,'pjname': money_type[money_type_index], 'page': str(page+1)}  # ��ʼʱ�䣬 ��ֹʱ�䣬�������ͣ���ǰҳ��
        #�Բ�������
        postdatadecode = urllib.urlencode(postdata)
    
        try:
            request = urllib2.Request(url, headers=header , data=postdatadecode)
    
            response = urllib2.urlopen(request)
    
            content = response.read().decode('utf-8')  #����
    
            #print content
    
            soup = BeautifulSoup(content,'html.parser',from_encoding='utf-8') # ����ҳ���ݹ���BeautifulSoup����
    
    
            table_td = soup.find_all('tr')
    
            lens = len(table_td)
            
            # ���Excel�ļ�
            
            
           # workSheet.write(0, 0, '����'.decode('gb2312'))
           # workSheet.write(0, 1, 2)
           
            
            for index in range(lens-1):
    
                if index>=2 :
                    temp_index = 0
                   
                    for child in table_td[index].stripped_strings:
                        
                        if temp_index ==7 and money_type_index == money_type_len -1:
                            workSheet.write(cur_row-1,cur_col+1,child)                        
                        if temp_index ==6:
                            workSheet.write(cur_row,cur_col,child)
                            cur_row = cur_row+1
                        
  
                        temp_index = temp_index +1 
    
                    ++index
                    
                else:
                    ++index
            
        except urllib2.URLError, e:
            if hasattr(e, "code"):
                print e.code
            if hasattr(e, "reason"):
                print e.reason   
    
    # new 
    cur_col = cur_col +2
    cur_row = 0

    
workbook.save('D:\\Excel_Workbook.xls') 