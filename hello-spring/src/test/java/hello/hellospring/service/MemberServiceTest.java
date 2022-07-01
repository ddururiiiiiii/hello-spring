package hello.hellospring.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemoryMemberRepository;

public class MemberServiceTest {

	MemberService memberService =  new MemberService();
	
	@AfterEach
	public void afterEach() {
	}
	//test 코드의 경우 한글로 해도 됨
	
	@Test
	public void 회원가입() {
		//given
		Member member = new Member();
		
		//when
		
		//then
	}
	
	@Test
	public void findMember() {
	}

	@Test
	public void findOne() {
	}
}
