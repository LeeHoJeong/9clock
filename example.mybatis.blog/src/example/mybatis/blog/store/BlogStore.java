package example.mybatis.blog.store;

import java.util.List;

import example.mybatis.blog.domain.Blog;

public interface BlogStore {

	Blog findBlog(int id);

	Blog findBlogByAuthorId(String authorId);

	List<Blog> findAllBlogs();

	List<Blog> findBlogsByTitle(String title);

	void registBlog(Blog blog);

	int updateBlog(Blog blog);

	int deleteBlog(Blog blog);
}
