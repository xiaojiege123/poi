package com.example.demo;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import com.example.demo.vo.*;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class PoiTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(PoiTestApplication.class, args);

        File file = new File("E://a.xls");
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            ImportParams importParams = new ImportParams();
            importParams.setKeyIndex(6);
            //List<Object> objects = ExcelImportUtil.importExcel(fileInputStream, UserVo.class, new ImportParams());
            //List<Object> objects = ExcelImportUtil.importExcel(fileInputStream, UserVo1.class, importParams);
            List<Object> objects = ExcelImportUtil.importExcel(fileInputStream, UserVo2.class, importParams);
            System.out.println(objects.size());



            ArrayList<UserVo> userVos = new ArrayList<>();
            for (int i=0;i<3;i++){
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
                userVo.setName(String.valueOf(i));
                userVo.setPhone(String.valueOf(i));

                userVos.add(userVo);
            }


            Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams(),
                    UserVo.class, userVos);


            File savefile = new File("D:/excel/");
            if (!savefile.exists()) {
                savefile.mkdirs();
            }
            FileOutputStream fos = new FileOutputStream("E://b.xls");
            workbook.write(fos);
            fos.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
