/* 234. Palindrome Linked List

Given the head of a singly linked list, return true if it is a 
palindrome
 or false otherwise.

 

Example 1:


Input: head = [1,2,2,1]
Output: true
Example 2:


Input: head = [1,2]
Output: false
 

Constraints:

The number of nodes in the list is in the range [1, 10^5].
0 <= Node.val <= 9
 

Follow up: Could you do it in O(n) time and O(1) space? */



/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
    public:
        bool isPalindrome(ListNode* head) {
            if (head == NULL || head->next == NULL) {
                return true;
            }
    
            // Copy the linked list
            ListNode* original = head;
            ListNode* copy = new ListNode(head->val);
            ListNode* temp = copy;
    
            while (original->next != NULL) {
                temp->next = new ListNode(original->next->val);
                temp = temp->next;
                original = original->next;
            }
    
            // Reverse the copied list
            ListNode *current = copy;
            ListNode *prev = NULL;
            ListNode *next = NULL;
    
            while (current != NULL) {
                next = current->next;
                current->next = prev;
                prev = current;
                current = next;
            }
    
            ListNode* reversed = prev;
    
            // Compare original and reversed linked lists
            while (head != NULL && reversed != NULL) {
                if (head->val != reversed->val) {
                    return false;
                }
                head = head->next;
                reversed = reversed->next;
            }
    
            return true;
        }
    };
    