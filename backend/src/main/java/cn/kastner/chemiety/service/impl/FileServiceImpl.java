package cn.kastner.chemiety.service.impl;

import cn.kastner.chemiety.exception.FileException;
import cn.kastner.chemiety.service.FileService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.util.UUID;

@Service
public class FileServiceImpl implements FileService {

    @Value("${upload.path}")
    private String directory;

    @Override
    public String uploadFile(MultipartFile file, HttpServletRequest request) throws FileException, IOException {
        String fileId = UUID.randomUUID().toString();
        String originalFilename = file.getOriginalFilename();
        String extension = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);
        if (file.isEmpty()) {
            throw new FileException(FileException.EMPTY_FILE);
        }
        String tempDirectory = request.getSession().getServletContext().getRealPath("/upload") + File.separator + fileId + File.separator;
        String tempPath = tempDirectory + originalFilename;
        File tempFile = new File(tempDirectory);
        if (!tempFile.exists()) {
            tempFile.mkdirs();
        }
        try (OutputStream os = new FileOutputStream(tempPath)) {
            os.write(file.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return tempPath;
    }

    @Override
    public String saveFile(String tempPath, String relativeDirectory) {
        File tempFile = new File(tempPath);
        String originalFileName = tempFile.getName();
        String absoluteDirectory = directory + relativeDirectory;
        File fileDirectory = new File(absoluteDirectory);
        if (!fileDirectory.exists()) {
            fileDirectory.mkdirs();
        }
        String absolutePath = absoluteDirectory + originalFileName;
        File targetFile = new File(absolutePath);
        try {
            Files.copy(tempFile.toPath(), targetFile.toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
        tempFile.delete();
        return absolutePath;
    }
}
