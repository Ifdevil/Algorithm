package exercise;

public class Test {

    public static Test t1 = new Test();
    private final int a;
    public Test(){
        this.a = 1;
    }
    public int getA(){
        return a;
    }
    public static void main(String[] args) {
        Test t = new Test();
        System.out.println(t.t1.getA());
    }
}
