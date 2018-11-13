package com.wx.base;

public interface LinearList {
    //接口中的变量都是static final的
    public int size();//返回线性表长度的大小
    public boolean isEmpty();//判断线性表是否为空
    public void add(int index, Object element);//指定位置插入元素
    public void add(Object element);//在线性表的末尾添加元素
    public void remove(Object elementm);//移除指定位置的元素
    public void clear();//清空链表
    public Object get(int index); //根据链表下标返回元素

}
