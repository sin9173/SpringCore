package hello.core.autowired;

import hello.core.AppConfig;
import hello.core.AutoAppConfig;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.lang.Nullable;

import java.util.Optional;

@ComponentScan("hello.core")
public class AutoWiredTest {

    @Test
    void AutoWiredOption() {
        ApplicationContext ac2 = new AnnotationConfigApplicationContext(TestBean.class);
    }

    static class TestBean {

        @Autowired(required = false) //자동 주입할 대상이 없으면 수정자 메소드 자체가 호출 안됨
        public void setNoBean1(Member noBean1) {
            System.out.println("noBean1 = " + noBean1);
        }

        @Autowired
        public void setNoBean2(@Nullable Member noBean2) { //자동 주입할 대상이 없으면 null 이 입력됨
            System.out.println("noBean2 = " + noBean2);
        } 

        @Autowired
        public void setNoBean3(Optional<Member> noBean3) { //자동 주입할 대상이 없으면 Optional.empty 가 입력됨
            System.out.println("noBean3 = " + noBean3);
        }

    }

}
