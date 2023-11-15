package com.harshet.cache.cache.EvictionPolicy;

public interface EvictionPolicy<key> {

    void keyAccessed(key Key);
    key keyToEvict();
}
