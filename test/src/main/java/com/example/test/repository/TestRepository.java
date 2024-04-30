package com.example.test.repository;

import com.example.test.entity.Test;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

public interface TestRepository extends CrudRepository<Test, Integer> {
   /*@Query("SELECT id FROM test ORDER BY RAND() limit 1") //database와 연결하는 기능
    Integer getRandomId();*/

    @Query("SELECT id FROM test WHERE id > 0 ORDER BY id DESC limit 1")
    Integer getRandomId();

    @Query("SELECT id FROM test ORDER BY id DESC limit 1")
    Integer endId(); // 제일 마지막 값을 구하는 변수
}
