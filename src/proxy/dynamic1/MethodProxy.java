package proxy.dynamic1;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MethodProxy {

    private Object target;
    @SuppressWarnings("rawtypes")
    private Class clazz;
    private Method method;
    private Object[] params;

    public MethodProxy(Object target, String methodName, Object... params) {

        rebindTarget(target, methodName, params);
    }

    public void rebindTarget(Object target, String methodName, Object... params) {
        this.target = target;
        this.clazz = target.getClass();
        rebindMethod(methodName, params);

    }

    @SuppressWarnings("unchecked")
    public void rebindMethod(String methodName, Object... params) {
        this.params = params;
        int paramLength = params.length;
        @SuppressWarnings("rawtypes")
        Class[] paramTypes = new Class[paramLength];
        for (int i = 0; i < paramLength; i++) {
            paramTypes[i] = params[i].getClass();
        }

        try {
            this.method = this.clazz.getMethod(methodName, paramTypes);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void doPersonMethod() {
        try {
            System.out.println("doPersonMethod - preprocess");
            this.method.invoke(target, params);
            System.out.println("doPersonMethod - postprocess");
        } catch (IllegalArgumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void doLoverMethod() {
        try {
            System.out.println("doLoverMethod - preprocess");

            Low low = (Low) this.getAnnotation(Low.class);
            int minBoyAge = low.boyAge();
            int minGirlAge = low.girlAge();
            int boyAge = 0;
            int girlAge = 0;
            if (params[0] instanceof Lover) {
                boyAge = ((Lover) params[0]).getAge();
            }
            if (params[1] instanceof Lover) {
                girlAge = ((Lover) params[1]).getAge();
            }

            if (boyAge >= minBoyAge && girlAge >= minGirlAge) {
                this.method.invoke(target, params);
            } else {
                System.out.println("Unable to love now!");
            }

            System.out.println("doLoverMethod - postprocess");
        } catch (IllegalArgumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    protected Annotation getAnnotation(@SuppressWarnings("rawtypes") Class aclazz) {
        return this.method.getAnnotation(aclazz);
    }

}
