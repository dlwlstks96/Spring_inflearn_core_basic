package hello.core.singleton;

public class StatefulService {

    //private int price; //상태를 유지하는 필드, 싱글톤에서 이런 식의 공유 필드 사용하면 안됨!!! 중요!!
    //스프링 빈은 항상 무상태로 설계하자!!

    public int order(String name, int price) {
        System.out.println("name = " + name + " price = " + price);
        return price;
    }

//    public int getPrice() {
//        return
//    }

}
