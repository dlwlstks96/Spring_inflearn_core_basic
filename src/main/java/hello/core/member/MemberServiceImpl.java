package hello.core.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component //컴포넌트 스캔 기능 이용하여 스프링 빈으로 등록하는 과정
public class MemberServiceImpl implements MemberService{

    //AppConfig에서 대신 주입, 주석 처리된 코드는 클라이언트(MemberServiceImple)에서 구현체에 의존한다는 문제점
    //private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final MemberRepository memberRepository;

    //생성자를 통해서 memberRepository에 구현체가 뭐가 들어갈지 결정
    @Autowired //의존관계를 자동으로 주입(컴포넌트 스캔과 연관되어 있는 내용)
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }


    //테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }

}