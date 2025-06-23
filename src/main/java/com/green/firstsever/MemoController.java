package com.green.firstsever;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


//RestController는 백엔드에서 데이터만 가지고올꺼니까
//백엔드에서 화면 그리면  Controller 쓰면됨
@RestController //빈(Bean)등록, 스프링컨테이너 객체 생성을 대리로 맡긴다. 요청 / 응답자
public class MemoController
{
    @GetMapping("/memo")
    public String getMemo()
    {
        return "Hello Board!";
    }

    @GetMapping("/memo/{board_id}")
    public String getMemo(@PathVariable("board_id") int boardId){
        System.out.println( "Board ID: " + boardId);
        return "Hello Board! - boardId: " + boardId;
    }

    @PostMapping("/memo")
    public String postMemo()
    {
        return "Post Board!!!";
    }
}
