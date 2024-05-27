package com.example.SpringBoot3.repository;

import com.example.SpringBoot3.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Member findByEmail(String email);


}
