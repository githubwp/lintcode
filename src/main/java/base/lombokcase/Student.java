package base.lombokcase;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;

@Data

//链式构造方法
@Accessors(chain = true)

//必填构造，配合属性@NonNull注解,与@Builder注解冲突
//@RequiredArgsConstructor(staticName = "of")

@Builder
public class Student {
//    @NonNull
    private String name;

//    @NonNull
    private String phone;

    private Integer age;

    public static void main(String[] args) {
//        Student a = Student.of("a", "181");
//        System.out.println(a);
        Student b = Student.builder().age(10).phone("1243").name("aa").build();
        System.out.println(b);
    }
}
