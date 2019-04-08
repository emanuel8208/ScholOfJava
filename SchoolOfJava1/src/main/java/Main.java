import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import objects.Cat;
import config.ProjectConfig;
public class  Main {

    public static void main (String Args []) {
        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ProjectConfig.class)){
            Cat c = context.getBean(Cat.class);
            System.out.println(c.name);
        }
    }
}
