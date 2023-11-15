package com.harshet.cache.cache;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.harshet.cache.cache.Exceptions.NotFound;

public interface Icache<key,value> {

    void put(key k,value v) throws NotFound;
    value get(key k) throws NotFound;

    String getAll() ;
}
