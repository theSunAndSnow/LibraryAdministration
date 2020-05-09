package com.theSunAndSnow.entity;


public class Book {
    /*
    * 记住：实体类（entity）中的包装类的实例全部用类对象，不用基本类型
    * 因为数据库中的元组中的某个属性可能没有，只能返回 null
    * 而 基本数据类型(int、double)是不能接受 null 的！
    * 并且基本数据类型完全可以被类对象代替
    * */
    private Integer id;
    private String name;
    private String author;
    private String publish;
    private Integer pages;
    private Double price;
    private BookSort bookSort; // 面向对象形式的外键表示方法。

    public Book() {
    }

    public Book(Integer id, String name, String author, String publish, Integer pages, Double price, BookSort bookSort) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.publish = publish;
        this.pages = pages;
        this.price = price;
        this.bookSort = bookSort;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublish() {
        return publish;
    }

    public void setPublish(String publish) {
        this.publish = publish;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public BookSort getBookSort() {
        return bookSort;
    }

    public void setBookSort(BookSort bookSort) {
        this.bookSort = bookSort;
    }
}
