package example.mybatis.blog.store.logic;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import example.mybatis.blog.domain.Blog;
import example.mybatis.blog.store.BlogStore;
import example.mybatis.blog.store.mapper.AuthorMapper;
import example.mybatis.blog.store.mapper.BlogMapper;

public class BlogStoreLogic implements BlogStore {

	private SqlSessionFactory factory;

	public BlogStoreLogic() {
		factory = SqlSessionFactoryProvider.getSqlSessionFactory();
	}

	@Override
	public Blog findBlog(int id) {
		SqlSession session = factory.openSession();
		Blog blog = null;

		try {
			BlogMapper mapper = session.getMapper(BlogMapper.class);
			blog = mapper.findBlog(id);
		} finally {
			session.close();
		}
		return blog;
	}

	@Override
	public Blog findBlogByAuthorId(String authorId) {
		SqlSession session = factory.openSession();
		Blog blog = null;

		try {
			BlogMapper mapper = session.getMapper(BlogMapper.class);
			blog = mapper.findBlogByAuthorId(authorId);
		} finally {
			session.close();
		}
		return blog;
	}

	@Override
	public List<Blog> findAllBlogs() {
		SqlSession session = factory.openSession();
		List<Blog> list = null;

		try {
			BlogMapper mapper = session.getMapper(BlogMapper.class);
			list = mapper.findAllBlogs();
		} finally {
			session.close();
		}
		return list;
	}

	@Override
	public List<Blog> findBlogsByTitle(String title) {
		SqlSession session = factory.openSession();
		List<Blog> list = null;

		try {
			BlogMapper mapper = session.getMapper(BlogMapper.class);
			list = mapper.findBlogsByTitle(title);
		} finally {
			session.close();
		}
		return list;
	}

	@Override
	public void registBlog(Blog blog) {
		SqlSession session = factory.openSession(); // 세션을 얻어옴

		try {
			BlogMapper mapper = session.getMapper(BlogMapper.class);
			mapper.registBlog(blog);
			session.commit();

		} finally {
			session.close();
		}

	}

	@Override
	public int updateBlog(Blog blog) {
		SqlSession session = factory.openSession(); // 세션을 얻어옴
		int result = 0;

		try {
			BlogMapper mapper = session.getMapper(BlogMapper.class);
			result = mapper.updateBlog(blog);

			if (result > 0) {
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
	public int deleteBlog(Blog blog) {
		SqlSession session = factory.openSession(); // 세션을 얻어옴
		int result = 0;

		try {
			BlogMapper mapper = session.getMapper(BlogMapper.class);
			result = mapper.deleteBlog(blog);

			if (result > 0) {
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
