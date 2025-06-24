package com.green.firstsever;


import com.green.firstsever.model.MemoGetOneRes;
import com.green.firstsever.model.MemoGetRes;
import com.green.firstsever.model.MemoPostReq;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


//RestController는 백엔드에서 데이터만 가지고올꺼니까
//백엔드에서 화면 그리면  Controller 쓰면됨
@RestController //빈(Bean)등록, 스프링컨테이너 객체 생성을 대리로 맡긴다. 요청 / 응답자
@RequiredArgsConstructor // 자동으로 생성자를 만들어주는것
public class MemoController
{
    private final MemoService memoService;

    //DI 받는 방법 3가지
    // 1. 필드 주입
    // 2. setter 주입( 메소드 주입)
    // 3. 생성자 주입

//    public MemoController(MemoService memoService)
//    {
//        this.memoService = memoService;
//    }


    // 전체 글 리스트
    @GetMapping("/memo")
    public List<MemoGetRes> getMemo()
    {
        return memoService.selMemoList();
    }
// 특정 게시글의 글내용 및 댓글 리스트
    @GetMapping("/memo/{id}")
    public MemoGetOneRes getMemo(@PathVariable int id){
        System.out.println( "getMemo: " + id);
        return memoService.selMemo(id);
    }

    @PostMapping("/memo")
    public String postMemo(@RequestBody MemoPostReq req) //@RequestBody는 json데이터를 받을거야.
    {
        System.out.println( "Post Memo: " + req);
        int result = memoService.insMemo(req);
        return result == 1 ? "성공":"실패";
    }


}
