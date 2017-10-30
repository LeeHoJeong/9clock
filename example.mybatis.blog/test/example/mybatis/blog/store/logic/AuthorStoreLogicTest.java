package example.mybatis.blog.store.logic;



import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import example.mybatis.blog.domain.Author;
import example.mybatis.blog.store.AuthorStore;

public class AuthorStoreLogicTest {

	private AuthorStore store;
	@Before
	public void setUp(){
		store = new AuthorStoreLogic();
	}

//	@Test
//	public void testFindAuthor() {
//		Author author = store.findAuthor("demonpark");
//		assertNotNull(author);
//		assertEquals("demonpark", author.getId());
//	}

//	@Test
//	public void testFindAllAuthor() {
//		List<Author> list = store.findAllAuthor();
//		assertEquals(5, list.size());
//		assertEquals("한승용", list.get(0).getName());
//	}

//	@Test
//	public void testFindAuthorsByName() {
//		List<Author> list = store.findAuthorsByName("박데몬");
//		assertEquals("박데몬", list.get(0).getName());
//		
//	}

//	@Test
//	public void testFindAuthorsByIds() {
//		List<String> ids = new ArrayList<String>();
//		// 아이디를 여러개 보내줌
//		ids.add("demonpark");
//		ids.add("kimgisa");
//		
//		List<Author> list = store.findAuthorsByIds(ids);
//		assertEquals(2, list.size());
//		
//	}

//	@Test
//	public void testFindAuthorsByCondition() {
//		
//		Map<String, String> map = new HashMap<String, String>();
//		map.put("id", "demonpark");
//		
//		List<Author> list = store.findAuthorsByCondition(map);
//		assertEquals(1, list.size());
//		
//		// id = null if문에 안들어감
//		// where이 통째로 빠져서 5개를 찾아옴
//		map.remove("id");
//		list = store.findAuthorsByCondition(map);
//		// map에 id가 없음
//		assertEquals(5, list.size());
//	}

//	@Test
//	public void testRegisterAuthor() {
//		Author author = new Author();
//
//		author.setId("jimin");
//		author.setPassword("111");
//		author.setName("박지민");
//		author.setEmail("jimin@naver.com");
//		
//		store.registerAuthor(author);
//		
//		assertNotNull(author);
//		assertEquals("jimin", author.getId());
//		
//	}

//	@Testㅊ
//	public void testUpdateAuthor() {
//		Author author = new Author();
//		author.setId("jimin");
//		author.setPassword("123");
//		author.setName("hojeong");
//		author.setEmail("123@naver.com");
//		store.updateAuthor(author);
//		assertEquals("hojeong", author.getName());
//	}

	@Test
	public void testDeleteAuthor() {
		Author author = new Author();

		store.deleteAuthor("jimin");

		assertNotNull(author);
	}

}
