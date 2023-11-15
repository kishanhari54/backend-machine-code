package com.harshet.cache.cache;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.harshet.cache.cache.Exceptions.NotFound;
import com.harshet.cache.cache.Exceptions.StorageFull;
import com.harshet.cache.cache.Storage.HashMapStorage;
import com.harshet.cache.cache.Storage.Storage;
import org.springframework.stereotype.Service;

import java.util.List;

public class cache<key,value> implements  Icache<key,value>{
    Storage<key, value> storage;
    ObjectMapper mapper = new ObjectMapper();
    public cache(Storage<key, value> storage) {
        this.storage = storage;
    }

    public void  put(key k,value v) throws NotFound {

        try{
            this.storage.add(k,v);
        }
        catch(StorageFull  ex){
                this.storage.clearAll(); // Empty cache
                put(k,v); // Try Adding Again.
        }
    }
    public value get(key k) throws NotFound {
        value v=  this.storage.get(k);
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
