package com.harshet.cache.controller;

import com.harshet.cache.DTO.addToCache;
import com.harshet.cache.cache.Exceptions.NotFound;
import com.harshet.cache.services.CacheService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class cacheController {

    CacheService cacheService;
    public cacheController(CacheService service){
        this.cacheService = service;
    }
    @GetMapping("{Key}")
    public String testMethod(@PathVariable  String Key) throws NotFound {
        return this.cacheService.get(Key);
    }

    @GetMapping
    public String getAll(){
        return this.cacheService.getAll();
    }
    @PostMapping
    public String addEntry(@RequestBody addToCache data) throws Exception {
        return this.cacheService.put(data.getKey(),data.getValue());
    }
}
