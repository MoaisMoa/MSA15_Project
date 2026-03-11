package com.moa.project.service;

import java.util.List;

import com.moa.project.dto.Post;

public interface PostService {
    List<Post> list() throws Exception;
    Post select(Integer no) throws Exception;
    boolean insert(Post post) throws Exception;
    boolean update(Post post) throws Exception;
    boolean delete(Integer no) throws Exception;
}
