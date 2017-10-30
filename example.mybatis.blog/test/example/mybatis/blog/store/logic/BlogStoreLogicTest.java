package example.mybatis.blog.store.logic;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import example.mybatis.blog.domain.Author;
import example.mybatis.blog.domain.Blog;
import example.mybatis.blog.store.AuthorStore;
import example.mybatis.blog.store.BlogStore;

public class BlogStoreLogicTest {

	private BlogStore store;
	private AuthorStore astore;

	@Before
	public void setUp() {
		store = new BlogStoreLogic();
		astore = new AuthorStoreLogic();
	}

//	@Test
//	public void testFindBlog() {
//		Blog blog = store.findBlog(1);
//		
//		assertEquals("하늘바람별", blog.getTitle());
//		assertEquals("demonpark", blog.getAuthor().getId());
//		assertNotNull(blog.getPosts());
//		// post를 가져옴
//		assertEquals(2, blog.getPosts().size());
//		assertEquals("mybatis", blog.getPosts().get(0).getSubject());
//	}
//
//	@Test
//	public void testFindBlogByAuthorId() {
//		Blog blog = store.findBlogByAuthorId("demonpark");
//		assertEquals(1,blog.getId());
//		assertEquals("하늘바람별", blog.getTitle());
//	}

//	@Test
//	public void testFindAllBlogs() {
//		List<Blog> list = store.findAllBlogs();
//		assertEquals(3, list.size());
//		
//	}

//	@Test
//	public void testFindBlogsByTitle() {
//		List<Blog> list = store.findBlogsByTitle("하늘바람별");
//		assertEquals("하늘바람별", list.get(0).getTitle());
//	}

//	@Test
//	public void testRegistBlog() {
//		Blog blog = new Blog();
//		Author author = astore.findAuthor("demonpark");
//				
//		blog.setTitle("언어");
//		blog.setAuthor(author);
//		store.registBlog(blog);		
//		assertNotNull(blog);
//		assertEquals("demonpark", blog.getAuthor().getId());
//		
//	}

//	@Test
//	public void testUpdateBlog() {
//		Blog blog = store.findBlog(4);
//		
//		blog.setTitle("선빈언니");
//		store.updateBlog(blog);
//		assertEquals("선빈언니", blog.getTitle());
//	}

	@Test
	public void testDeleteBlog() {
		Blog blog = store.findBlog(4);
		
		store.deleteBlog(blog);
		assertNotNull(blog);
	}

}
