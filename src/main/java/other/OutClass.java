package other;

public class OutClass {

    String name;

    class MemberInnerClass {

        void innerClass() {
            System.out.println("this is InnerClass");
        }

    }


    public static void main(String[] args) {
        OutClass outClass = new OutClass();
        MemberInnerClass memberInnerClass = outClass.new MemberInnerClass();
        memberInnerClass.innerClass();
    }

}
