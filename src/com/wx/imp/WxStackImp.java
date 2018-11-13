package com.wx.imp;

import com.wx.base.WxStack;

import java.util.EmptyStackException;

public class WxStackImp implements WxStack {
    private WxArrList stackList=null;
    public WxStackImp()
    {
        stackList=new WxArrList();
    }
    //压入元素进栈
    @Override
    public void push(Object e) {
        stackList.add(e);
    }
    //弹出栈顶的元素并删除栈顶的元素
    @Override
    public Object pop() {
        Object o = stackList.get(size() - 1);
        stackList.remove(o);
        return o;
    }
    //查询栈顶的值
    @Override
    public Object peek() {
        if (stackList.size()==0)
        {
            throw new EmptyStackException();
        }
        return stackList.get(size()-1);
    }
    //判断栈是否为空
    @Override
    public boolean isEmpty() {
        return stackList.isEmpty();
    }
    //返回栈的大小
    @Override
    public int size() {
        return stackList.size();
    }
}
