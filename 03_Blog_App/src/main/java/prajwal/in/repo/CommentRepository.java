package prajwal.in.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import prajwal.in.enity.Comment;
import prajwal.in.enity.Post;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
    List<Comment> findByPost(Post post); // fetch all comments for one blog post
}
