package example.mybatis.blog.store;

import java.util.List;

import example.mybatis.blog.domain.Comment;

public interface CommentStore {

	List<Comment> findCommentsByPostId(int postId);
}
