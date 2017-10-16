import java.lang.reflect.InvocationHandler
import java.lang.reflect.Method

interface Subject{
	void operation(String txt)
}
class ConcreteSubject implements Subject{
	void operation(String txt){
		println "ConcreteSubject operation:$txt"
	}
}
class DynamicProxy implements InvocationHandler{
	Subject realSubject
	public Object invoke(Object proxy, Method method, Object[] args)
	throws Throwable{
		println "before:"+method.name
		Object obj=null
		if(args){
			 obj=method.invoke(realSubject,args)
		}else{
			obj=method.invoke(realSubject)
		}
		println "after:"+args
		return obj
		
	}
	
}
Subject realSubject = new ConcreteSubject()
InvocationHandler handler = new DynamicProxy(realSubject:realSubject)

Subject s=(Subject)java.lang.reflect.Proxy.newProxyInstance(getClass().getClassLoader(), realSubject
		.getClass().getInterfaces(), handler)
s.operation("中国")
