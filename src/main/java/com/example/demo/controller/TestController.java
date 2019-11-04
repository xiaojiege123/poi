package com.example.demo.controller;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import com.example.demo.vo.*;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.crypto.Data;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/test")
public class TestController {


    @RequestMapping("/downloadExcel")
    public void downloadExcel(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String fileUrl = "https://java-assess.oss-cn-beijing.aliyuncs.com/temp/image/2019/11/1/1190124196338147330.jpeg?x-oss-process=image/resize,w_600/watermark,size_28,text_5YyX57qs,color_FFFFFF,t_100,g_nw,x_30,y_30/watermark,size_34,text_MzAuNjcxMDMy,color_FFFFFF,t_100,g_nw,x_30,y_65/watermark,size_28,text_5Lic57uP,color_FFFFFF,t_100,g_nw,x_30,y_110/watermark,size_34,text_MTA0LjA2Mzk1Nw==,color_FFFFFF,t_100,g_nw,x_30,y_145/watermark,size_28,text_MjAxOS4xMS4wMQ==,color_FFFFFF,t_100,g_sw,x_30,y_10/watermark,size_28,text_5oiQ6YO95biC6Z2S576K5Yy66Z2S6b6Z5be3Mjct6ZmEMjUt6ZmEMjblj7c=,color_FFFFFF,t_100,g_sw,x_30,y_55";
        File file = getFileFromNetWork(fileUrl);

// 告诉浏览器用什么软件可以打开此文件
        response.setHeader("content-Type", "application/vnd.ms-excel");
// 下载文件的默认名称
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String time = simpleDateFormat.format(new Date());
        response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode("危险源导出表"+time, "UTF-8") + ".xls");
//编码
        response.setCharacterEncoding("UTF-8");
        ArrayList<DangerExportVo> dangerExportVos = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            DangerExportVo dangerExportVo = new DangerExportVo();
            dangerExportVo.setCreateTime(new Date());
            dangerExportVo.setEnterpriseName("企业1");
            dangerExportVo.setDangerStatus(1);
            dangerExportVo.setDangerLevel(2);

            dangerExportVo.setImg(file.getAbsolutePath());
            dangerExportVos.add(dangerExportVo);
        }
        Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams(), DangerExportVo.class, dangerExportVos);
        workbook.write(response.getOutputStream());


    }

    @RequestMapping(value = "/import")
    public void importExcel(MultipartHttpServletRequest multiReq){
        MultipartFile file = multiReq.getFile("file");
        //获取文件流
        InputStream inputStream = null;
        try {
            inputStream = file.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<HiddenDangerImportVo> enterpriseImportVos = new ArrayList<>();
        try {
            ImportParams params = new ImportParams();
            params.setKeyIndex(1);
            enterpriseImportVos = ExcelImportUtil.importExcel(inputStream, HiddenDangerImportVo.class, params);
        } catch (Exception e) {
            e.printStackTrace();
        }
        File file1 = new File(enterpriseImportVos.get(0).getImg());
        System.out.println(enterpriseImportVos.size());
    }

    @RequestMapping(value = "/import2")
    public void importExcel2(MultipartHttpServletRequest multiReq){
        MultipartFile file = multiReq.getFile("file");
        //获取文件流
        InputStream inputStream = null;
        try {
            inputStream = file.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<DangerImportVo> enterpriseImportVos = new ArrayList<>();
        try {
            ImportParams params = new ImportParams();
            params.setKeyIndex(1);
            enterpriseImportVos = ExcelImportUtil.importExcel(inputStream, DangerImportVo.class, params);
        } catch (Exception e) {
            e.printStackTrace();
        }
        File file1 = new File(enterpriseImportVos.get(0).getImg());
        System.out.println(enterpriseImportVos.size());
    }


    /**
     * @params [fileUrl]
     * @Description: 从网络获取图片
     * @return: java.io.File
     * @Author: zhoujie
     * @Date: 2019/11/1 - 12:10
     */
    public File getFileFromNetWork(String fileUrl) throws IOException {
        String suffix;
        int indexOf = fileUrl.lastIndexOf("?x-oss-process=image");
        // 不具有水印
        if (indexOf == -1) {
            suffix = fileUrl.substring(fileUrl.lastIndexOf("."));
        } else {
            suffix = fileUrl.substring(fileUrl.lastIndexOf("."),indexOf);
        }

        OutputStream outputStream = null;
        InputStream iputstream = null;
        try {
            URL url = new URL(fileUrl);
            HttpURLConnection uc = (HttpURLConnection) url.openConnection();
            uc.setDoInput(true);//设置是否要从 URL 连接读取数据,默认为true
            uc.connect();

            //创建临时图片
            File tmpFile = File.createTempFile("temp", suffix);
            tmpFile.deleteOnExit();
            outputStream = new FileOutputStream(tmpFile);

            iputstream = uc.getInputStream();
            //写入图片数据
            byte[] buff = new byte[1024];
            int length = 0;
            while ((length = iputstream.read(buff)) != -1) {
                outputStream.write(buff, 0, length);
            }
            return tmpFile;
        } catch (IOException e) {
            e.printStackTrace();
            throw new IOException(e);
        } finally {
            iputstream.close();
            outputStream.close();
        }
    }
}
