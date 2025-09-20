import java.lang.reflect.Method;

public class MethodName {
    public String getCurrent() {
        return String caller = Thread.currentThread().getStackTrace()[2].getMethodName(); 
    }
}