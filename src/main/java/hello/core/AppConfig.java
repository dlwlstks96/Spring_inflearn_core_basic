package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration; //구성정보(설정정보)

//애플리케이션 전체를 설정하고 구성, 앱 실제 동작에 필요한 구현 객체를 생성 (공연 기획자)
//없을 경우 CGLIB 바이트 코드 조작하는 라이브러리 사용 X, 내부 메소드들까지 빈은 전부 등록 되지만 싱글톤 보장 X (중요!)
@Configuration //없을 경우 순수 자바 코드 -> 있을 경우 스프링으로 변환
public class AppConfig {

    //구현체가 생성자를 통해 주입(생성자 주입)
    @Bean //없을 경우 순수 자바 코드 -> 있을 경우 스프링으로 변환
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    @Bean //스프링 컨테이너에 등록
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }



}
