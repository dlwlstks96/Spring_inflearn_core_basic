package hello.core.scan.filter;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyExcludeComponent { //이 어노테이션이 붙으면 컴포넌트 스캔에서 제외, 테스트를 위해 임의로 만든 것


}
