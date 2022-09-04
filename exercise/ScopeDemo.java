package exercise;
// Scope( 유효범위 ) : 전역 변수 및 지역 변수

class C {
    int v = 10;

    void m() {
        System.out.println(v);
    }
}

class C2 {
    int v = 10;

    void m() {
        int v = 20;
        System.out.println(v);
    }
}

class C3 {
    int v = 30;

    void m() {
        int v = 20;
        System.out.println(this.v); // 인스턴스 자신의 변수값을 호출
    }
}

public class ScopeDemo {

    static int i = 5;

    static void a() {
        int i = 10;
        b(); 
    }

    static void b() {
        System.out.println(i);
    }

    public static void main(String[] args) {
        a(); // 5
        
        C c1 = new C();
        c1.m(); // 10

        C2 c2 = new C2();
        c2.m(); // 20

        C3 c3 = new C3();
        c3.m(); // 30
    }
}
