package prajwal.in.service;

import java.util.List;

import prajwal.in.enity.Post;
import prajwal.in.enity.User;

public interface PostService {
    void savePost(Post post);
    List<Post> getPostsByUser(User user);
    void deletePostById(Integer id);
    Post getPostById(Integer id);
    List<Post> getAllPosts();

}
