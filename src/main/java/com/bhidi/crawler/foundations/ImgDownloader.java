package com.bhidi.crawler.foundations;

import com.bhidi.crawler.beans.Show;
import com.bhidi.crawler.controllers.HelloController;
import com.bhidi.crawler.utils.DBUtils;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by zhy19712 on 20/07/2017.
 */
public class ImgDownloader {
    public static List list1 = new ArrayList();
    public static boolean bbb = true;

    public void download(String url, String title, String path) throws IOException {

        String[] filename;

        HttpClient httpClient = HttpClients.createDefault();
        HttpGet getMethod = new HttpGet(url);
        HttpResponse response = httpClient.execute(getMethod);
        //logger.info(response.getStatusLine());
        int statusCode = response.getStatusLine().getStatusCode();

        int sid = HelloController.idlist.get( HelloController.idlist.size()-1);
        System.out.print("当前执行的任务的id:"+sid);

        if (statusCode == HttpStatus.SC_OK) {

            filename = url.split("/"); // 取图片链接的最后一段为文件名

            String nameSuffix = url.substring(url.lastIndexOf(".")); //获取扩展名

            File storeFile = new File(path + filename[filename.length - 1]
                    + ".tmp"); // 先存为临时文件，等全部下完再改回原来的文件名

            FileOutputStream outputStream = new FileOutputStream(storeFile);
            InputStream inputStream = response.getEntity().getContent();
            byte b[] = new byte[32 * 1024];
            int j = 0;

            while ((j = inputStream.read(b)) != -1) {
                outputStream.write(b, 0, j);
            }

            if (outputStream != null) {
                outputStream.close();
            }

            storeFile.renameTo(new File(path + title + nameSuffix));
            b = null;
            //求出当前时间
            Date nowDate = new Date();
            SimpleDateFormat simple = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String time = simple.format(nowDate);

            if (bbb) {
                list1.add(title + ":" + filename[filename.length - 1] + "--下载完成!");
                System.out.println(list1.size());
                System.out.println("图片-" + title + nameSuffix + "--下载完成!");
                DBUtils.Insert("insert into CONTENT (ID_TASK,TITLE,PATH,TYPE,CREATED_AT) values('"+sid+"','"+title+"','"+path+"','"+nameSuffix+"','"+time+"')");
            }

        } else {
            list1.add(title + ":" + path + "--链接已失效！");
            System.out.println("Something wrong and the code is " + statusCode);
            System.out.println("And the wrong page is " + url);
        }
        if (!bbb) {
            list1.clear();
        }
        if (bbb) {
            List<String> list2 = new ArrayList<String>();
            list2.add((String) list1.get(list1.size() - 5));
            list2.add((String) list1.get(list1.size() - 4));
            list2.add((String) list1.get(list1.size() - 3));
            list2.add((String) list1.get(list1.size() - 2));
            list2.add((String) list1.get(list1.size() - 1));
            Show.setList(list2);
            Show.setNum(list1.size());
        }
        if (!bbb) {
            Show.setList(null);
            Show.setNum(list1.size());
        }

        response = null;
        getMethod.releaseConnection();
    }
}
