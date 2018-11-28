package cn.kastner.chemiety.controller;

import cn.kastner.chemiety.repository.FileRepository;
import cn.kastner.chemiety.util.NetResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import javax.swing.plaf.UIResource;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/api/v1")
public class FileController {


    private final
    FileRepository fileRepository;

    private final
    NetResult netResult;

    @Autowired
    public FileController(FileRepository fileRepository, NetResult netResult) {
        this.fileRepository = fileRepository;
        this.netResult = netResult;
    }


    @RequestMapping(value = "/admin/uploadEduFile")
    public NetResult upload2(@RequestParam MultipartFile file, @RequestParam int type, HttpSession session) {
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
                cn.kastner.chemiety.domain.File.Type classType = null;
                if (0 == type) {
                    classType = cn.kastner.chemiety.domain.File.Type.SLIDE;
                } else if (1 == type) {
                    classType = cn.kastner.chemiety.domain.File.Type.DOCUMENT;
                }
                String realpath = "/" + type + "/" + file.getOriginalFilename();
                cn.kastner.chemiety.domain.File file1 = fileRepository.findByNameAndType(originalFilename, classType);
                if (file1 != null) {
                    file1.setDate(new Date());
                } else {
                    file1 = new cn.kastner.chemiety.domain.File();
                    file1.setName(originalFilename);
                    file1.setDate(new Date());
                    file1.setType(classType);
                    file1.setPath(realpath);
                    fileRepository.save(file1);
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

    @RequestMapping(value = "/admin/uploadShowFile")
    public NetResult upload2(@RequestParam MultipartFile file, @RequestParam String author, HttpSession session) {
        NetResult result = new NetResult();// 构建源文件
        String path = session.getServletContext().getRealPath("/" + 2) + "/";
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
                cn.kastner.chemiety.domain.File.Type classType = cn.kastner.chemiety.domain.File.Type.SHOW;
                String realpath = "/" + 2 + "/" + file.getOriginalFilename();
                cn.kastner.chemiety.domain.File file1 = fileRepository.findByNameAndType(originalFilename, classType);
                if (file1 != null) {
                    file1.setDate(new Date());
                } else {
                    file1 = new cn.kastner.chemiety.domain.File();
                    file1.setName(originalFilename);
                    file1.setDate(new Date());
                    file1.setType(classType);
                    file1.setPath(realpath);
                    file1.setAuthor(author);
                    fileRepository.save(file1);
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

    @RequestMapping(value = "/addWebsite")
    public NetResult addWebsite (cn.kastner.chemiety.domain.File file) {
        String name = file.getName();
        String url = file.getUrl();
        if (name != null) {
            if (url != null) {
                file.setType(cn.kastner.chemiety.domain.File.Type.WEBSITE);
                file.setDate(new Date());
                fileRepository.save(file);
                netResult.status = 0;
                netResult.result = "添加成功！";
            } else {
                netResult.status = -1;
                netResult.result = "地址为空！";
            }
        } else {
            netResult.status = -2;
            netResult.result = "名字为空！";
        }
        return netResult;
    }

    @RequestMapping(value = "/getAllFiles")
    public NetResult getAllSlides (@RequestParam String fileType) {
        List<cn.kastner.chemiety.domain.File> files;
        switch (fileType) {
            case "edu":
                files = fileRepository.findByTypeOrType(
                        cn.kastner.chemiety.domain.File.Type.SLIDE,
                        cn.kastner.chemiety.domain.File.Type.DOCUMENT
                );
                break;
            case "show":
                files = fileRepository.findByType(
                        cn.kastner.chemiety.domain.File.Type.SHOW
                );
                break;
            case "website":
                files = fileRepository.findByType(
                        cn.kastner.chemiety.domain.File.Type.WEBSITE
                );
                break;
            default:
                files = null;
        }
        netResult.status = 0;
        netResult.result = files;
        return netResult;
    }

    @RequestMapping(value = "/admin/deleteFile")
    public NetResult deleteFile (@RequestParam Long fileId) {
        cn.kastner.chemiety.domain.File file = fileRepository.findByFileId(fileId);
        if (file == null) {
            netResult.status = -1;
            netResult.result = "文件不存在！";
        } else {
            fileRepository.delete(file);
            netResult.status = 0;
            netResult.result = "删除成功！";
        }
        return netResult;
    }
}
