import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        try (Session session = Connect.createSessionFactory().openSession()) {
            List<PurchaseList> list = session.createQuery("FROM PurchaseList", PurchaseList.class).getResultList();
            list.forEach(tmp -> {
                Transaction transaction = session.beginTransaction();
                LinkedPurchaseList linkedPurchaseList = new LinkedPurchaseList();
                Student student = session.createQuery("from Student s where s.name = :name", Student.class)
                        .setParameter("name", tmp.getStudentName()).getSingleResult();
                Course course = session.createQuery("from Course c where c.name = :name", Course.class)
                        .setParameter("name", tmp.getCourseName()).getSingleResult();
                linkedPurchaseList.setOneKey(new CompositeOneKey(student.getId(), course.getId()));
                session.saveOrUpdate(linkedPurchaseList);
                transaction.commit();
            });
            session.close();
        } catch (Exception ex) {
            ex.getStackTrace();
        }
    }
}