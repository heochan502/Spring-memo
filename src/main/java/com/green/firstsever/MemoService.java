package com.green.firstsever;


import com.green.firstsever.model.MemoGetOneRes;
import com.green.firstsever.model.MemoGetRes;
import com.green.firstsever.model.MemoPostReq;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor // 생성자 알아서 만들어준다
@Service // 빈등록 // 스프링 컨테이너가 객체화를 시키고 그 주소값을 들고있는거
public class MemoService  {
    //Persistance DB 작업 처리(로직+DB작업지시 )
    //생성자로 주입 받고 싶음.
    private final MemoMapper memoMapper;
//    public MemoService(MemoMapper memoMapper) {
//        this.memoMapper = memoMapper;
//    }
    //메소드 명이랑 xml 이름 이랑 같아야 실행 하고 데이터를 가져오고 연결한다

    public int insMemo(MemoPostReq req) {
        return memoMapper.insMemo(req);
    }

    public List<MemoGetRes> selMemoList() {
        return memoMapper.selMemoList();
    }

    public MemoGetOneRes selMemo(int id) {
        return memoMapper.selMemo(id);
    }
}
