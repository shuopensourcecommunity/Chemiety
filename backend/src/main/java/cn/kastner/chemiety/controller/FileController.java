package cn.kastner.chemiety.controller;

import cn.kastner.chemiety.repository.FileRepository;
import cn.kastner.chemiety.util.NetResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;

@RestController
public class FileController {

    @Autowired
    FileRepository fileRepository;

    @RequestMapping(value = "/admin/upload")
    public NetResult upload2(@RequestParam MultipartFile file, @RequestParam String type, HttpSession session) {
        NetResult result = new NetResult();// 构建源文件
        String path = session.getServletContext().getRealPath("/" + type) + "/";
        System.out.println("开始执行文件上传");
        System.out.println(file.getOriginalFilename());
        String originalFilename = file.getOriginalFilename();
        String extension = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);// 扩展名
        System.out.println(extension);
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
                cn.kastner.chemiety.domain.File file1 = fileRepository.findByName(originalFilename);
                if (file1 != null) {

                }
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
