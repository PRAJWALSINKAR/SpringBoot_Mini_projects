package prajwal.in.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import prajwal.in.enity.Post;
import prajwal.in.enity.User;
import prajwal.in.repo.PostRepository;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepo;

    
    @Override
    public List<Post> getAllPosts() {
        return postRepo.findAll();
    }

    
    @Override
    public void savePost(Post post) {
        postRepo.save(post);
    }

    @Override
    public List<Post> getPostsByUser(User user) {
        return postRepo.findByUser(user);
    }

    @Override
    public void deletePostById(Integer id) {
        postRepo.deleteById(id);
    }

    @Override
    public Post getPostById(Integer id) {
        return postRepo.findById(id).orElse(null);
    }
}
