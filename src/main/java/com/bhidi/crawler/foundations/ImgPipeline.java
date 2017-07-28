package com.bhidi.crawler.foundations;

import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;
import us.codecraft.webmagic.utils.FilePersistentBase;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zhy19712 on 20/07/2017.
 */
public class ImgPipeline extends FilePersistentBase implements Pipeline {
    public ImgPipeline() {}

    public ImgPipeline(String path) {
        setPath(path);
    }


    @Override
    public void process(ResultItems resultItems, Task task) {
        String fileStorePath = this.path;
        List<String> titleList = resultItems.get("title");
        List<String> srcList = resultItems.get("src");

        List listBackSrc = new ArrayList();
        for (int i = 0; i < srcList.size();i++){
            String s = String.valueOf(srcList.get(i));
            //在这里没有去处理src是空串的情况。
            if(s.startsWith("http")){
                listBackSrc.add(s);
            }
            else if(s.startsWith("//")){
                listBackSrc.add("http://www.creei.cn"+s.replace("//", "/"));
            }
            else if(s.startsWith("/")){
                listBackSrc.add("http://www.creei.cn"+s);
            }else {
                listBackSrc.add("http://www.creei.cn/"+s);
            }

        }


        List<Map> imgList = new ArrayList();
        for(int i = 0;i < listBackSrc.size();i++){
            Map<String,Object> map = new HashMap<String, Object>();
            String src =  String.valueOf(listBackSrc.get(i));
            String title =  String.valueOf(titleList.get(i));
            if(!src.endsWith("http://www.creei.cn/")  &&  title != null && !"".equals(title) && !"null".equals(title)){
                map.put("src",src);
                map.put("title",title);
                imgList.add(map);
            }

        }

        for(int i = 0; i<imgList.size();i++){
            String src = (String)imgList.get(i).get("src");
            String[] srcFirst = src.split("//");
            String[] srcSecond = srcFirst[1].split("/");
            String path = "";
            for(int j = 0;j <srcSecond.length; j++){
                if(j < srcSecond.length-1 ){
                    path  += srcSecond[j]+"/";
                }
            }

            String dirPath = fileStorePath+path;
            File dir = new File(dirPath);
            if(!dir.exists() && !dir.isDirectory())
            {

                dir.mkdirs();
            }

            ImgDownloader d = new ImgDownloader();

            try {
                d.download(imgList.get(i).get("src").toString(), imgList.get(i).get("title").toString(), dirPath);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
