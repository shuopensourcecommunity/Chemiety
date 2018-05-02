package cn.kastner.chemiety.repository;

import cn.kastner.chemiety.domain.File;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRepository extends JpaRepository<File, Long> {
    File findByName(String name);
    File findByNameAndType(String name, File.Type type);
}
