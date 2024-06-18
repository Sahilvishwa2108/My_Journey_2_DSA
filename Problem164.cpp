/* 148. Sort List
Given the head of a linked list, return the list after sorting it in ascending order.

 

Example 1:


Input: head = [4,2,1,3]
Output: [1,2,3,4]
Example 2:


Input: head = [-1,5,3,4,0]
Output: [-1,0,3,4,5]
Example 3:

Input: head = []
Output: []
 

Constraints:

The number of nodes in the list is in the range [0, 5 * 104].
-105 <= Node.val <= 105
 

Follow up: Can you sort the linked list in O(n logn) time and O(1) memory (i.e. constant space)? */

class Solution {
 public:
  ListNode* sortList(ListNode* head) {
    const int length = getLength(head);
    ListNode dummy(0, head);

    for (int k = 1; k < length; k *= 2) {
      ListNode* curr = dummy.next;
      ListNode* tail = &dummy;
      while (curr) {
        ListNode* l = curr;
        ListNode* r = split(l, k);
        curr = split(r, k);
        auto [mergedHead, mergedTail] = merge(l, r);
        tail->next = mergedHead;
        tail = mergedTail;
      }
    }

    return dummy.next;
  }

 private:
  int getLength(ListNode* head) {
    int length = 0;
    for (ListNode* curr = head; curr; curr = curr->next)
      ++length;
    return length;
  }

  ListNode* split(ListNode* head, int k) {
    while (--k && head)
      head = head->next;
    ListNode* rest = head ? head->next : nullptr;
    if (head != nullptr)
      head->next = nullptr;
    return rest;
  }

  pair<ListNode*, ListNode*> merge(ListNode* l1, ListNode* l2) {
    ListNode dummy(0);
    ListNode* tail = &dummy;

    while (l1 && l2) {
      if (l1->val > l2->val)
        swap(l1, l2);
      tail->next = l1;
      l1 = l1->next;
      tail = tail->next;
    }
    tail->next = l1 ? l1 : l2;
    while (tail->next)
      tail = tail->next;

    return {dummy.next, tail};
  }
};