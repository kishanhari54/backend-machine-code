package com.harshet.cache.cache.EvictionPolicy;

import com.harshet.cache.cache.DataStructures.DoublyLinkedListNode;
import com.harshet.cache.cache.DataStructures.DoublyLinkedlist;

import java.util.HashMap;
import java.util.Map;

public class LRUEviction<key> implements  EvictionPolicy<key>{

    private DoublyLinkedlist<key> dll = new DoublyLinkedlist<>();
    private Map<key, DoublyLinkedListNode<key>> mapper = new HashMap<>();
    @Override
    public void keyAccessed(key Key) {
    // Check if Key Exist , then if true , move it to last node of linked list , if false , add
        if(mapper.containsKey(Key)){
            //dll.detachNode( mapper.get(Key));
            //dll.addNodeToLast(mapper.get(Key));
            dll.shiftToLast(mapper.get(Key));
        }
        else {
            DoublyLinkedListNode<key> node = new DoublyLinkedListNode<>(Key);
            node =  dll.addElementToLast(Key);
            mapper.put(Key,node);
        }
    }

    @Override
    public key keyToEvict() {
        DoublyLinkedListNode<key> first =  this.dll.getFirstElement();
        if(first == null) {
            return null;
        }
        dll.detachNode(first); // To Remove this from our tracking
        mapper.remove(first.getElement());
        return first.getElement();
    }

}
