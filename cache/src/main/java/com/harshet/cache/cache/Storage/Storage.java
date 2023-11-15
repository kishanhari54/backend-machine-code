package com.harshet.cache.cache.Storage;

import com.harshet.cache.cache.Exceptions.NotFound;
import com.harshet.cache.cache.Exceptions.StorageFull;

import java.util.HashMap;
import java.util.Map;


public interface Storage<Key,Value> {
    public void add(Key key, Value value) throws StorageFull;

    void remove(Key key) throws NotFound;

    Value get(Key key) throws NotFound;

    Map<Key,Value> getAll() ;
    boolean clearAll();
}
