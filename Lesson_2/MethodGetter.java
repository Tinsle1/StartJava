import java.lang.reflect.Method;

public class MethodGetter {
    public String getMethodName() {
        String caller = Thread.currentThread().getStackTrace()[2].getMethodName();
        return caller;
    }
}