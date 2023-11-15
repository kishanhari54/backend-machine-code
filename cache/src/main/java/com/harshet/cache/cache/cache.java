package com.harshet.cache.cache;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.harshet.cache.cache.EvictionPolicy.EvictionPolicy;
import com.harshet.cache.cache.Exceptions.NotFound;
import com.harshet.cache.cache.Exceptions.StorageFull;
import com.harshet.cache.cache.Storage.HashMapStorage;
import com.harshet.cache.cache.Storage.Storage;
import org.springframework.stereotype.Service;

import java.util.List;

public class cache<key,value> implements  Icache<key,value>{
    Storage<key, value> storage;
    EvictionPolicy<key> policy;
    ObjectMapper mapper = new ObjectMapper();
    public cache(Storage<key, value> storage, EvictionPolicy<key> policy) {
        this.storage = storage;
        this.policy = policy;
    }

    public void  put(key k,value v) throws NotFound {

        try{
            this.storage.add(k,v);
            this.policy.keyAccessed(k);
        }
        catch(StorageFull  ex){
                //this.storage.clearAll(); // Empty cache
                //This will remove the LRU key
                key keyToEvict =  this.policy.keyToEvict();
                this.storage.remove(keyToEvict);

                put(k,v); // Try Adding Again.
        }
    }
    public value get(key k) throws NotFound {
        value v=  this.storage.get(k);
        this.policy.keyAccessed(k);
        return v;
    }

    public String getAll()  {
        try {
            String value= mapper.writeValueAsString(this.storage.getAll());
            return value;
        } catch (JsonProcessingException e) {
            return "Error";
        }

    }


}
