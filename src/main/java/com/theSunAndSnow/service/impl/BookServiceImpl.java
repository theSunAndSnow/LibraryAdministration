package com.theSunAndSnow.service.impl;

import com.theSunAndSnow.entity.Book;
import com.theSunAndSnow.entity.Borrow;
import com.theSunAndSnow.repository.BookRepository;
import com.theSunAndSnow.repository.BorrowRepository;
import com.theSunAndSnow.repository.impl.BookRepositoryImpl;
import com.theSunAndSnow.repository.impl.BorrowRepositoryImpl;
import com.theSunAndSnow.service.BookService;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class BookServiceImpl implements BookService {

    private BookRepository bookRepository = new BookRepositoryImpl();
    private BorrowRepository borrowRepository = new BorrowRepositoryImpl();
    private final int LENGTH = 3;

    @Override
    public List<Book> findAll(int page) {
        return bookRepository.findAll((page - 1) * LENGTH, LENGTH);
    }

    @Override
    public int getCount() {
        return bookRepository.getCount();
    }

    @Override
    public int getPages() {
        int count = bookRepository.getCount();
        int pages = 0;
        return pages = ((count - 1) / LENGTH) + 1; // 向上取整除法
    }

    @Override
    public void addBorrow(Integer bookId, Integer readerId) {

        Date date = new Date(); // 获取当前借书时间

//        需要将当前日期转换成数据库中datetime类型的日期格式
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String borrowTime = simpleDateFormat.format(date);

//        还书时间 默认为 借书时间 + 14天
        Calendar calendar = Calendar.getInstance(); // 因为 Calendar 是抽象类，所以需要这样获取
        int dates = calendar.get(Calendar.DAY_OF_YEAR) + 14; // 得到借书日期 + 14天后是一年中的第多少天

        /**
         * 将 calendar对象 的日期设置为 当前日期 + 14天后的新日期
         * set 的第一个参数表示以什么量度来设置新日期，我们以 一年中的天数 来设置
         * set 的第二个参数表示更新后的新天数
         */
        calendar.set(Calendar.DAY_OF_YEAR, dates);

        Date returnDate = calendar.getTime(); // 将 Calendar 再转化成 Date 类
        String returnTime = simpleDateFormat.format(returnDate);

        borrowRepository.insert(readerId, bookId, borrowTime, returnTime, null, 0); // 定义成包装类的好处就体现了

    }

    @Override
    public List<Borrow> findAllBorrowByReaderId(Integer readerId) {
        return borrowRepository.findAllByReaderId(readerId);
    }

}
