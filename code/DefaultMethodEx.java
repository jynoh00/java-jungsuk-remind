public class DefaultMethodEx {
    public static void main(String[] args) {
        Child c = new Child();
        c.method1();
        c.method2();
        MyInterface.staticMethod();
        MyInterface2.staticMethod();
    }
}

class Child extends Parent implements MyInterface, MyInterface2 {
    // 여러 인터페이스에서 중복되는 이름의 메서드는 오버라이딩해야 한다.
    // 없으면 error
    public void method1() {
        System.out.println("method1() in Child");
    }
}

class Parent {
    // 조상 클래스의 메서드가 인터페이스의 디폴트 메서드와 충돌할 경우, 조상 클래스 메서드가 상속되며 디폴트 메서드는 무시
//    public void method2() {
//        System.out.println("method2() in Parent");
//    }
}

interface MyInterface {
    default void method1() {
        System.out.println("method1() in MyInterface");
    }

    default void method2() {
        System.out.println("method2() in MyInterface");
        privateMethod();
    }

    private void privateMethod() {
        System.out.println("privateMethod() in MyInterface");
    }

    static void staticMethod() {
        System.out.println("staticMethod() in MyInterface");
        privateStaticMethod();
    }

    private static void privateStaticMethod() {
        System.out.println("privateStaticMethod() in MyInterface");
    }
}

interface MyInterface2 {
    default void method1() {
        System.out.println("method1() in MyInterface2");
    }

    static void staticMethod() {
        System.out.println("staticMethod() in MyInterface2");
    }
}