package com.structure.sort;

/**
 * Created by Administrator on 2017/7/28 0028.
 */
public class ListNodeSort {

    /**
     * 链表归并排序 nlog(n)
     * 1 快慢指针 找出中间点
     * 2 划分左右链表
     * 3 合并
     *
     * @param head
     * @return
     */
    public static ListNode sort(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = head;    // 慢指针
        ListNode q = head.next; // 快指针
        // 找出中间节点
        while (q != null && q.next != null) {
            p = p.next;
            q = q.next.next;
        }

        ListNode right = sort(p.next);
        p.next = null;
        ListNode left = sort(head);
        return merge(left, right);
    }

    private static ListNode merge(ListNode left, ListNode right) {
        ListNode head = new ListNode(0);
        ListNode cur = head;
        while (left != null && right != null) {
            if (left.value > right.value) {
                cur.next = left;
                left = left.next;
            } else {
                cur.next = right;
                right = right.next;
            }
            cur = cur.next;
        }

        if (left == null){
            cur.next = right;
        }
        if (right == null){
            cur.next = left;
        }
        return head.next;
    }

    /**
     * 插入排序
     * @param head
     * @return
     */
    public static ListNode insertSort(ListNode head){
        if (head == null || head.next == null) {
            return head;
        }
        ListNode cur = new ListNode(0);
        // 递归，假设head.next后面链表有序
        cur.next = insertSort(head.next);

        ListNode p = cur.next;
        while (p != null && p.next != null && head.value > p.next.value){
            p = p.next;
        }
        head.next = p.next;
        p.next = head;

        return cur.next;
    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode(5);
        ListNode head2 = new ListNode(5);
        ListNode node1 = new ListNode(51);
        ListNode node2 = new ListNode(533);
        ListNode node3 = new ListNode(15);
        ListNode node4 = new ListNode(54);
        ListNode node5 = new ListNode(5321);
        ListNode node6 = new ListNode(225);
        ListNode node7 = new ListNode(115);
        ListNode node8 = new ListNode(5223);
        ListNode node9 = new ListNode(542);
        head1.next = node1;
        head2.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;
        node8.next = node9;
        node9.next = null;

//        ListNode test = sort(head1);

        ListNode insert = insertSort(head2).next;

        System.out.println("***********链表归并排序实现*********");
//        while (test !=null){
//            System.out.println(test.value);
//            test = test.next;
//        }
        System.out.println("***********链表插入排序实现*********");
        while (insert !=null){
            System.out.println(insert.value);
            insert = insert.next;
        }


    }

}

/**
 * 链表数据结构
 */
class ListNode {
    int value;
    ListNode next;

    public ListNode(int value) {
        this.value = value;
        this.next = null;
    }
}
