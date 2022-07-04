package hello.hellospring.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemoryMemberRepository;

public class MemberServiceTest {

	MemberService memberService;
	MemoryMemberRepository memberRepository;
	
	@BeforeEach
	public void beforeEach() {
		memberRepository = new MemoryMemberRepository();
		memberService = new MemberService(memberRepository);
	}
	
	@AfterEach
	public void afterEach() {
	}
	//test 코드의 경우 한글로 해도 됨
	//test 코드는 실제 코드에포함 되지 않는다.  
	
	@Test
	public void 회원가입() {
		//given
		Member member = new Member();
		member.setName("hello");
		
		//when
		Long saveId = memberService.join(member);
		
		//then
		Member findMember = memberService.findOne(saveId).get();
		assertThat(member.getName()).isEqualTo(findMember.getName());
		
	}
	
	@Test
	public void 중복_회원_예외() {
		//given
		Member member1 = new Member();
		member1.setName("spring");;
		
		Member member2 = new Member();
		member2.setName("spring");
		
		//when
		
		memberService.join(member1);
		
		IllegalStateException e = assertThrows(IllegalStateException.class,
				() -> memberService.join(member2));
		//예외가 발생해야 한다.
		assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
		
/*		memberService.join(member1);
		try {
			memberService.join(member2);
		} catch (IllegalStateException e){
			assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
		}
*/
		//then
	}
	
	@Test
	public void findMembers() {
	}

	@Test
	public void findOne() {
	}
}
