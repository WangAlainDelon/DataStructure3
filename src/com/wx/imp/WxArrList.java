package com.wx.imp;


import com.wx.base.LinearList;

public class WxArrList implements LinearList {
    //顺序存储的链表底层用数组来实现
    private Object[] objectlist;
    //默认初始的链表的长度10,这个10外部看不到
    private int size;
    //链表的当前位置
    private int current=0;
    public WxArrList()
    {
        //如果初始化不指定list的长度，list的长度则为10
        this(10);
    }
    public WxArrList(int size)
    {
        //初始化指定list的长度
        if(size>0)
        {
            this.size=size;
            objectlist=new Object[size];
        }
        if (size==0)
        {
            objectlist=new Object[10];
        }
        //否则抛出异常，初始化参数不合法
    }
    /*
      返回链表长度的大小
     */
    @Override
    public int size() {
        //这个长度是此时链表中实际装有元素的多少
        return this.current;
    }
    /*
      判断链表是否为空
     */
    @Override
    public boolean isEmpty() {
        if (this.current==0)
        {
            return true;
        }
        return false;
    }
    /*
       向指定位置添加元素
     */
    @Override
    public void add(int index, Object element) {
        if(index>size&&index<0)
        {
           throw new IndexOutOfBoundsException("index"+index);
        }
        //先对链表进行扩容，再往后移动，再实现插入的操作
        //先判断数组是否已经满了，满了就扩容
        if(current+1>this.size-1)
        {
            size++;
            Object[] temp=new Object[size];
            for(int i=0;i<=objectlist.length-1;i++)
            {
                temp[i]=objectlist[i]; //这里转换后tem就少了一个元素
            }
            objectlist=null;
            objectlist=temp;
        }
        //把index后的元素往后挪动一位
        for (int i=current-1;i>=index;i--)
        {
            objectlist[i+1]=objectlist[i];
        }
        //index位置插入元素
        objectlist[index]=element;
        current++;
    }
    /*
     在链表的尾部添加元素
     */
    @Override
    public void add(Object element) {
        //初始的数组的大小为10或为自己指定的数，如何实现添加元素的功能
        //先判断当前数组是否满了，满了就扩容,每次的增量为1
        if (current>this.size-1)
        {
            this.size=size+1;
            Object[] temp=new Object[this.size];
            for (int i=0;i<current;i++)
            {
                temp[i]=objectlist[i];
            }
            objectlist=null;
            objectlist=temp;
        }
        objectlist[current]=element;
        current++;

    }

    @Override
    public void remove(Object elementm) {
        for (int i=0;i<objectlist.length;i++)
        {
            if (objectlist[i].equals(elementm))
            {
               for (int j=i;j<objectlist.length-1;j++)
               {
                   objectlist[j]=objectlist[j+1];
               }
               current--;
               break;
            }
        }
    }

    @Override
    public void clear() {

    }

    /*
      根据链表下标来访问元素
     */
    @Override
    public Object get(int index) {
        if(index>=0&&index<=this.size)
        {
            return objectlist[index];
        }
        return null;
    }

}
