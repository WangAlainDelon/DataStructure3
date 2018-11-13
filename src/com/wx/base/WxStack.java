package com.wx.base;

public interface WxStack {
    /*
     这是一个栈操作的接口
     */
    public void push(Object e);  //压入元素进栈
    public Object pop();         //弹出栈顶的值
    public Object peek();        //查询栈顶的值
    public boolean isEmpty();    //判断栈是否为空
    public int size();           //返回栈的大小
}
