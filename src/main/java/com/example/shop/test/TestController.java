package com.example.shop.test;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/test")
@RestController
public class TestController {

    @Autowired
    BaseService service;
    ObjectMapper mapper = new ObjectMapper();

    @GetMapping("/entity/{id}")
    public TestEntity getOneEntity(@PathVariable String id) {
        return service.getOneEntity(id);
    }

    @GetMapping("/entity")
    public List<TestEntity> fillAndGetRepo() {
        return service.getAllTestEntities();
    }

    @PostMapping("/entity")
    public TestEntity postEntity(@RequestBody TestEntity entity) {
        return service.addEntity(entity);
    }

    @PostMapping("/addElements")
    public void addElements() {
        service.fillRepo();
    }

    @DeleteMapping("/entity/{id}")
    public void deleteEntity(@PathVariable String id) {
        if (id == "-99") {
            service.clear();
        } else {
            service.deleteEntity(id);
        }
    }

    @DeleteMapping("/urmom")
    public void clearDB() {
        service.clear();

    }
}