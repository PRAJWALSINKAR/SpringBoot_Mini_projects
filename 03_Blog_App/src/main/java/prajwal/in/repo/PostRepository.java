package prajwal.in.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import prajwal.in.enity.Post;
import prajwal.in.enity.User;

public interface PostRepository extends JpaRepository<Post, Integer> {
    List<Post> findByUser(User user); // for filtering posts by logged-in user
}
