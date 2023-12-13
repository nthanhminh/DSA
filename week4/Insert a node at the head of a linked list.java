    // Complete the insertNodeAtHead function below.

    /*
     * For your reference:
     *
     * SinglyLinkedListNode {
     *     int data;
     *     SinglyLinkedListNode next;
     * }
     *
     */
    static SinglyLinkedListNode insertNodeAtHead(SinglyLinkedListNode head, int data) {
        SinglyLinkedListNode newNode = new SinglyLinkedListNode(data);

        if (head == null) {
            return newNode;
        }

        newNode.next = head;
        return newNode;
    }