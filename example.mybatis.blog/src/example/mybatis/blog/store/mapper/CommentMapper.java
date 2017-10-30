package example.mybatis.blog.store.mapper;

import java.util.List;

import example.mybatis.blog.domain.Comment;

public interface CommentMapper {

	List<Comment> findCommentsByPostId(int postId);
}
