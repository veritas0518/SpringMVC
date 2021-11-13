package com.spring.mvc.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.UUID;

/**
 * @ClassName: FileUpAndDownController
 * @Description: 实现文件的上传和下载
 * @Author: TianXing.Xue
 * @Date: 2021/10/7 19:37
 **/

@Controller
public class FileUpAndDownController {

    @RequestMapping("/testDown")
    public ResponseEntity<byte[]> testResponseEntity(HttpSession session) throws Exception {
        //1.获取servletContext对象(servletContext代表着当前的整个工程)
        ServletContext servletContext = session.getServletContext();

        //2.获取服务器中文件的真实路径(要知道文件在服务器的哪个位置)
        String realPath = servletContext.getRealPath("/static/img/1.jpg");
        System.out.println(realPath);

        //3、创建输入流(文件不管上传还是下载都是一个复制的过程)
        InputStream is = new FileInputStream(realPath);

        //4.创建字节数组(is.available()：表示数组的长度，获取当前的输入流所对应的文件的所有字节数)
        byte[] bytes = new byte[is.available()];

        //5.将流读到字节数组中
        is.read(bytes);

        //7.创建HttpServlet对象设置响应头信息(MultiValueMap：这是一个接口，不能实例化，得找它的实现类)
        MultiValueMap<String, String> headers = new HttpHeaders();

        /*8.设置要下载方式以及下载文件的名字
            attachment：以附件的方式来下载文件
            filename：为当前要下载的文件所设置的默认的名字
        */
        headers.add("Content-Disposition", "attachment;filename=1.jpg");

        //9.设置响应状态码(HttpStatus.OK：就是200状态码)
        HttpStatus statusCode = HttpStatus.OK;

        //6.创建ResponseEntity对象
        //bytes：存放了当前要下载的文件中所有的字节(换句话说，这就是响应体)
        ResponseEntity<byte[]> responseEntity = new ResponseEntity<>(bytes, headers, statusCode);

        //10.关闭输入流
        is.close();

        //11.将responseEntity响应到浏览器(responseEntity：可以自定义一个响应报文去响应浏览器)
        return responseEntity;
    }

    //MultipartFile：上传文件所包含的信息以及我们要做的操作都封装好了
    @RequestMapping("/testUp")
    public String testUp(MultipartFile photo, HttpSession session) throws Exception{
        //获取上传的文件的文件名
        String filename = photo.getOriginalFilename();

        //获取上传的文件的后缀名
        String suffixName = filename.substring(filename.lastIndexOf("."));

        //将uuid作为文件名
        String uuid = UUID.randomUUID().toString().replaceAll("-","");

        //将uuid和后缀名拼接后的结果来作为最终的文件名
        filename = uuid+suffixName;

        //通过servletContext获取服务器中photo文件夹的文件目录的路径
        ServletContext servletContext = session.getServletContext();
        String photoPath = servletContext.getRealPath("photo");

        File file = new File(photoPath);

        //判断photoPath所对应路径是否存在
        if (!file.exists()) {
            //若不存在，则创建目录
            file.mkdir();
        }

        //File.separator文件分隔符
        String finalPath = photoPath + File.separator + filename;
        photo.transferTo(new File(finalPath));
        return "success";
    }

}

