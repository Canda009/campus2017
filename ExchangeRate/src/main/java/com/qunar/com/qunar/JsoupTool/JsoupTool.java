package com.qunar.com.qunar.JsoupTool;

import com.qunar.ex_rate.commom.ContentBean;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gcy0904 on 2017/1/20.
 */
public class JsoupTool {
    public static List<ContentBean> HtmlParse(String html){
        //�����洢�ռ�
        List<ContentBean> list = new ArrayList<ContentBean>();
        //����html_String
        Document document = Jsoup.parse(html);
        //��ö�Ӧ�Ľڵ�
        Elements elements = document.select(".table-responsive tr");

        //��������
        if(elements.size()>0){
            for (int i = 1; i < elements.size(); i++) {
                //����м���ı�
                Document ele_document = Jsoup.parse(elements.get(i).toString());
                String body_text = ele_document.body().text().toString();
                //System.out.print(body_text);
                //�и�
                String[] split_string = body_text.split(" ");

                //��װ
                String date = split_string[0];
                float price = new Float(split_string[1]);

                ContentBean contentBean = new ContentBean(date, price);
                list.add(contentBean);
            }
        }
        return list;
    }
}
