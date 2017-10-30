package example.mybatis.blog.store.mapper;

import java.util.List;

import example.mybatis.blog.domain.Tag;

public interface TagMapper {

	List<Tag> findTagsByPostId(int postId);
}
