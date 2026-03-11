package com.moa.project2.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.moa.project2.dto.Post;
import com.moa.project2.mapper.PostMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostMapper postMapper;

    @Override
    public List<Post> list() throws Exception {
        List<Post> list = postMapper.list();
        return list;
    }

    @Override
    public Post select(int no) throws Exception {
        Post post = postMapper.select(no);
        return post;
    }

    @Override
    public boolean insert(Post post) throws Exception {
        int result = postMapper.insert(post);
        return result > 0;
    }

    @Override
    public boolean update(Post post) throws Exception {
        int result = postMapper.update(post);
        return result > 0;
    }

    @Override
    public boolean delete(int no) throws Exception {
        int result = postMapper.delete(no);
        return result > 0;
    }

    @Override
    public PageInfo<Post> list(int page, int size) throws Exception {
        PageHelper.startPage(page, size);
        List<Post> postList = postMapper.list();
        PageInfo<Post> pageInfo = new PageInfo<Post>(postList, 10);
        return pageInfo;
    }
    
}
