package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class TestInvocationHandler implements InvocationHandler{
	
	private Object obj;
	
	public TestInvocationHandler(Object obj){
		this.obj = obj;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		
			return method.invoke(this.obj, args);
		
	}

}
