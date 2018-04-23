package cn.kastner.chemiety.repository;

import cn.kastner.chemiety.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, String> {
}
