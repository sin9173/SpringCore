package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {
    public static void main(String[] args) {
        //클라이언트 코드에서 객체를 생성
//        MemberService memberService = new MemberServiceImpl();
        
        //AppConfig 에서 객체를 생성하도록 변경
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();

        //스프링 컨테이너에서 객체를 가져옴
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class); //스프링 컨테이너를 생성
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);


        Member findMember = memberService.findMember(1L);

        System.out.println("new member = " + member.getName());
        System.out.println("find Member = " + findMember.getName());

    }
}
