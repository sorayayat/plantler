package com.Gitto.plantler.domain.members.repository;

import com.Gitto.plantler.domain.members.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findByUserid(String userid);
}
