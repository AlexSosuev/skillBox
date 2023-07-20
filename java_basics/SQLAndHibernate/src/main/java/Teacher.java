import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table (name = "Teachers")
@Getter
@Setter
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private int salary;

    private int age;
}