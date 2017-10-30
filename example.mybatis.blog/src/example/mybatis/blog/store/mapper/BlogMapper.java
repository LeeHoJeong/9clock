package example.mybatis.blog.store.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import example.mybatis.blog.domain.Blog;

public interface BlogMapper {

	// resultmap
	@Results({
		@Result(property="id", column="blog_id"),
		@Result(property="title", column="title"),
		@Result(property="author", column="author_id", one = @One(select = "example.mybatis.blog.store.mapper.AuthorMapper.findAuthor")),
		// store method상태
		@Result(property="posts", column="blog_id", many=@Many(select="example.mybatis.blog.store.mapper.PostMapper.findPostsByBlogId"))
		// 직접 입력
	})
	@Select("SELECT blog_id, title, author_id FROM blog_tb WHERE blog_id = #{id}")
	
	Blog findBlog(int id);

	// xml에서 사용 BlogMapper.xml

	Blog findBlogByAuthorId(String authorId);
	
	
	
	@Results({
		@Result(property="id", column="blog_id"),
		@Result(property="title", column="title"),
		@Result(property="author", column="author_id", one = @One(select ="example.mybatis.blog.store.mapper.AuthorMapper.findAuthor")),
		// store method상태
		@Result(property="posts", column="blog_id", many=@Many(select="example.mybatis.blog.store.mapper.PostMapper.findPostsByBlogId"))
		// 직접 입력
	})
	@Select ("SELECT blog_id, title, author_id FROM blog_tb ORDER by blog_id")
	List<Blog> findAllBlogs();


	List<Blog> findBlogsByTitle(String title);

	void registBlog(Blog blog);

	int updateBlog(Blog blog);

	int deleteBlog(Blog blog);
}
