import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
@Data
public class CompositeTwoKey implements Serializable {

    @Column(name = "student_name")
    private String studentName;

    @Column(name = "course_name")
    private String courseName;

    public CompositeTwoKey() {
    }

    public CompositeTwoKey(String studentName, String courseName) {
        this.studentName = studentName;
        this.courseName = courseName;
    }
}