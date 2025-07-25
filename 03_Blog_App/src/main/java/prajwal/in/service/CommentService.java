package prajwal.in.service;

import java.util.List;
import prajwal.in.enity.Comment;
import prajwal.in.enity.Post;

public interface CommentService {
    void saveComment(Comment comment);
    List<Comment> getCommentsByPost(Post post);
}
