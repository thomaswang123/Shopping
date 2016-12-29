package com.starlight.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.*;

/**
 * Created by james.jiang on 2016/12/29.
 */
@Controller
public class ImgController {


    @RequestMapping(value = "/upload.do", produces = "text/html;charset=UTF-8")

    public String upload(
            @RequestParam(value = "file",required = false)MultipartFile multipartFile,
            HttpSession httpSession, HttpServletRequest request)throws IOException{


//       判断文件大小
        if(multipartFile.getSize()>1024*1024*2){
            System.out.println("文件不能大于2M");
        }else if(multipartFile.getSize()<=0){
            System.out.println("文件不能为空");
        }else {
//            获取图片名称
           String fileName=multipartFile.getOriginalFilename();
//            匹配是否是图片
            String []suffixName=new String[]{"gif","jpg","png"};
            String fileSuffixName=fileName.substring(fileName.lastIndexOf(".")+1);

            System.out.println("f:"+fileSuffixName);

            if (suffixName[0].equals(fileSuffixName) ||
                    suffixName[1].equals(fileSuffixName) ||
                    suffixName[2].equals(fileSuffixName)){

                System.out.println("匹配！");

//              获取工程路径
                String url=this.getClass().getClassLoader().getResource("/").getPath();
//              切割
                String []strs=url.split("target");
                System.out.println("--:"+strs[0]+"src/main/webapp/");
//              创建File
                String newUrl=strs[0]+"src/main/webapp/goodImages/";

                String path3=newUrl.substring(newUrl.indexOf("/")+1);
                System.out.println("path3"+path3);
//                String str2=newUrl.replace("/","\\\\");
//                String str3=newUrl.replaceAll("/","\\\\");
//                System.out.println(str2+"--"+str3);

                String path4=path3+multipartFile.getOriginalFilename();
                File file=new File(path4);
//              判断是否存在该目录，如果没有就创建
                if(!file.exists()){
                    file.mkdir();
                }

                System.out.println(multipartFile.getContentType());
//               创建输入流输入文件
                InputStream inputStream=multipartFile.getInputStream();

//              创建缓冲区

                byte [] bytes=new byte[inputStream.available()];
//                读取文件到缓冲区

                System.out.println("长度："+bytes.length);

               FileOutputStream out=new FileOutputStream(file);
                int i=0;
//                读取输出
                while ((i=inputStream.read(bytes))!=-1){
                    out.write(bytes,0,bytes.length);
                    out.flush();
                }


//              存储到数据库
                request.getParameter("");

                out.close();
                inputStream.close();
            }else{
                System.out.println("不是图片文件");
            }


        }

        return "redirect:admin.jsp";
    }

}
