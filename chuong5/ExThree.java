
import javax.persistence.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;
import java.util.Properties;
// CLASS PRODUCT 
@Entity
@Table(name = "products")
class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name", nullable = false, length = 100)
    private String name;
    @Column(name = "price", precision = 10, scale = 2)
    private double price;
    public Product() {}
    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    @Override
    public String toString() {
        return "Product [id=" + id + ", name=" + name + ", price=" + price + "]";
    }
}
// CLASS CHÍNH
public class ExThree {
    public static void main(String[] args) {
        
        SessionFactory factory = null;
        Session session = null; 
        try {
            factory = createSessionFactory();
            session = factory.getCurrentSession();
            Product product1 = new Product("Laptop Dell XPS", 2500.0);
            Product product2 = new Product("MacBook Pro", 3500.0);
            Product product3 = new Product("Laptop Gaming", 1500.0);
            session.beginTransaction();
            System.out.println("📦 Đang lưu sản phẩm vào database...");
            session.save(product1);
            session.save(product2);
            session.save(product3);
            session.getTransaction().commit();
            System.out.println("\nLƯU THÀNH CÔNG!");
            System.out.println("====================================");
            System.out.println(product1);
            System.out.println(product2);
            System.out.println(product3);
            System.out.println("====================================");
        } catch (Exception e) {
            System.out.println("\nLỖI: " + e.getMessage());
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
            if (factory != null) {
                factory.close();
            }
        }
    }
    private static SessionFactory createSessionFactory() {
        try {
            Properties properties = new Properties();
            properties.setProperty("hibernate.connection.driver_class", "com.microsoft.sqlserver.jdbc.SQLServerDriver");
            properties.setProperty("hibernate.connection.url", "jdbc:sqlserver://DESKTOP-6CCNID2:1433;databaseName=JavaJDBC_DB;integratedSecurity=true;encrypt=true;trustServerCertificate=true");
            properties.setProperty("hibernate.connection.integratedSecurity", "true");
            properties.setProperty("hibernate.dialect", "org.hibernate.dialect.SQLServerDialect");
            properties.setProperty("hibernate.show_sql", "true");
            properties.setProperty("hibernate.format_sql", "true");
            properties.setProperty("hibernate.hbm2ddl.auto", "update");
            Configuration configuration = new Configuration();
            configuration.setProperties(properties);
            configuration.addAnnotatedClass(Product.class);
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties())
                    .build();
            return configuration.buildSessionFactory(serviceRegistry);
            
        } catch (Throwable ex) {
            System.err.println("Không thể tạo SessionFactory: " + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
}