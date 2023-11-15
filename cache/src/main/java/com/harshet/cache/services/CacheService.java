package com.harshet.cache.services;

import com.harshet.cache.cache.Exceptions.NotFound;
import com.harshet.cache.cache.Icache;
import com.harshet.cache.cache.Storage.HashMapStorage;
import com.harshet.cache.cache.cacheFactory;
import org.springframework.stereotype.Service;

@Service
public class CacheService {

    Icache<String,String> cache = new cacheFactory<String,String>().defaultCache(3);

    public String get(String key) throws NotFound {
        return this.cache.get(key);
    }

    public String put(String key,String value) throws Exception{

        try {
            this.cache.put(key, value);
            return value;
        }
        catch(NotFound ex){
            throw new Exception("Unknown Issue");
        }

    }

    public String getAll(){
        return this.cache.getAll();
    }

}
