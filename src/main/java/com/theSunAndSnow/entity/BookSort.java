package com.theSunAndSnow.entity;

/**
 * 封装 BookeSort 表中的数据
 */
public class BookSort {
    private Integer id;
    private String name;

    public BookSort() {
    }

    public BookSort(Integer id, String name) {
        this.id = id;
        this.name = name;
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
}
