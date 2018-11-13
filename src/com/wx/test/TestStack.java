package com.wx.test;

import com.wx.imp.WxStackImp;

public class TestStack {
   /*  * 基本思路：
            *  将字符串转成字符数组顺序读取，如果字符是一个开放符号则将该开放符号压栈。如果读到的符号是一个闭合符号，
            *  此时弹栈，将该闭合符号与栈中探出的元素进行比较。如果比较结果是二者相同，则继续读取。如果比较结果是二者
     *  不相等，此时直接返回false。*/


    public static void main(String[] agrs)
    {
        String s="{()}";
        TestStack testStack=new TestStack();
        boolean pingheng = testStack.isPingheng(s);
        System.out.print(pingheng);
    }
    public  boolean isPingheng(String s)
    {
        WxStackImp wxStack=new WxStackImp();
        char[] chars = s.toCharArray();
        for (int i=0;i<chars.length;i++)
        {
            if(chars[i]=='{')
            {
                wxStack.push(chars[i]);
            }else if (chars[i]=='}')
            {
                  if (wxStack.isEmpty())
                  {
                      return false;
                  }else {
                      char pop = (Character)wxStack.pop();
                      if (pop!='{')
                      {
                          return false;
                      }
                  }

            }

            if(chars[i]=='(')
            {
                wxStack.push(chars[i]);
            }else if (chars[i]==')')
            {
                if (wxStack.isEmpty())
                {
                      return false;
                }
                else
                    {
                        char pop = (Character)wxStack.pop();
                        if (pop!='(')
                        {
                            return false;
                        }
                    }
            }
        }
        //当所有的字符都匹配成功弹出来了以后，栈就空了
        if (wxStack.isEmpty())
        {
            return true;
        }
        return false;
    }
}
