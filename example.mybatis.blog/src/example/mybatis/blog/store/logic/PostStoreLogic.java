package example.mybatis.blog.store.logic;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import example.mybatis.blog.domain.Post;
import example.mybatis.blog.store.PostStore;
import example.mybatis.blog.store.mapper.AuthorMapper;
import example.mybatis.blog.store.mapper.PostMapper;

public class PostStoreLogic implements PostStore {

	private SqlSessionFactory factory;

	PostStoreLogic() {
		factory = SqlSessionFactoryProvider.getSqlSessionFactory();
	}

	@Override
	public Post findPost(int id) {
		SqlSession session = factory.openSession();
		Post post = null;
		
		try {
			PostMapper mapper = session.getMapper(PostMapper.class);
			post = mapper.findPost(id);
		} finally {
			session.close();
		}
		return post;
	}

	@Override
	public List<Post> findAllPosts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Post> findPostsByBlogId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Post> findPostsByAuthorName(String authorName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Post> findPostsByBlogTitle(String blogTitle) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Post> findPostsBySubject(String subject) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Post> findPostsByContents(String contents) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int registPost(Post post) {
		SqlSession session = factory.openSession(); // 세션을 얻어옴
		int result = 0;
		try {
			PostMapper mapper = session.getMapper(PostMapper.class);
			result = mapper.registPost(post);
			
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
	public int updatePost(Post post) {
		SqlSession session = factory.openSession();
		int result = 0;
		
		try {
			PostMapper mapper = session.getMapper(PostMapper.class);
			result = mapper.updatePost(post);
			
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
	public int deletePost(int id) {
		SqlSession session = factory.openSession();
		int result = 0;
		
		try {
			PostMapper mapper = session.getMapper(PostMapper.class);
			result = mapper.deletePost(id);
			
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
