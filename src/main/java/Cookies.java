import java.lang.reflect.Method;

/**
 * @author Sup4eg
 */

@ControlledObject(name = "biscuits")
public class Cookies {

    @StartObject
    public void createCookie() {
        //business logic
    }

    @StopObject
    public void stopCookie() {
        //business logic
    }

    public static void main(String[] args) {
        try {
            Class<?> cl = Class.forName("Cookies");
            if (!cl.isAnnotationPresent(ControlledObject.class)) {
                System.err.println("no annotation");
            } else {
                System.out.println("class annotated ; name - " + cl.getAnnotation(ControlledObject.class));
            }
            boolean hasStart = false;
            boolean hasStop = false;
            Method[] method = cl.getMethods();
            for (Method md: method) {
                if(md.isAnnotationPresent(StartObject.class)) {hasStart = true;}
                if(md.isAnnotationPresent(StopObject.class)) {hasStop = true;}
                if (hasStart && hasStop) {break;}
            }
            System.out.println("Start annotation - " + hasStart + "; Stop annotation - " + hasStop);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
