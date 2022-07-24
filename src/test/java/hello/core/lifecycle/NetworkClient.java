package hello.core.lifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class NetworkClient {//implements InitializingBean, DisposableBean {

    private String url;

    public NetworkClient() {
        System.out.println("생성자 호출, url = " + url);
    }

    public void setUrl(String url) {
        this.url = url;
    }

    //서비스 시작시 호출
    public void connect() {
        System.out.println("connect : " + url);
    }

    public void call(String message) {
        System.out.println("call : " + url + " message = " + message);
    }

    //서비스 종료시 호출
    public void disconnect() {
        System.out.println("close : " + url);
    }


    //Bean 설정값으로 지정
//    public void init() throws Exception { //의존관계 주입이 끝나면 호출해줌
//        connect();
//        call("초기화 연결 메시지");
//    }
//
//
//    public void close() throws Exception { //빈이 종료될 때 호출됨
//        System.out.println("NetworkClient.destroy");
//        disconnect();
//    }

    @PostConstruct //자바에서 지원하는 어노테이션 //의존관계 주입이 끝나면 호출해줌
    public void init() throws Exception { //의존관계 주입이 끝나면 호출해줌
        connect();
        call("초기화 연결 메시지");
    }

    @PreDestroy
    public void close() throws Exception { //빈이 종료될 때 호출됨 //빈이 종료될 때 호출됨
        System.out.println("NetworkClient.destroy");
        disconnect();
    }




    //스프링에 의존적이고 최근에는 사용되지 않음
//    @Override
//    public void afterPropertiesSet() throws Exception { //의존관계 주입이 끝나면 호출해줌 (InitializingBean)
//        connect();
//        call("초기화 연결 메시지");
//    }
//
//    @Override
//    public void destroy() throws Exception { //빈이 종료될 때 호출됨 (DisposableBean)
//        System.out.println("NetworkClient.destroy");
//        disconnect();
//    }

}
