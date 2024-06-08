package com.Gitto.plantler;

import com.Gitto.plantler.domain.members.entity.Member;
import com.Gitto.plantler.domain.members.repository.MemberRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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
		System.out.println(protoMember);
	}



}
