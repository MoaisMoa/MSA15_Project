package com.moa.project2.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.moa.project2.dto.Post;

public interface PostService {
    List<Post> list() throws Exception;
    Post select(int no) throws Exception;
    boolean insert(Post post) throws Exception;
    boolean update(Post post) throws Exception;
    boolean delete(int no) throws Exception;

    PageInfo<Post> list(int page, int size) throws Exception;
}
