import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by harshit.rathod on 1/2/16.
 */
public class mainApp {

    public static void main(String[] asd) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        BlogDAOImpl blogDAO = (BlogDAOImpl) context.getBean("blogDAO");
        Blog b = new Blog("harshit", "Hello", "hsahghaghgahgahgsahagagjajagj");
        blogDAO.insert(b);
        blogDAO.delete(1);
        System.out.println(b.getUsername());
        System.out.println(b.getTitle());
        System.out.println(b.getContent());

    }
    }
