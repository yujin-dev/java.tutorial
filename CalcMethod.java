// Method로 작성한 계산기 예시
public class CalcMethod {
    public static void avg(int left, int right) {
        System.out.println((left+right)/2);
    }
    public static void sum(int left, int right) {
        System.out.println(left+right);
    }
    public static void main(String[] args) {
        int left, right;

        left = 10;
        right = 20;
        sum(left, right);
        avg(left, right);

        left = 20;
        right = 40;
        sum(left, right);
        avg(left, right);
    }
}

/*
30
15
60
30
*/