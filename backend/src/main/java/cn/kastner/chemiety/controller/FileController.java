package cn.kastner.chemiety.controller;

import cn.kastner.chemiety.util.NetResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;

@RestController
public class FileController {

    @RequestMapping(value = "/admin/upload")
    public @ResponseBody
    NetResult upload2(@RequestParam MultipartFile file, @RequestParam String type, HttpServletRequest request) {
        NetResult result = new NetResult();// 构建源文件
        String path = request.getSession().getServletContext().getRealPath("/" + type) + "/";
        System.out.println("开始执行文件上传");
        System.out.println(file.getOriginalFilename());
        String str1 = file.getOriginalFilename();
        String kuozhanname = str1.substring(str1.lastIndexOf(".") + 1);// 扩展名
        System.out.println(kuozhanname);
        if (!file.isEmpty()) {
            try {
                // 目标文件不存在就创建
                File tarfile = new File(path);
                if (!tarfile.exists()) {
                    tarfile.mkdirs();
                }
                System.out.println("fileName = " + file.getOriginalFilename());
                System.out.println(path);
                try (FileOutputStream out = new FileOutputStream(path + file.getOriginalFilename())) {
                    System.out.println(path + file.getOriginalFilename());
                    // 目标文件创建输出流
                    out.write(file.getBytes());
                    out.flush();
                    out.close();
                }
                String realpath = "/" + type + file.getOriginalFilename();
                result.status = 0;
                result.result = realpath;
            } catch (Exception e) {
                e.printStackTrace();
                result.status = -1;
                result.result = "上传出错";
            }
        } else {
            System.out.println("文件为空");
            result.status = -1;
            result.result = "文件为空";
        }
        return result;
    }
}
