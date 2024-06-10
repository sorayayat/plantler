package com.Gitto.plantler;

import com.Gitto.plantler.domain.members.entity.Member;
import com.Gitto.plantler.domain.members.repository.MemberRepository;
import com.Gitto.plantler.domain.plants.entity.Plants;
import com.Gitto.plantler.domain.plants.repository.PlantsRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class PlantlerApplicationTests {

	@Autowired
	private MemberRepository memberRepository;

	@Autowired
	private PlantsRepository plantsRepository;

	private Member protoMember;

	@BeforeEach
	void setUp() {
		// 테스트 실행 전에 기존 데이터 삭제
		plantsRepository.deleteAll();
		memberRepository.deleteAll();

		// 회원 정보 설정 및 저장
		Member member = new Member();
		member.setUserid("TestUser");
		member.setPassword("1111");
		member.setRole("user");
		protoMember = memberRepository.save(member);
	}

	@Test
	void savePlant() {
		// 식물 정보 설정
		Plants plants = new Plants();
		plants.setPlantName("고무 나무");
		plants.setNickname("고무 고무 열매");
		plants.setSowingDate(LocalDate.now());
		plants.setMember(protoMember);

		// 식물 저장
		Plants savedPlant = plantsRepository.save(plants);

		// 저장된 식물 정보 확인
		Optional<Plants> foundPlant = plantsRepository.findById(savedPlant.getPlantId());
		assertThat(foundPlant).isPresent();
		assertThat(foundPlant.get().getNickname()).isEqualTo("고무 고무 열매");
	}

	@Test
	void deletePlant() {
		// 식물 정보 설정 및 저장
		Plants plants = new Plants();
		plants.setPlantName("고무 나무");
		plants.setNickname("고무 고무 열매");
		plants.setSowingDate(LocalDate.now());
		plants.setMember(protoMember);

		Plants savedPlant = plantsRepository.save(plants);

		// 식물 삭제
		plantsRepository.delete(savedPlant);

		// 삭제된 식물 정보 확인
		Optional<Plants> foundPlant = plantsRepository.findById(savedPlant.getPlantId());
		assertThat(foundPlant).isNotPresent();
	}
}
