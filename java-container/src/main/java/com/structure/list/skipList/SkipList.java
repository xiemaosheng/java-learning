package com.structure.list.skipList;

import java.util.Random;

/**
 * Created by Administrator on 2017/5/26 0026.
 */
public class SkipList {
    private Node header; // 头节点
    private Node tail;   // 尾节点
    private int level;   // 层数
    private int size;   // 元素个数
    private Random random; // 每次的随机数用来确定需不需要增加层数

    public SkipList(){
        Node p1 = new Node(Node.header,0);
        Node p2 = new Node(Node.tail,0);
        header = p1;
        tail = p2;
        header.setRight(tail);
        header.setLeft(header);
        level = 0;
        size = 0;
        random = new Random();
    }

    public boolean isEmpty(){
        if (size == 0){
            return true;
        }
        return false;
    }

    // 找到插入位置的前一个节点
    public Node findF(String key){
        Node temp;
        temp = header;
        while(true){
            while (temp.getRight().getKey() != Node.tail && temp.getRight().getKey().compareTo(key) <= 0){
               /**
                * 当链表最底层不为空的时候，从当前层向尾部方向开始查找，直到查找temp.getRight的下一个值大于 当前k的值为止，此时temp小于或等于当前k的值
                *  要插入的位置即为temp之后的位置了
                */
               temp = temp.getRight();
            }
            if (temp.getDown() != null){
                temp = temp.getDown();
            }else {
                break;
            }
        }

        return temp;
    }

    public int add(String key,int value){
        Node temp;
        Node node;
        temp = findF(key);
        int i; // 当前层数
        if (key.equals(temp.getKey())){
            System.out.println("对象属性完全相同,无法添加！");
            int a = temp.getValue();
            return a;
        }

        node = new Node(key,value);
        node.setLeft(temp);
        node.setRight(temp.getRight());
        temp.getRight().setLeft(node);
        temp.setRight(node);

        i = 0;

        while(random.nextDouble() < 0.5){        // 进行随机，是否需要在上层添加
            if (i >= level){ // 如果当前层数超出了高度，则需要另间一层
                Node p1;
                Node p2;
                level = level + 1;
                p1 = new Node(Node.header,0);
                p2 = new Node(Node.tail,0);

                p1.setRight(p2);
                p1.setDown(header);

                p2.setLeft(p1);
                p2.setDown(tail);

                header.setUp(p1);
                header.setDown(p2);

                header = p1;
                tail = p2;

            }

            while(temp.getUp() == null){
                temp = temp.getLeft();
            }

            temp = temp.getUp();
            Node n = new Node(key,value);
            n.setLeft(temp);
            n.setRight(temp.getRight());
            n.setDown(node);

            temp.getRight().setLeft(node);
            temp.setRight(node);
            node.setUp(n);

            node = n;
            i= i + 1;
        }

        size = size + 1 ;


        return 0;
    }

    //节点查找
    public Node find(String k){
        Node temp=header;
        Node node;
        node=temp;
        System.out.println("查找路线"); //用于测试
        while(temp!=null){
            while(node.getRight().getKey()!=Node.tail&&node.getRight().getKey().compareTo(k)<=0){//&&node.getRight().getValue()!=v
                node=node.getRight();
                System.out.print("--->"+node.getKey());
            }

            if(node.getDown()!=null){
                node=node.getDown();
                System.out.print("--->"+node.getKey());
            }else{
                if(node.getKey().equals(k)){//&&node.getRight().value==v
                    //node.setValue(111111111); //修改
                    System.out.println("--->"+node.getKey());
                    System.out.print("--->"+node.getValue());

                    return node;
                }
                return null;
            }


        }
        return null;
    }
    //节点删除
    public void delNode(String k){  //调用查找函数，删除最底层的某个节点，并把其节点的左右相连，和链表操作一样，只是其上方若有则都需要调整
        Node temp=find(k);
        while(temp!=null){
            temp.getLeft().setRight(temp.getRight());
            temp.getRight().setLeft(temp.getLeft());
            temp=temp.getUp();
        }
    }
    public void print(){
        Node node;
        Node node1=header;


        while(node1!=null){
            int k=0;
            node=node1;
            while(node!=null){
                System.out.print(node.getKey()+"\t");
                k++;
                node=node.getRight();
            }

            System.out.print("\t");
            System.out.print("("+k+")");
            //System.out.print(node.getKey());
            System.out.println();
            //node=node1.getDown();
            node1=node1.getDown();

        }
    }

}
