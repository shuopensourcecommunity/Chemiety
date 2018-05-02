package cn.kastner.chemiety.repository;

import cn.kastner.chemiety.domain.File;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FileRepository extends JpaRepository<File, Long> {
    File findByName(String name);
    File findByNameAndType(String name, File.Type type);
    List<File> findByType(File.Type type);
    List<File> findByTypeOrType(File.Type type1, File.Type type2);
}
