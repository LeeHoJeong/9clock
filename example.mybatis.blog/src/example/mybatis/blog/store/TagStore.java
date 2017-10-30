package example.mybatis.blog.store;

import java.util.List;

import example.mybatis.blog.domain.Tag;

public interface TagStore {

	List<Tag> findTagsByPostId(int postId);
	
}
