package com.starlight.controller;

import com.starlight.entity.Goods;
import com.starlight.entity.Repertory;
import com.starlight.service.IGoodsService;
import com.starlight.service.IRepertoryService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by james.jiang on 2016/12/29.
 * 图片上传
 */
@Controller
public class ImgController {

    /**商品业务*/
    @Resource
    private IGoodsService iGoodsService;

    /**库存业务*/
    @Resource
    private IRepertoryService iRepertoryService;

    /**
     * 图片上传到服务器并添加图片信息至数据库
     * @param multipartFile 文件上传对象
     * @param request   请求
     * @return  跳转至admin.jsp
     * @throws IOException  IO异常
     */
    @RequestMapping(value = "/upload.do", produces = "text/html;charset=UTF-8")
    public String upload(@RequestParam(value = "avatar_file",required = false)MultipartFile multipartFile,
             HttpServletRequest request)throws IOException{

//       判断文件大小
        if(multipartFile.getSize()>1024*1024*2){

            System.out.println("文件不能大于2M");

        }else if(multipartFile.getSize()<=0){

            System.out.println("文件不能为空");

        }else {

            System.out.println("判断通过");
//            获取图片名称
            String fileName=multipartFile.getOriginalFilename();

            String []suffixName=new String[]{"gif","jpg","png","jpeg"};
            String fileSuffixName=fileName.substring(fileName.lastIndexOf(".")+1);

            System.out.println("f:"+fileSuffixName);

//            匹配是否是图片
            if (suffixName[0].equals(fileSuffixName) ||
                    suffixName[1].equals(fileSuffixName) ||
                    suffixName[2].equals(fileSuffixName)||
                    suffixName[3].equals(fileSuffixName)){

                System.out.println("匹配！");

//              获取工程路径
                String url=this.getClass().getClassLoader().getResource("/").getPath();
//              切割
                String []strs=url.split("target");
                System.out.println("--:"+strs[0]+"src/main/webapp/");
//              拼接路径
                String newUrl=strs[0]+"src/main/webapp/img/"+multipartFile.getOriginalFilename();

                String path3=newUrl.substring(newUrl.indexOf("/")+1);
                System.out.println("path3"+path3);

//              创建File
                File file=new File(path3);

                System.out.println(multipartFile.getContentType());
//              创建输入流输入文件
                InputStream inputStream=multipartFile.getInputStream();

//              创建缓冲区
                byte [] bytes=new byte[inputStream.available()];
//              读取文件到缓冲区
                System.out.println("长度："+bytes.length);

               FileOutputStream out=new FileOutputStream(file);

//              读取输出
                while ((inputStream.read(bytes))!=-1){
                    out.write(bytes,0,bytes.length);
                    out.flush();
                }

                out.close();
                inputStream.close();

//              填充商品实体
                Goods goods=new Goods();
                goods.setId(Integer.parseInt(request.getParameter("goodsid"))+1);
                goods.setName(request.getParameter("goodsname"));
                goods.setPicture("img/"+multipartFile.getOriginalFilename());
                goods.setPrice(Float.parseFloat(request.getParameter("goodsprivce")));
                goods.setDescribe(request.getParameter("gdsdescribe"));
//              添加商品信息至数据库
                iGoodsService.addGoods(goods);

//              填充库存实体
                Repertory repertory=new Repertory();
                repertory.setId(Integer.parseInt(request.getParameter("goodsid"))+1);
                repertory.setNumber(Integer.parseInt(request.getParameter("goodsnumber")));
//              添加库存信息至数据库
                iRepertoryService.addRepertory(repertory);

            }else{
                System.out.println("不是图片文件");
            }

        }
        return "redirect:admin.jsp";
    }

}
