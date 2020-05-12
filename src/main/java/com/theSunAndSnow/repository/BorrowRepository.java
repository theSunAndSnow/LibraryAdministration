package com.theSunAndSnow.repository;

import com.theSunAndSnow.entity.Borrow;

import java.util.List;

public interface BorrowRepository {
    public void insert(Integer readerId, Integer bookId, String borrowTime, String returnTime, Integer adminId, Integer state);

//    查询读者的所有借书记录
    public List<Borrow> findAllByReaderId(Integer readerId);
}
