package com.green.firstsever;


import com.green.firstsever.model.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


//RestController는 백엔드에서 데이터만 가지고올꺼니까
//백엔드에서 화면 그리면  Controller 쓰면됨
@RestController //빈(Bean)등록, 스프링컨테이너 객체 생성을 대리로 맡긴다. 요청 / 응답자 둘다된다
@RequiredArgsConstructor //final만 붇은애만 해준다 롬복 에노테이션 자동으로 생성자를 만들어주는것
public class MemoController
{
    private final MemoService memoService;
// 외부에서 만든 주소 객체를 주입 하는게 DI 임
    // 다이렉트 인젝션
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
    // 경로 방식을 왜적었냐 뒤 아래 둘다 get을 쓰고잇어서 명확하게 할려고
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

    @PutMapping("/memo")
    public String putMemo(@RequestBody MemoPutReq req) {
        System.out.println("postMemo: " + req);
        int result = memoService.updMemo(req);
        return result == 1 ? "성공" : "실패";
    }
    @DeleteMapping("/memo")
    public String deleteMemo(@RequestParam int id) {
        System.out.println("deleteMemo: " + id);
        int result = memoService.delMemo(id);
        return result == 1 ? "성공" : "실패";
    }


}
