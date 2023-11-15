package com.harshet.cache.cache;

import com.harshet.cache.cache.EvictionPolicy.LRUEviction;
import com.harshet.cache.cache.Storage.HashMapStorage;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class cacheFactory <key,value>{

    public cache<key,value> defaultCache(final int capacity){
        return new cache<key,value>(new HashMapStorage<key,value>(capacity),new LRUEviction<key>());
    }
}
