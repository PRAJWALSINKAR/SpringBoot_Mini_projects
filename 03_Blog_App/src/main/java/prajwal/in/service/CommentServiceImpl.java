package prajwal.in.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import prajwal.in.enity.Comment;
import prajwal.in.enity.Post;
import prajwal.in.repo.CommentRepository;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepo;

    @Override
    public void saveComment(Comment comment) {
        commentRepo.save(comment);
    }

    @Override
    public List<Comment> getCommentsByPost(Post post) {
        return commentRepo.findByPost(post);
    }
}
