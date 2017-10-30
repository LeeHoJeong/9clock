package example.mybatis.blog.store.mapper;

import java.util.List;

import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import example.mybatis.blog.domain.Post;

public interface PostMapper {
	@Results({ 
		@Result(property = "id", column = "id"), 
		@Result(property = "subject", column = "subject"),
		@Result(property = "contents", column = "contents"),      // map이 선언되어있지 않음
		@Result(property = "author", column = "author_id", one = @One(select = "AuthorStore.findAuthor")),
		// author라는 객체에서 author_id를 부르기 위해 query사용
		// AuthorStore에 findAuthor를 통해 찾아옴 author_id를 통해서 찾아와서 author에 넣어줌
		@Result(property = "blog", column = "blog_id", one = @One(select = "BlogStore.findBlog"))
		// xml -> mapper의 id가 잡힘 store X

	})
	@Select("SELECT id, subject, contents FROM post_tb WHERE blog_id = #{id}")

	List<Post> findPostsByBlogId(int id);

	Post findPost(int id);

	List<Post> findAllPosts();

	List<Post> findPostsByAuthorName(String authorName);

	List<Post> findPostsByBlogTitle(String blogTitle);

	List<Post> findPostsBySubject(String subject);

	List<Post> findPostsByContents(String contents);

	int registPost(Post post);

	int updatePost(Post post);

	int deletePost(int id);
}
