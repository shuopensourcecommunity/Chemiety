package cn.kastner.chemiety.repository;

import cn.kastner.chemiety.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
