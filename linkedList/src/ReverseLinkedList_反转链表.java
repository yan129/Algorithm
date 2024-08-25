/**
 * Created by IntelliJ IDEA.
 *
 * @author: Yan
 * @date: 2024/8/22
 */
public class ReverseLinkedList_反转链表 {

    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        ListNode node2 = new ListNode(6);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(1);
        ListNode node5 = new ListNode(8);

        // 构建一个简单的链表：4 -> 6 -> 2 -> 1 -> 8
        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        // 方法1
        ListNode reverseLinkedList = reverseLinkedList(head);
        while (reverseLinkedList != null) {
            System.out.print(reverseLinkedList.val + " -> ");
            reverseLinkedList = reverseLinkedList.next;
        }

        System.out.println();

        // 方法2
//        ListNode reverseLinkedList2 = reverseLinkedList_2(head);
//        while (reverseLinkedList2 != null) {
//            System.out.print(reverseLinkedList2.val + " -> ");
//            reverseLinkedList2 = reverseLinkedList2.next;
//        }

    }

    /**
     * 方法1：反转链表
     * @param head
     * @return
     */
    public static ListNode reverseLinkedList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        return prev;
    }

    /**
     * 方法2：递归反转链表
     * @param head
     * @return
     */
    public static ListNode reverseLinkedList_2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode newHead = reverseLinkedList_2(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }


    static class ListNode {
        private Integer val;
        private ListNode next;

        public ListNode(Integer val) {
            this.val = val;
        }
    }
}
