package com.Gitto.plantler;

import com.Gitto.plantler.domain.members.entity.Member;
import com.Gitto.plantler.domain.members.repository.MemberRepository;
import com.Gitto.plantler.domain.plants.entity.Plants;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
class PlantlerApplicationTests {

	@Autowired
	private MemberRepository memberRepository;

	private Member protoMember;


	@Test
	void SetMember(){
		Member member = new Member();
		member.setUserid("TestUser");
		member.setPassword("1111");
		protoMember = memberRepository.save(member);
	}

	@Test
	void savePlant(){
		Plants plants = new Plants();
		plants.setPlantName("고무 나무");
		plants.setNickname("고무 고무 열매");
		plants.setSowingDate(LocalDate.now());
		System.out.println(plants);
	}

}
