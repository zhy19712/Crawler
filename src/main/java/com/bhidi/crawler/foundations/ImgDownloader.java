package com.bhidi.crawler.foundations;

import com.bhidi.crawler.beans.Show;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
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

        if (statusCode == HttpStatus.SC_OK) {

            filename = url.split("/"); // 取图片链接的最后一段为文件名

            String nameSuffix=url.substring(url.lastIndexOf(".")); //获取扩展名

            File storeFile = new File(path + filename[filename.length-1]
                    + ".tmp"); // 先存为临时文件，等全部下完再改回原来的文件名

            FileOutputStream outputStream = new FileOutputStream(storeFile);
            InputStream inputStream = response.getEntity().getContent();
            byte b[] = new byte[32*1024];
            int j = 0;

            while( (j = inputStream.read(b)) != -1 )
            {
                outputStream.write(b,0,j);
            }

            if (outputStream != null)
            {
                outputStream.close();
            }

            storeFile.renameTo(new File(path + title + nameSuffix));
            b = null;

            if( bbb = true ){
                list1.add(title + nameSuffix );
                System.out.println(list1.size());
                System.out.println("图片-" + title + nameSuffix + "-下载完成！");
            }

        } else {
            System.out.println("Something wrong and the code is " + statusCode);
            System.out.println("And the wrong page is " + url);
        }
        if( bbb = true ){
            List<String> list2 = new ArrayList<String>();
            list2.add((String)list1.get(list1.size()-5));
            list2.add((String)list1.get(list1.size()-4));
            list2.add((String)list1.get(list1.size()-3));
            list2.add((String)list1.get(list1.size()-2));
            list2.add((String)list1.get(list1.size()-1));
            Show.setList(list2);
            Show.setNum(list1.size());
        }





        response = null;
        getMethod.releaseConnection();
    }
}
