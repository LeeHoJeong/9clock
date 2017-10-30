package example.mybatis.blog.store;

import java.util.List;
import java.util.Map;

import example.mybatis.blog.domain.Author;

public interface AuthorStore {

	Author findAuthor(String id);
	List<Author> findAllAuthor();
	List<Author> findAuthorsByName(String name);
	List<Author> findAuthorsByIds(List<String> ids);
	List<Author> findAuthorsByCondition(Map<String, String> conditionMap);
	
	int registerAuthor(Author author);
	int updateAuthor(Author author);
	int deleteAuthor(String id);
}
