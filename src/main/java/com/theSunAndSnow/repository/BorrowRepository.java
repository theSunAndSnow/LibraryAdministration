package com.theSunAndSnow.repository;

public interface BorrowRepository {
    public void insert(Integer readerId, Integer bookId, String borrowTime, String returnTime, Integer adminId, Integer state);
}
