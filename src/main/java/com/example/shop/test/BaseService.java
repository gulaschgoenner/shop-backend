package com.example.shop.test;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class BaseService {

    @Autowired
    TestRepository testrepo;

    public void fillRepo() {
        testrepo.save(new TestEntity("nonKey1"));
        testrepo.save(new TestEntity("nonKey2"));
        testrepo.save(new TestEntity("nonKey3"));
    }

    public TestEntity getOneEntity(String id) {
        return testrepo.findById(id).orElseThrow();
    }

    public List<TestEntity> getAllTestEntities() {
        List<TestEntity> list = new ArrayList<>();
        testrepo.findAll().forEach((te) -> list.add(te));
        return list;
    }

    public TestEntity addEntity(TestEntity entity) {
        return testrepo.save(entity);
    }

    public void deleteEntity(String id) {
        testrepo.delete(testrepo.findById(id).orElseThrow());
    }

    public void clear() {
        testrepo.deleteAll();
    }
}
