package com.harshet.cache.cache.DataStructures;

public class DoublyLinkedlist<E> {

    DoublyLinkedListNode<E> dummyHead;
    DoublyLinkedListNode<E> dummytail;

    public DoublyLinkedlist(){
        // Initiate dummy head and tail and link them
        this.dummyHead = new DoublyLinkedListNode<E>(null);
        this.dummytail = new DoublyLinkedListNode<E>(null);

        this.dummytail.prev = this.dummyHead;
        this.dummyHead.next = this.dummytail;
    }

    public void detachNode(DoublyLinkedListNode node){
        if(node != null) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
    }

    public  void shiftToLast(DoublyLinkedListNode node){
        this.detachNode(node);
        dummytail.prev.next = node;
        node.next = dummytail;
    }

    public void addNodeToLast(DoublyLinkedListNode node){
        DoublyLinkedListNode tail = dummytail;

        node.next = dummytail;
        node.prev = tail.prev;
        tail.prev.next = node;
        tail.prev = node;
    }

    public DoublyLinkedListNode addElementToLast(E Element){
        DoublyLinkedListNode node = new DoublyLinkedListNode(Element);
        this.addNodeToLast(node);
        return node;
    }


    public  DoublyLinkedListNode getFirstElement() {
            /*if(!elementPresent()) {
                throw new Exception("No Data Found");
            }*/
            return dummyHead.next;
    }

    public  DoublyLinkedListNode getLastElement() {
       /* if(!elementPresent()) {
            throw new Exception("No Data Found");
        }*/
        return dummytail.prev;
    }

    private boolean elementPresent(){
        return dummyHead.next != dummytail;
    }





}
