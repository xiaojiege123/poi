package com.example.demo.vo;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/test")
public class TestController {


    @RequestMapping("/downloadExcel")
    public void downloadExcel(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String fileUrl = "https://java-assess.oss-cn-beijing.aliyuncs.com/temp/image/2019/10/29/1189025095913037826.jpg";
        URL url = new URL(fileUrl);
        HttpURLConnection uc = (HttpURLConnection) url.openConnection();
        uc.setDoInput(true);//设置是否要从 URL 连接读取数据,默认为true
        uc.connect();
        File file = new File("D://a.jpg");
        InputStream iputstream = uc.getInputStream();
        OutputStream outputStream= new FileOutputStream(file);
        byte[] buff  = new byte[1024];
        int length = 0 ;
        while((length = iputstream.read(buff))!=-1){
            outputStream.write(buff, 0, length);
        }
        iputstream.close();
        outputStream.close();


// 告诉浏览器用什么软件可以打开此文件
        response.setHeader("content-Type", "application/vnd.ms-excel");
// 下载文件的默认名称
        response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode("用户数据表", "UTF-8") + ".xls");
//编码
        response.setCharacterEncoding("UTF-8");
        ArrayList<UserVo> userVos = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            UserVo userVo = new UserVo();

            ChildVo childVo = new ChildVo();
            ChildVo1 childVo1 = new ChildVo1();
            ChildVo1 childVo2 = new ChildVo1();

            childVo.setName("11");
            childVo.setSex("222");
            childVo1.setName("333");
            childVo1.setSex("4414");
            childVo2.setName("555");
            childVo2.setSex("666");
            ArrayList<ChildVo> childVo1s1 = new ArrayList<>();
            childVo1s1.add(childVo);
            userVo.setChildVo(childVo1s1);
            ArrayList<ChildVo1> childVo1s = new ArrayList<>();
            childVo1s.add(childVo1);
            childVo1s.add(childVo2);
            userVo.setChildVo1s(childVo1s);

            userVo.setCompanyLogo(file.getAbsolutePath());

            userVos.add(userVo);
        }

        Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams(), UserVo.class, userVos);
        workbook.write(response.getOutputStream());

    }
}
