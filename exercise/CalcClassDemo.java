package exercise;
// class로 계산기 로직을 정의하여 인스턴스 생성, 실행
class Calculator { // class
    int left, right;

    public void setOprands(int left, int right) {
        this.left = left;
        this.right = right;
    }
    public void sum() {
        System.out.println(this.left+this.right);
    }
    public void avg() {
        System.out.println((this.left+this.right)/2);
    }
}

public class CalcClassDemo { 
    int left, right;
    public static void main(String[] args) {  
        Calculator cl = new Calculator(); // create instance
        cl.setOprands(10, 20);
        cl.sum();
        cl.avg();
        Calculator c2 = new Calculator();
        c2.setOprands(20, 40);
        c2.sum();
        c2.avg();
    }
}

/*
30
15
60
30
*/