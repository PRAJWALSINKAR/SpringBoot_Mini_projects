package prajwal.in.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpSession;
import prajwal.in.enity.Comment;
import prajwal.in.enity.Post;
import prajwal.in.enity.User;
import prajwal.in.service.CommentService;
import prajwal.in.service.PostService;

@Controller
public class PostController {

    @Autowired
    private PostService postService;

    
    
    
    @GetMapping("/")
    public String showHomePage(Model model, HttpSession session) {
        List<Post> allPosts = postService.getAllPosts();
        model.addAttribute("posts", allPosts);

        // This part ensures user's session is recognized on home page
        User loggedInUser = (User) session.getAttribute("user");
        if (loggedInUser != null) {
            model.addAttribute("user", loggedInUser);
        }

        return "index"; // or your home template name
    }


    
    // Show dashboard
    @GetMapping("/dashboard")
    public String showDashboard(HttpSession session, Model model) {
        User user = (User) session.getAttribute("user");
        if (user == null) return "redirect:/login";

        List<Post> posts = postService.getPostsByUser(user);
        model.addAttribute("posts", posts);
        return "dashboard";
    }

    // Show form to create a new post
    @GetMapping("/post/new")
    public String createPostForm(Model model) {
        model.addAttribute("post", new Post());
        return "create_post";
    }

    // Save new or updated post
    @PostMapping("/post/save")
    public String savePost(@ModelAttribute Post post, HttpSession session) {
        User user = (User) session.getAttribute("user");
        post.setUser(user);
        postService.savePost(post);
        return "redirect:/dashboard";
    }

    // Edit post
    @GetMapping("/post/edit/{id}")
    public String editPost(@PathVariable Integer id, Model model) {
        Post post = postService.getPostById(id);
        model.addAttribute("post", post);
        return "create_post";
    }

    // Delete post
    @GetMapping("/post/delete/{id}")
    public String deletePost(@PathVariable Integer id) {
        postService.deletePostById(id);
        return "redirect:/dashboard";
    }
    
    //for comments
    @Autowired
    private CommentService commentService;

    // View Blog Post + Show Comments + Comment Form
    @GetMapping("/post/view/{id}")
    public String viewPost(@PathVariable Integer id, Model model, HttpSession session) {
        Post post = postService.getPostById(id);
        List<Comment> comments = commentService.getCommentsByPost(post);

        model.addAttribute("post", post);
        model.addAttribute("comments", comments);
        model.addAttribute("comment", new Comment());

        User loggedInUser = (User) session.getAttribute("user");
        if (loggedInUser != null) {
            model.addAttribute("user", loggedInUser);
        }

        return "view_post";
    }



    // Handle Comment Submission
    @PostMapping("/post/comment")
    public String saveComment(@ModelAttribute Comment comment, @RequestParam Integer postId) {
        Post post = postService.getPostById(postId);
        comment.setPost(post);
        commentService.saveComment(comment);
        return "redirect:/post/view/" + postId;
    }

}
