package com.harshet.cache.cache.Storage;

import com.harshet.cache.cache.Exceptions.NotFound;
import com.harshet.cache.cache.Exceptions.StorageFull;

import java.util.HashMap;
import java.util.Map;

public class HashMapStorage<Key,Value>  implements  Storage<Key,Value>{
    Map<Key,Value> storage = new HashMap<>();
    int capacity;
    public HashMapStorage(int capacity){
        this.capacity = capacity;
    }
    @Override
    public void add(Key key, Value value) throws StorageFull {
        if(storageFull()) {
            throw new StorageFull("Storage Full");
        }
        storage.put(key,value);
    }

    @Override
    public void remove(Key key) throws NotFound {
        if(!storage.containsKey(key)) {
            throw new NotFound("Not Found");
        }
        storage.remove(key);
    }

    @Override
    public Value get(Key key) throws NotFound {
        if(!storage.containsKey(key)){
            throw new NotFound("Key Not Found");
        }
        return storage.get(key);
    }

    private boolean storageFull(){
        return storage.size() == capacity;
    }

    public Map<Key,Value> getAll(){
        return this.storage;
    }
    public boolean clearAll(){
        this.storage = new HashMap<>();
        return true;
    }
}
