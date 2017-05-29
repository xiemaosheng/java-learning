package com.structure.list;

import com.structure.list.skipList.SkipList;

/**
 * Created by Administrator on 2017/5/26 0026.
 */
public class Test {

    public static void main(String[] args) {
        SkipList s = new SkipList();
//      s.add("AAA", 122);
        int i=0;
        for(;i<30;i++){  //随机数字进行测试
            s.add(String.valueOf(i), i);
        }
        s.print();
        System.out.println("\n\n----------\n\n\n");
        if(s.find("22")!=null){ //查找
            System.out.println("\nOK");
        }else{//找不到
            System.out.println("\nfalse");

        }
        s.delNode("0"); //删除
        s.print();
    }
}
