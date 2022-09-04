/*
클래스 변수
- 인스턴스에 따라 값이 변하지 않을 경우
- 인스턴스를 생성할 필요가 없는 경우의 변수값
- 값의 변경 사항을 모든 인스턴스가 공유
클래스 메서드
- 인스턴스 메서드는 클래스 멤버에 접근 가능
- 클래스 메서드는 인스턴스 멤버에 접근 불가
*/
/*
인스턴스 변수 -> Non-static field
클래스 변수 -> static field
*/
class Calculator1 {
    static double Pie = 3.14; // static {member} -> class의 member
    static int base = 0; 
    int left, right;

    public void setOprands(int left, int right) {
        this.left = left;
        this.right = right;
    }
    public void sum() {
        System.out.println(this.left + this.right + base );
    }
    public void avg() {
        System.out.println((this.left + this.right + base) / 2 );
    }
}

class Calculator2 {
    public static void sum(int left, int right) {
        System.out.println(left+right);
    }
    public static void avg(int left, int right) {
        System.out.println((left+right)/2);
    }
}

class C1 {
    static int static_variable = 1;
    int instance_variable = 2;
    
    static void static_get_static_variable() {
        System.out.println(static_variable);
    }
    static void static_get_instance_variable() {
        // System.out.println(instance_variable); // Error - 인스턴스 변수에 접근 불가
    }
    void get_static_variable() {
        System.out.println(static_variable);
    }
    void get_instance_variable() {
        System.out.println(instance_variable);
    }
}

public class CalcMember {
    public static void main(String[] args) {

        Calculator1 c1 = new Calculator1();
        c1.setOprands(10, 20);
        c1.sum(); // 30

        Calculator1 c2 = new Calculator1();
        c2.setOprands(20, 40);
        c2.sum(); // 60

        Calculator1.base = 10;
        c1.sum(); // 40
        c2.sum(); // 70

        Calculator2.sum(10, 20); // 30
        Calculator2.avg(10, 20); // 15

        Calculator2.sum(20, 40); // 60
        Calculator2.avg(20, 40); // 30

        C1 c = new C1();
        c.static_get_static_variable(); // 1 - The static method static_get_static_variable() from the type C1 should be accessed in a static wayJava
        c.static_get_instance_variable(); // None - The static method static_get_static_variable() from the type C1 should be accessed in a static wayJava
        c.get_static_variable(); // 1
        c.get_instance_variable(); // 2
        C1.static_get_static_variable(); // 1
        C1.static_get_instance_variable(); // None
        // C1.get_static_variable(); // Error
        // C1.get_instance_variable(); // Error
    }
}