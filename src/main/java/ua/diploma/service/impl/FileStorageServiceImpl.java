package ua.diploma.service.impl;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ua.diploma.service.FileStorageService;

import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class FileStorageServiceImpl implements FileStorageService {

    private final String PATH = System.getProperty("user.dir");
    private final String SEPARATOR = System.getProperty("file.separator");

    private final Path fileStorageLocation;

    public FileStorageServiceImpl() {
        String uploadDir = PATH + SEPARATOR + "uploads";
        this.fileStorageLocation = Paths.get(uploadDir).toAbsolutePath().normalize();
        try {
            Files.createDirectories(this.fileStorageLocation);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public String storeFile(MultipartFile file, String fileId) {
//        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        String fileName = fileId;
        Path targetLocation = null;

        try {
            targetLocation = this.fileStorageLocation.resolve(fileName);
            Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return fileName;
    }

    @Override
    public Resource loadFile(String fileName) {
        try {
            Path filePath = this.fileStorageLocation.resolve(fileName);
            Resource resource = new UrlResource(filePath.toUri());

            if (resource.exists()) {
                return resource;
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
