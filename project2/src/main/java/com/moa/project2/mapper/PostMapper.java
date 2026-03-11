package com.moa.project2.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.moa.project2.dto.Post;

@Mapper
public interface PostMapper {
    List<Post> list() throws Exception;
    Post select(Integer no);
    int insert(Post post) throws Exception;
    int update(Post post) throws Exception;
    int delete(Integer no) throws Exception;
}
