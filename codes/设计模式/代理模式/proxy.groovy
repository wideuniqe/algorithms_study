abstract class Subject{
	abstract void operation()
}
class ConcreteSubject extends Subject{
	void operation(){
		println "ConcreteSubject operation"
	}
}
class Proxy extends Subject{
	Subject realSubject
	void operation(){
		before()
		if(!realSubject){
			realSubject=new ConcreteSubject()
		}
		realSubject.operation()
		after()
	}
	void before(){
		println "before"
	}
	void after(){
		println "after"
	}
}

Subject s=new Proxy()
s.operation()