import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import java.util.List;
public class ExFour {
    public static void main(String[] args) {
        
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Product.class)
                .buildSessionFactory();
        
        Session session = null;
        try {
            session = factory.getCurrentSession();
            session.beginTransaction();
            String hql = "FROM Product WHERE price > :minPrice ORDER BY price DESC";
            Query<Product> query = session.createQuery(hql, Product.class);
            query.setParameter("minPrice", 1000.0);
            List<Product> expensiveProducts = query.getResultList();
            System.out.println("==========================================");
            System.out.println("=== SẢN PHẨM CÓ GIÁ > 1000 ===");
            System.out.println("==========================================");
            System.out.printf("%-5s | %-25s | %-10s%n", "ID", "TÊN SẢN PHẨM", "GIÁ");
            System.out.println("------------------------------------------");
            if (expensiveProducts.isEmpty()) {
                System.out.println("Không có sản phẩm nào giá > 1000");
            } else {
                for (Product p : expensiveProducts) {
                    System.out.printf("%-5d | %-25s | $%-9.2f%n", 
                        p.getId(), p.getName(), p.getPrice());
                }
            } 
            System.out.println("==========================================");
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
            factory.close();
        }
    }
}