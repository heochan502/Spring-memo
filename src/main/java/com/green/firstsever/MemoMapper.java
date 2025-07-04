package com.green.firstsever;


import com.green.firstsever.model.MemoGetOneRes;
import com.green.firstsever.model.MemoGetRes;
import com.green.firstsever.model.MemoPostReq;
import com.green.firstsever.model.MemoPutReq;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;
import java.util.List;

import java.util.List;
// 인터페이스가 implements한 클래스가 만들어지고 그 클래스를 객체화(주소값)을
// 스프링 컨테이너가 들고있다.(빈등록)
// 스프링 컨테이너가 객체 주소값을 들고 있을 수 있는건 빈등록이 되었기 때문
// 여기가 DB작업 하는곳 이다

@Mapper
public interface MemoMapper {
    //insert, update, delete 작업은 메소드 만들 때 리턴타입 int
    //select 타입은 리턴이 다름
    //아래 이름은 xml의 이름과 같아야함
    int insMemo(MemoPostReq req);
    List<MemoGetRes> selMemoList();
    // 이러고 service에서 리턴값 설정함
    MemoGetOneRes selMemo(int id);
    // 튜플이 몇개 들어갔구나 라고 몇개의 행이라고 리턴해서 숫자형으로 돌아옴
    int updMemo(MemoPutReq req);
    int delMemo(int id);
}
