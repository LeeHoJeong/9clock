package example.mybatis.blog.store.logic;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import example.mybatis.blog.domain.Author;
import example.mybatis.blog.store.AuthorStore;
import example.mybatis.blog.store.mapper.AuthorMapper;

public class AuthorStoreLogic implements AuthorStore {

	private SqlSessionFactory factory;

	public AuthorStoreLogic() {
		factory = SqlSessionFactoryProvider.getSqlSessionFactory();
	}

	@Override
	public Author findAuthor(String id) {
		SqlSession session = factory.openSession(); // 세션을 얻어옴

		Author author = null;

		try {
			AuthorMapper mapper = session.getMapper(AuthorMapper.class);
			author = mapper.findAuthor(id);
		} finally {
			session.close();
		}
		return author;
	}

	@Override
	public List<Author> findAllAuthor() {
		SqlSession session = factory.openSession();
		List<Author> list = new ArrayList<Author>();

		try {
			AuthorMapper mapper = session.getMapper(AuthorMapper.class);
			list = mapper.findAllAuthor();
		} finally {
			session.close();
		}
		return list;
	}

	@Override
	public List<Author> findAuthorsByName(String name) {
		SqlSession session = factory.openSession();
		List<Author> list = new ArrayList<Author>();

		try {
			AuthorMapper mapper = session.getMapper(AuthorMapper.class);
			list = mapper.findAuthorsByName(name);
		} finally {
			session.close();
		}
		return list;
	}

	@Override
	public List<Author> findAuthorsByIds(List<String> ids) {
		SqlSession session = factory.openSession();
		List<Author> list = null;

		try {
			AuthorMapper mapper = session.getMapper(AuthorMapper.class);
			list = mapper.findAuthorsByIds(ids);
		} finally {
			session.close();
		}
		return list;
	}

	@Override
	public List<Author> findAuthorsByCondition(Map<String, String> conditionMap) {
		SqlSession session = factory.openSession();
		List<Author> list = null;

		try {
			AuthorMapper mapper = session.getMapper(AuthorMapper.class);
			list = mapper.findAuthorsByCondition(conditionMap);
		} finally {
			session.close();
		}
		return list;
	}

	@Override
	public int registerAuthor(Author author) {
		SqlSession session = factory.openSession(); // 세션을 얻어옴
		int result = 0;

		try {
			AuthorMapper mapper = session.getMapper(AuthorMapper.class);
			result = mapper.registerAuthor(author);
			
			if(result > 0) {
				session.commit();
			} else {
				session.rollback();
			}
			return result;
		} finally {
			session.close();
		}

	}

	@Override
	public int updateAuthor(Author author) {
		SqlSession session = factory.openSession();
		int result = 0;
		
		try {
			AuthorMapper mapper = session.getMapper(AuthorMapper.class);
			result = mapper.updateAuthor(author);
			
			if(result > 0) {
				session.commit();
			} else {
				session.rollback();
			}
			return result;
		} finally {
			session.close();
		}

	}

	@Override
	public int deleteAuthor(String id) {
		SqlSession session = factory.openSession();
		int result = 0;
		
		try {
			AuthorMapper mapper = session.getMapper(AuthorMapper.class);
			result = mapper.deleteAuthor(id);
			
			if(result > 0) {
				session.commit();
			} else {
				session.rollback();
			}
			return result;
		} finally {
			session.close();
		}
	}

}
