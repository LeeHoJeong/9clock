package example.mybatis.blog.store.logic;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import example.mybatis.blog.domain.Author;
import example.mybatis.blog.domain.Blog;
import example.mybatis.blog.domain.Post;
import example.mybatis.blog.store.AuthorStore;
import example.mybatis.blog.store.BlogStore;
import example.mybatis.blog.store.PostStore;

public class PostStoreLogicTest {

	private PostStore pstore;
	private AuthorStore astore;
	private BlogStore bstore;
	
	@Before
	public void setUp() {
		pstore = new PostStoreLogic();
		astore = new AuthorStoreLogic();
		bstore = new BlogStoreLogic();
	}
	@Test
	public void testFindPost() {
		Post post = pstore.findPost(1);
		Blog blog = bstore.findBlog(1);
		assertEquals(1, blog.getId());
		assertEquals("mybatis", post.getSubject());
	}

	@Test
	public void testFindAllPosts() {

	}

	@Test
	public void testFindPostsByBlogId() {

		
		
	}

	@Test
	public void testFindPostsByAuthorName() {

	}

	@Test
	public void testFindPostsByBlogTitle() {
	
	}

	@Test
	public void testFindPostsBySubject() {
	
	}

	@Test
	public void testFindPostsByContents() {
	
	}

	@Test
	public void testRegistPost() {
//		Post post = new Post();
//		Author author = astore.findAuthor("eykim");
//		Blog blog = bstore.findBlog(1);
//		
//		post.setSubject("java");
//		post.setContents("java programming");
//		post.setAuthor(author);
//		post.setBlog(blog);
//		pstore.registPost(post);
//		assertNotNull(post);
//		assertEquals(1, post.getBlog().getId());
	}

	@Test
	public void testUpdatePost() {
		
	}

	@Test
	public void testDeletePost() {
	}

}
