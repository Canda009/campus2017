package com.qunar.common;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by gcy0904 on 2017/1/20.
 */
public class ImportClassCount {
    String dirName;//�ļ�·��
    HashMap<String, Integer> importClassRecords;    //��¼Map
    public ImportClassCount(){}

    public ImportClassCount(String dir){
        this.dirName = dir;
        importClassRecords = new HashMap<String, Integer>();
        this.statisticsClazz(new File(this.dirName));
    }

    private int get(String clazzName){
        Integer value = importClassRecords.get(clazzName);
        if(value==null) return 0;
        return value;
    }
    private void processFile(File file){
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return;
        }
        String line = null;
        try {
            while((line = reader.readLine()) != null){
                line = line.trim();
                if(line.startsWith("public")||line.startsWith("class")){
                    break;
                }
                if(line.startsWith("import")){
                    String className = line.substring(6, line.length()-1).trim();
                    Integer value = importClassRecords.get(className);
                    if(value==null){
                        importClassRecords.put(className, 1);
                    }else{
                        importClassRecords.put(className, value+1);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void statisticsClazz(File file){
        if(!file.isDirectory()){
            //���ļ��ͽ���ͳ��
            processFile(file);
        }else{
            //�ļ��н��е���
            File [] files = file.listFiles();
            for(File tmpFile: files){
                statisticsClazz(tmpFile);
            }
        }

    }

    //��ô�������һ����
    public ImportClassBean getMostImportClazzName(){
        int max = Integer.MIN_VALUE;
        String clazzName = null;
        for(Map.Entry item: this.importClassRecords.entrySet()){
            String key = (String) item.getKey();
            int value = (Integer)item.getValue();
            if(value>max){
                max = value;
                clazzName = key;
            }
        }
        return new ImportClassBean(clazzName,max);
    }

    //��ô��������10����
    public List<ImportClassBean> getTopImportClassName(int num){
        List<ImportClassBean> list = new ArrayList<ImportClassBean>();
        for (int i = 0; i < num && i < this.importClassRecords.size(); i++) {
            ImportClassBean mostImportClazzName = this.getMostImportClazzName();
            list.add(mostImportClazzName);
            this.importClassRecords.remove(mostImportClazzName.getClassName());
        }
        return list;
    }

    public void getTopImportClassName2(){
        System.out.print(this.importClassRecords.toString());
        ImportClassBean mostImportClazzName = this.getMostImportClazzName();
        this.importClassRecords.remove(mostImportClazzName.getClassName());
        System.out.print(this.importClassRecords.toString());

    }
}
