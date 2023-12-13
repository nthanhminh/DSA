    // Complete the mergeLists function below.

    /*
     * For your reference:
     *
     * SinglyLinkedListNode {
     *     int data;
     *     SinglyLinkedListNode next;
     * }
     *
     */
    static SinglyLinkedListNode mergeLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
        SinglyLinkedListNode p=new SinglyLinkedListNode(-1);
        SinglyLinkedListNode tmp=p;
        while(head1!=null && head2!=null)
        {
            if(head1.data<=head2.data)
            {
                tmp.next=head1;
                head1=head1.next;
                tmp=tmp.next;
            }
            else
            {
                tmp.next=head2;
                head2=head2.next;
                tmp=tmp.next;
            }
        }
        while(head1!=null)
        {
            tmp.next=head1;
            head1=head1.next;
            tmp=tmp.next;
        }
        while(head2!=null)
        {
            tmp.next=head2;
            head2=head2.next;
            tmp=tmp.next;
        }
        return p.next;
    }