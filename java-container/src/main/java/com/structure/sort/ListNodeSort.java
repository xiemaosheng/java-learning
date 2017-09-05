package com.structure.sort;

import java.util.*;

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

        if (left == null) {
            cur.next = right;
        }
        if (right == null) {
            cur.next = left;
        }
        return head.next;
    }

    /**
     * 插入排序
     *
     * @param head
     * @return
     */
    public static ListNode insertSort(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode cur = new ListNode(0);
        // 递归，假设head.next后面链表有序
        cur.next = insertSort(head.next);

        ListNode p = cur.next;
        while (p != null && p.next != null && head.value > p.next.value) {
            p = p.next;
        }
        head.next = p.next;
        p.next = head;

        return cur.next;
    }

    public static ListNode reorderList(ListNode head) {
        if (head == null && head.next == null) {
            return head;
        }

        ListNode p = head;
        ListNode q = head;

        while (q != null && q.next != null) {
            p = p.next;
            q = q.next.next;
        }

        Stack<ListNode> stack = new Stack();

        p = p.next;
        while (p != null) {
            stack.push(p);
            p = p.next;
        }

        ListNode cur = head;

        while (stack.empty()) {
            ListNode node = stack.pop();
            ListNode temp = cur;
            cur = cur.next;
            node.next = temp.next;
            temp.next = node;
        }

        return head;
    }

    /**
     * 1 快慢指针找出中间节点
     * 2 头插法：反转链表
     * 3 合并链表
     *
     * @param head
     */
    public static void record(ListNode head) {
        if (head == null) {
            return;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 头插法：反转链表
        ListNode pre = slow.next;
        if (pre != null && pre.next != null) {
            ListNode next = pre.next;
            while (next != null) {
                pre.next = next.next;
                next.next = slow.next;
                slow.next = next;
                next = pre.next;
            }
        }
        mergeList(head, slow);
    }

    private static void mergeList(ListNode head, ListNode slow) {
        ListNode p = head;
        ListNode q = slow.next;
        while (q != null && p != null) {
            slow.next = q.next;
            q.next = p.next;
            p.next = q;
            q = slow.next;
            p = p.next.next;
        }
    }

    public static int singleNumber(int[] A) {
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
        }
        int i = get(A, sum);
        return A[i];
    }

    private static int get(int[] A, int sum) {
        for (int i = 0; i < A.length; i++) {
            int temp = sum - A[i];
            if (temp % 3 == 0) {
                return i;
            }
        }

        return -1;
    }

    public static int findSignleNumber(int[] a) {
        int[] bites = new int[32];
        for (int i = 0; i < 32; i++) {
            for (int j = 0; j < a.length; j++) {
                bites[i] += a[j] >> i & 1;
            }
        }

        int result = 0;
        for (int k = 0; k < 32; k++) {
            if (bites[k] % 2 != 0) {
                result += 1 << k;
            }
        }
        return result;
    }

    public static int longestConsecutive(int[] num) {
        List<Integer> list = new ArrayList();
        int maxLength = 0;
        for (int i = 0; i < num.length; i++) {
            int curAddNum = num[i];
            list.add(num[i]);
//            int curCutNum = num[i];
            int curAddLength = 0;
//            int curCutLength = 0;
//            int curMax = 0;
            while (list.contains(curAddNum)) {
                curAddLength++;
                curAddNum++;
            }

//            while(list.contains(curCutNum)){
//                curCutLength++;
//                curCutNum--;
//            }
//            curMax = Math.max(curAddLength,curCutLength);
            maxLength = Math.max(maxLength, curAddLength);
        }
        return maxLength;
    }

    public static int longestSeq(int[] num) {
        Map<Integer, Boolean> map = new HashMap<>();
        for (int n : num) {
            map.put(n, false);
        }
        Iterator<Integer> iterator = map.keySet().iterator();
        int max = 0;
        while (iterator.hasNext()) {
            Integer integer = iterator.next();
            if (map.get(integer)){
                continue;
            }
            int count = 0;
            while (map.containsKey(integer)){
                map.put(integer,true);
                count++;
                integer++;
            }
            max = Math.max(max,count);
        }

        return max;
    }


    public static void main(String[] args) {
        int[] a = new int[]{0, 1, 0, 1, 0, 1, 5};
        int[] b = new int[]{0, 1, 0, 1, 2};
//        System.out.println(singleNumber(a));
//        System.out.println(findSignleNumber(b));
//        System.out.println(0 >> 0);
        ListNode head1 = new ListNode(1);
        ListNode n1 = new ListNode(2);
        ListNode n2 = new ListNode(3);
        ListNode n3 = new ListNode(4);
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
        head1.next = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = null;
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

//        record(head1);
//
//        while (head1 != null) {
//            System.out.println(head1.value);
//            head1 = head1.next;
//        }

        int[] test = new int[]{100, 4, 8, 9, 7, 6, 200, 1, 2, 3, 5, 1};

        System.out.println(longestSeq(test));

//        ListNode test = sort(head1);

//        ListNode node = reorderList(head1);
//
//        while (node != null) {
//            System.out.println(node.value);
//            node = node.next;
//        }

//        ListNode insert = insertSort(head2).next;
//
//        System.out.println("***********链表归并排序实现*********");
////        while (test !=null){
////            System.out.println(test.value);
////            test = test.next;
////        }
//        System.out.println("***********链表插入排序实现*********");
//        while (insert !=null){
//            System.out.println(insert.value);
//            insert = insert.next;
//        }


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
