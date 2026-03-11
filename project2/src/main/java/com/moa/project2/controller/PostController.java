package com.moa.project2.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.pagehelper.PageInfo;
import com.moa.project2.dto.Page;
import com.moa.project2.dto.Post;
import com.moa.project2.service.PostService;

import lombok.RequiredArgsConstructor;

@RequestMapping("/Post")
@Controller
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;
    
    // 게시글 목록
    @GetMapping("/list")
    public String list(Model model,
        @RequestParam(name="page", required = false, defaultValue = "1") Integer page,
        @RequestParam(name="size", required = false, defaultValue = "10") Integer size) throws Exception {
        
        PageInfo<Post> pageInfo = postService.list(page, size);
        Page pagination = new Page();
        pagination.setPage(page);
        pagination.setSize(size);
        pagination.setTotal(pageInfo.getTotal());

        List<Post> list = pageInfo.getList();
        model.addAttribute("list", list);
        model.addAttribute("pagination", pagination);
        model.addAttribute("pageInfo", pageInfo);
        return "Post/list";
    }
    
    // 게시글 조회
    @GetMapping("/read/{no}")
    public String readByPath(@PathVariable("no") Integer no, Model model) throws Exception {
        Post post = postService.select(no);
        model.addAttribute("post", post);
        return "Post/read";
    }
    
    // 게시글 등록
    @GetMapping("/insert")
    public String insert() {
        return "Post/insert";
    }
    

    // 게시글 등록 처리
    @PostMapping("/insert")
    public String insert(Post post) throws Exception {
        boolean result = postService.insert(post);
        if (result) {
            return "redirect:/Post/list";
        }
        return "redirect:/Post/insert?error";
    }

    
    // 게시글 수정
    @GetMapping("/update")
    public String update(@RequestParam("no") Integer no, Model model) throws Exception {
        Post post = postService.select(no);
        model.addAttribute("post", post);
        return "Post/update";
    }

    // 게시글 수정 처리
    @PostMapping("/update")
    public String update(Post post) throws Exception {
        boolean result = postService.update(post);
        if (result) {
            return "redirect:/Post/list";
        }
        int no = post.getNo();
        return "redirect:/Post/update?no=" + no + "&error";
    }
        
    // 게시글 삭제
    @PostMapping("/delete")
    public String delete(@RequestParam("no") Integer no) throws Exception { 
        boolean result = postService.delete(no);
        if (result) {
            return "redirect:/Post/list";
        }
        return "redirect:/Post/update?no=" + no + "&error";
    }
}
