import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
@Data
public class CompositeOneKey implements Serializable {

    @Column(name = "student_id")
    private int studentId;

    @Column(name = "course_id")
    private int courseId;

    public CompositeOneKey() {
    }
    public CompositeOneKey(int studentId, int courseId) {
        this.studentId = studentId;
        this.courseId = courseId;
    }
}