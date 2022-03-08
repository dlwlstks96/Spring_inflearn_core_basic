package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        basePackages = "hello.core", //어디서부터 찾을지 탐색 위치 설정(이거 없으면 모든 자바 코드, 라이브러리 다 뒤져야해서 시간, 메모리 낭비)
        //basePackageClasses = AutoAppConfig.class, //basePackage 지정 안하면 @ComponentScan 붙은 클래스의 동일, 하위 패키지 다 탐색
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
) //자동으로 스프링 빈 끌어올림
public class AutoAppConfig {



}
