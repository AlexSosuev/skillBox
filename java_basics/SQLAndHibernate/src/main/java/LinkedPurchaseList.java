import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table (name = "LinkedPurchaseList")
@Setter
@Getter
public class LinkedPurchaseList {

    @EmbeddedId
    private CompositeOneKey oneKey;

    @Column(name = "student_id", insertable = false, updatable = false)
    private int studentId;

    @Column(name = "course_id", insertable = false, updatable = false)
    private int courseId;

}