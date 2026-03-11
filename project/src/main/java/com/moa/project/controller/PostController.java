package com.moa.project.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.moa.project.dto.Post;
import com.moa.project.service.PostService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;


@RequestMapping("/Post")
@Controller
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;
    
    // 게시글 목록
    @GetMapping("/list")
    public String list(Model model) throws Exception {
        List<Post> list = postService.list();
        model.addAttribute("list", list);
        return "Post/list";
    }
    
    // 게시글 조회
    @GetMapping("/read")
    public String read(@RequestParam("no") Integer no, Model model) throws Exception {
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
        if(result){
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
        if(result){
            return "redirect:/Post/list";
        }
        int no = post.getNo();
        return "redirect:/Post/update?no=" + no + "&error";
    }
        
    // 게시글 삭제
    @PostMapping("/delete")
    public String delete(@RequestParam("no") Integer no) throws Exception { 
        boolean result = postService.delete(no);
        if(result){
            return "redirect:/Post/list";
        }
        return "redirect:/Post/update?no=" + no + "&error";
    }
    
    
    
}
