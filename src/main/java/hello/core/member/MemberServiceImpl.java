package hello.core.member;

public class MemberServiceImpl implements MemberService{

    //추상화, 구현체 모두 의존하므로 구현체가 변경될 경우 의존하고 있는 코드도 변경해야함 (DIP 위반)
//    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final MemberRepository memberRepository;

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
}
